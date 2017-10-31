package com.example.andres.community;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Range;
import android.widget.TextView;

import com.example.andres.community.model.BiblePosition;
import com.example.andres.community.model.BibleRange;
import com.example.andres.community.model.Book;
import com.example.andres.community.model.Quote;

import java.util.List;
import java.util.stream.Collectors;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(getAllBooksAsString());

//        BibleGroup bibleGroup = new BibleGroup("Pentateuco", "First group");

//        Book book = new Book("Génesis", 1, Testament.OLD, null);
//        book.save();

        BibleRange bibleRange = new BibleRange(
                Range.create(
                        new BiblePosition(1, 1),
                        new BiblePosition(1, 34)));
        Quote quote = new Quote(bibleRange, bibleRange.toString(), "first quote", 12);
        quote.save();
    }

    private String getAllBooksAsString() {
        return getAllBooks().stream().map(Book::toString).collect(Collectors.joining("\n"));
    }

    private List<Book> getAllBooks() {
        List<Book> books = Book.listAll(Book.class);
        return books;
    }
}
