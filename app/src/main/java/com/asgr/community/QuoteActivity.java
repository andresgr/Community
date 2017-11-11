package com.asgr.community;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;

import com.asgr.community.support.LocalPersistence;
import com.asgr.community.support.Persistence;

public class QuoteActivity extends AppCompatActivity {

    private static final String TAG = QuoteActivity.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private QuoteEntityAdapter mAdapter;
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
//        mPersistence.init();

        // specify an adapter
        mAdapter = new QuoteEntityAdapter(mPersistence);
        mRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                //Remove swiped item from list and notify the RecyclerView
                // TODO: Deal with indexes getOld...
                Log.i(TAG, String.format("Swiped item '%s'", viewHolder.getAdapterPosition()));
//                mAdapter.getItemId()
//                mPersistence.deleteQuote();

                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());

                // TODO: Launch snackbar to undo
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.refresh();
    }

    public void showAddQuoteDialog(View view) {
        Intent intent = new Intent(this, AddQuoteActivity.class);
        startActivity(intent);
    }

}
