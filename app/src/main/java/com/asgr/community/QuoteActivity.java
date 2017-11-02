package com.asgr.community;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.asgr.community.model.BibleGroup;
import com.asgr.community.model.Book;
import com.asgr.community.model.Quote;
import com.asgr.community.support.LocalPersistence;
import com.asgr.community.support.Persistence;

public class QuoteActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Persistence mPersistence;

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
        mPersistence.init();

        // specify an adapter
        mAdapter = new QuoteEntityAdapter(mPersistence);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void addQuote(View view) {
//        mAdapter.notifyItemInserted();
        mAdapter.notifyDataSetChanged();
    }

}
