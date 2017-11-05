package com.asgr.community;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Button;

import com.asgr.community.model.Book;
import com.asgr.community.support.Persistence;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import hotchemi.stringpicker.StringPickerDialog;

/**
 * Created by andres on 3/11/17.
 */

public class AddQuoteFragment extends DialogFragment {

    private static final String BOOKS_KEY = "books";
    private static final String TAG = AddQuoteFragment.class.getSimpleName();

    private ArrayList<String> mBooks;
    private Button mButtonBook;

    static AddQuoteFragment newInstance(Persistence persistence) {
        AddQuoteFragment fragment = new AddQuoteFragment();

        Bundle args = new Bundle();
        args.putStringArrayList(
                BOOKS_KEY,
                persistence.findBooks().stream()
                        .sorted(Comparator.comparing(Book::getBookIndex))
                        .map(Book::getName)
                        .collect(Collectors.toCollection(ArrayList::new)));

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBooks = getArguments().getStringArrayList(BOOKS_KEY);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
//                .setIcon(R.drawable.alert_dialog_icon)
                .setTitle(R.string.add_quote_title)
                .setView(inflater.inflate(R.layout.dialog_add_quote, null))
                .setPositiveButton(
                        R.string.add_quote_ok,
                        (dialog, whichButton) -> {
                            Log.d(TAG, "Adding quote");
                            ((QuoteActivity) getActivity()).addQuote(
                                    mButtonBook.getText().toString(), 1, 1);
                        }
                )
                .setNegativeButton(
                        R.string.add_quote_cancel,
                        (dialog, whichButton) -> {
                            Log.d(TAG, "Cancelled quote adding");
                            ((QuoteActivity) getActivity()).addQuoteCancelled();
                        }
                );
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        mButtonBook = alertDialog.findViewById(R.id.buttonQuoteBook);
        mButtonBook.setOnClickListener(view -> {
            StringPickerDialog dialog = new StringPickerDialog();
            Bundle bundle = new Bundle();
            bundle.putStringArray(
                    getString(R.string.string_picker_dialog_values),
                    mBooks.toArray(new String[mBooks.size()]));
            dialog.setArguments(bundle);
            dialog.show(getFragmentManager(), "bookPicker");
        });
        return alertDialog;
    }

    public void onBookSelected(String bookName) {
        Log.d(TAG, "Book selected" + bookName);
        mButtonBook.setText(bookName);
    }
}
