package com.asgr.community;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.asgr.community.model.BibleGroup;
import com.asgr.community.model.Book;
import com.asgr.community.model.Quote;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_ENTITY_NAME = "com.asgr.community.ENTITY_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showBooks(View view) {
        startDisplayActivity(view, Book.class.getName());
    }

    public void showGroups(View view) {
        startDisplayActivity(view, BibleGroup.class.getName());
    }

    public void startDisplayActivity(View view, String entityName) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_ENTITY_NAME, entityName);
        startActivity(intent);
    }

    public void startQuoteActivity(View view) {
        Intent intent = new Intent(this, QuoteActivity.class);
        startActivity(intent);
    }

}
