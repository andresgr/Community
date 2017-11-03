package com.asgr.community;

/**
 * Created by andres on 3/11/17.
 */

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.AppCompatEditText;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.autofill.AutofillValue;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

import static android.content.ContentValues.TAG;

/**
 * A custom view that represents a {@link View#AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DATE} using
 * a non-editable {@link EditText} that triggers a {@link DatePickerDialog} to represent the
 * credit card expiration month and year.
 */
@RequiresApi(api = Build.VERSION_CODES.O)
public class BookPickerView extends AppCompatEditText {

    private static final int CC_EXP_YEARS_COUNT = 5;

    /**
     * Calendar instance used for month / year calculations. Should be reset before each use.
     */
    private final Calendar mTempCalendar;

    private int mMonth;
    private int mYear;

    public BookPickerView(@NonNull Context context) {
        this(context, null);
    }

    public BookPickerView(@NonNull Context context,
                                              @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BookPickerView(@NonNull Context context,
                                              @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // Use the current date as the initial date in the picker.
        mTempCalendar = Calendar.getInstance();
        mYear = mTempCalendar.get(Calendar.YEAR);
        mMonth = mTempCalendar.get(Calendar.MONTH);
    }

    /**
     * Gets a temporary calendar set with the View's year and month.
     */
    private Calendar getCalendar() {
        mTempCalendar.clear();
        mTempCalendar.set(Calendar.YEAR, mYear);
        mTempCalendar.set(Calendar.MONTH, mMonth);
        mTempCalendar.set(Calendar.DATE, 1);
        return mTempCalendar;
    }

    @Override
    public AutofillValue getAutofillValue() {
        Calendar c = getCalendar();
        AutofillValue value = AutofillValue.forDate(c.getTimeInMillis());
        Log.d(TAG, "getAutofillValue(): " + value);
        return value;
    }

    @Override
    public void autofill(AutofillValue value) {
        if (value == null || !value.isDate()) {
            Log.w(TAG, "autofill(): invalid value " + value);
            return;
        }
        long time = value.getDateValue();
        mTempCalendar.setTimeInMillis(time);
        int year = mTempCalendar.get(Calendar.YEAR);
        int month = mTempCalendar.get(Calendar.MONTH);
        Log.d(TAG, "autofill(" + value + "): " + month + "/" + year);
        setDate(year, month);
    }

    private void setDate(int year, int month) {
        mYear = year;
        mMonth = month;
        Date selectedDate = new Date(getCalendar().getTimeInMillis());
        String dateString = DateFormat.getDateFormat(getContext()).format(selectedDate);
        setText(dateString);
    }

    @Override
    public int getAutofillType() {
        return AUTOFILL_TYPE_DATE;
    }

    public void reset() {
        mTempCalendar.setTimeInMillis(System.currentTimeMillis());
        setDate(mTempCalendar.get(Calendar.YEAR), mTempCalendar.get(Calendar.MONTH));
    }

    public void showDatePickerDialog(FragmentManager fragmentManager) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.mParent = this;
        newFragment.show(fragmentManager, "datePicker");
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        private BookPickerView mParent;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            DatePickerDialog dialog = new DatePickerDialog(getActivity(),
                    R.style.AppTheme , this, mParent.mYear, mParent.mMonth, 1);

            DatePicker datePicker = dialog.getDatePicker();

            // Limit range.
            Calendar c = mParent.getCalendar();
            datePicker.setMinDate(c.getTimeInMillis());
            c.set(Calendar.YEAR, mParent.mYear + CC_EXP_YEARS_COUNT - 1);
            datePicker.setMaxDate(c.getTimeInMillis());

            // Remove day.
            datePicker.findViewById(getResources().getIdentifier("day", "id", "android"))
                    .setVisibility(View.GONE);
            return dialog;
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            mParent.setDate(year, month);
        }
    }
}