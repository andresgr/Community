package com.asgr.community;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Range;

import com.asgr.community.model.BibleGroup;
import com.asgr.community.model.BiblePosition;
import com.asgr.community.model.BibleRange;
import com.asgr.community.model.Book;
import com.asgr.community.model.BookGroup;
import com.asgr.community.model.Quote;
import com.asgr.community.model.Testament;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DisplayMessageActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private static final Map<String, RecyclerView.Adapter> sEntityAdaptersByName =
            ImmutableMap.of(
//                    Book.class.getName(), new BookEntityAdapter(),
                    Quote.class.getName(), new QuoteEntityAdapter());
//            ,
//                    BookGroup.class.getName(), new BookGroupEntityAdapter());

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

        // specify an adapter (see also next example)
        Intent intent = getIntent();
        String entityName = intent.getStringExtra(MainActivity.EXTRA_ENTITY_NAME);
        mAdapter = getEntityAdapter(entityName);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void method() {

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_ENTITY_NAME);

        BibleGroup bibleGroup = new BibleGroup(1, "Pentateuco", "First group");
        bibleGroup.save();

        Book book = new Book("Génesis", 1, Testament.OLD);
        book.save();

        BibleRange bibleRange = new BibleRange(
                Range.create(
                        new BiblePosition(1, 1),
                        new BiblePosition(1, 34)));
        Quote quote = new Quote(bibleRange,"first quote", 12);
        quote.save();
    }

    private String getAllBooksAsString() {
        return getAllBooks().stream().map(Book::toString).collect(Collectors.joining("\n"));
    }

    private List<Book> getAllBooks() {
        List<Book> books = Book.listAll(Book.class);
        return books;
    }

    private String getAllQuotesAsString() {
        return getAllQuotes().stream().map(Quote::toString).collect(Collectors.joining("\n"));
    }

    private List<Quote> getAllQuotes() {
        List<Quote> quotes = Quote.listAll(Quote.class);
        return quotes;
    }

    public RecyclerView.Adapter getEntityAdapter(String entityName) {
        return sEntityAdaptersByName.get(entityName);
    }
}
