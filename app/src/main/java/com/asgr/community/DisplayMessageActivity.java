package com.asgr.community;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.asgr.community.model.BibleGroup;
import com.asgr.community.model.Book;
import com.asgr.community.model.Quote;
import com.asgr.community.support.LocalPersistence;
import com.asgr.community.support.Persistence;

public class DisplayMessageActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Persistence mPersistence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        mRecyclerView = findViewById(R.id.entityList);

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
        Intent intent = getIntent();
        String entityName = intent.getStringExtra(MainActivity.EXTRA_ENTITY_NAME);
        mAdapter = getEntityAdapter(entityName);
        mRecyclerView.setAdapter(mAdapter);
    }

    public RecyclerView.Adapter getEntityAdapter(String entityName) {
        if (Book.class.getName().equals(entityName)) {
            return new BookEntityAdapter(mPersistence.findBooks());
        } else if (Quote.class.getName().equals(entityName)) {
            return new QuoteEntityAdapter(mPersistence.findQuotes());
        } else if (BibleGroup.class.getName().equals(entityName)) {
            return new BibleGroupEntityAdapter(mPersistence.findGroups());
        } else {
            throw new IllegalArgumentException(
                    String.format("There is no know adapter for entity %s", entityName));
        }
    }
}
