package com.asgr.community.model;

import android.support.annotation.NonNull;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import java.util.Optional;

import javax.annotation.Nonnull;

import hotchemi.stringpicker.StringPickerDialog;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by andres on 30/10/17.
 */

@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class Quote extends SugarRecord<Quote> implements Comparable<Quote> {

    private Book book;

    @Ignore @Getter(AccessLevel.PRIVATE)
    private Optional<BibleRange> maybeRange = Optional.empty();

    @Nonnull private String rangeAsStr;
    private String comment;
    private float punctuation;

    public Quote(Book book, BibleRange range) {
        this(book, range, "");
    }

    public Quote(Book book, BibleRange range, String comment) {
        this(book, range, comment, 0);
    }

    public Quote(Book book, BibleRange range, String comment, float punctuation) {
        this.book = book;
        this.maybeRange = Optional.of(range);
        this.rangeAsStr = buildRangeAsString();
        this.comment = comment;
        this.punctuation = punctuation;
    }

    public BibleRange getRange() {
        if (!maybeRange.isPresent()) {
            maybeRange = buildRangeFromString();
        }
        return maybeRange.get();
    }

    @Nonnull
    public String getRangeAsStr() {
        return rangeAsStr != null ? rangeAsStr : buildRangeAsString();
    }

    private String buildRangeAsString() {
        return maybeRange.get().toString();
    }

    private Optional<BibleRange> buildRangeFromString() {
        return Optional.of(BibleRange.parse(rangeAsStr));
    }

    @Override
    public int compareTo(@NonNull Quote other) {
        Book otherBook = other.getBook();
        int otherBookIndex = otherBook.getBookIndex();
        int bookIndex = book.getBookIndex();
        if (bookIndex < otherBookIndex) {
            return -1;
        } else if (bookIndex > otherBookIndex) {
            return 1;
        } else {
            return getRange().compareTo(other.getRange());
        }
    }

    public String getShortDescription() {
        return String.format("%s %s", book.getAbbreviation(), getRangeAsStr());
    }
}
