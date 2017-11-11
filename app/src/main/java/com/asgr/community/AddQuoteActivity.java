package com.asgr.community;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.asgr.community.model.BiblePosition;
import com.asgr.community.model.BibleRange;
import com.asgr.community.model.Book;
import com.asgr.community.model.Quote;
import com.asgr.community.support.LocalPersistence;
import com.asgr.community.support.Persistence;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hotchemi.stringpicker.StringPickerDialog;

/**
 * Created by andres on 3/11/17.
 */

public class AddQuoteActivity extends AppCompatActivity implements StringPickerDialog.OnClickListener {

    private static final String BOOKS_KEY = "books";
    private static final String TAG = AddQuoteActivity.class.getSimpleName();

    private Persistence mPersistence;
    private ArrayList<String> mBooks;

    @BindView(R.id.buttonQuoteBook)
    Button mButtonBook;

    @BindView(R.id.buttonQuoteFromChapter)
    Button mButtonFromChapter;
    private Integer mFromChapter;

    @BindView(R.id.buttonQuoteFromVerse)
    Button mButtonFromVerse;
    private Integer mFromVerse;

    @BindView(R.id.buttonQuoteToChapter)
    Button mButtonToChapter;
    private Integer mToChapter;

    @BindView(R.id.buttonQuoteToVerse)
    Button mButtonToVerse;
    private Integer mToVerse;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPersistence = new LocalPersistence();
        mBooks = mPersistence.findBooks().stream()
                .sorted(Comparator.comparing(Book::getBookIndex))
                .map(Book::getName)
                .collect(Collectors.toCollection(ArrayList::new));

        setTitle(R.string.add_quote_title);
        setContentView(R.layout.activity_add_quote);
        ButterKnife.bind(this);

        mButtonBook.setOnClickListener(view -> {
            StringPickerDialog dialog = new StringPickerDialog();
            Bundle bundle = new Bundle();
            bundle.putStringArray(
                    getString(R.string.string_picker_dialog_values),
                    mBooks.toArray(new String[mBooks.size()]));
            dialog.setArguments(bundle);
            dialog.show(getSupportFragmentManager(), "bookPicker");
        });

        mButtonFromChapter.setOnClickListener(view -> getNumberDialog(view, numberAsString -> {
            mFromChapter = parseIntegerOrReturnNull(numberAsString);
            mButtonFromChapter.setText(numberAsString);
            if (mFromChapter != null && mToChapter == null) {
                mToChapter = mFromChapter;
                mButtonToChapter.setText(numberAsString);
            }
        }));
        mButtonFromVerse.setOnClickListener(view -> getNumberDialog(view, numberAsString -> {
            mFromVerse = parseIntegerOrReturnNull(numberAsString);
            mButtonFromVerse.setText(numberAsString);
            if (mFromVerse != null && mToVerse == null) {
                mToVerse = mFromVerse;
                mButtonToVerse.setText(numberAsString);
            }
        }));

        mButtonToChapter.setOnClickListener(view -> getNumberDialog(view, numberAsString -> {
            Integer toChapter = parseIntegerOrReturnNull(numberAsString);
            if (toChapter != null && toChapter >= mFromChapter) {
                mToChapter = toChapter;
                mButtonToChapter.setText(numberAsString);
            }
        }));

        mButtonToVerse.setOnClickListener(view -> getNumberDialog(view, numberAsString -> {
            Integer toVerse = parseIntegerOrReturnNull(numberAsString);
            if (toVerse != null) {
                mToVerse = toVerse;
                mButtonToVerse.setText(numberAsString);
            }
        }));
    }

    private Integer parseIntegerOrReturnNull(String val) {
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException ex) {
            Log.e(TAG, String.format("Error parsing integer %s", val));
            return null;
        }
    }

//    @OnClick({R.id.buttonQuoteFromChapter,
//            R.id.buttonQuoteFromVerse,
//            R.id.buttonQuoteToChapter,
//            R.id.buttonQuoteToVerse})
    private void getNumberDialog(View view, Consumer<String> consumer) {
        Button button = (Button) view;
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(String.format("Set %s", getNumberDialogTitle(button)));
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        input.setRawInputType(Configuration.KEYBOARD_12KEY);
        alert.setView(input);
        alert.setPositiveButton("Ok", (dialog, whichButton) -> {
            consumer.accept(input.getText().toString());
        });
        alert.setNegativeButton("Cancel", (dialog, whichButton) -> {
            //Put actions for CANCEL button here, or leave in blank
        });
        alert.show();
    }

    private String getNumberDialogTitle(Button button) {
        return button.getText().toString();
    }

    public void onBookSelected(String bookName) {
        Log.d(TAG, "Book selected" + bookName);
        mButtonBook.setText(bookName);
    }

    public void onAddQuote(View view) {
        String bookName = mButtonBook.getText().toString();
        Book book = mPersistence.findBookByName(bookName);
        Quote quote = new Quote(
                book,
                new BibleRange(
                        new BiblePosition(mFromChapter, mFromVerse),
                        new BiblePosition(mToChapter, mToVerse)));
        mPersistence.addQuote(quote);

        Toast toast = Toast.makeText(
                this,
                String.format("Added quote: %s", quote.getShortDescription()),
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 16, 16);
        toast.show();
    }

    public void onAddQuoteCancelled(View view) {
        finish();
    }

    @Override
    public void onClick(String value) {
        Log.d(TAG, "Clicked book " + value);
        onBookSelected(value);
    }

}
