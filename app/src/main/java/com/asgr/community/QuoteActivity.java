package com.asgr.community;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.asgr.community.model.BiblePosition;
import com.asgr.community.model.BibleRange;
import com.asgr.community.model.Book;
import com.asgr.community.model.Quote;
import com.asgr.community.support.LocalPersistence;
import com.asgr.community.support.Persistence;

import hotchemi.stringpicker.StringPickerDialog;

public class QuoteActivity extends AppCompatActivity implements StringPickerDialog.OnClickListener {

    private static final String TAG = QuoteActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Persistence mPersistence;
    private AddQuoteFragment mAddQuoteFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        mRecyclerView = findViewById(R.id.quoteList);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        mPersistence = new LocalPersistence();
//        mPersistence.init();

        // specify an adapter
        mAdapter = new QuoteEntityAdapter(mPersistence);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void showAddQuoteDialog(View view) {
        mAddQuoteFragment = AddQuoteFragment.newInstance(mPersistence);
        mAddQuoteFragment.show(getSupportFragmentManager(), "showAddQuoteDialog");
    }

    public void addQuote(String bookName, int chapter, int verse) {
        Book book = mPersistence.findBookByName(bookName);
        Quote quote = new Quote(book, new BibleRange(new BiblePosition(chapter, verse)));
        mPersistence.addQuote(quote);
//        mAdapter.notifyItemInserted();
        mAdapter.notifyDataSetChanged();
    }

    public void addQuoteCancelled() {
        mAddQuoteFragment = null;
    }

    @Override
    public void onClick(String value) {
        Log.d(TAG, "Clicked book " + value);
        if (mAddQuoteFragment != null) {
            mAddQuoteFragment.onBookSelected(value);
        }
    }
}
