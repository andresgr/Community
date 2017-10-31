package com.asgr.community.model;

import android.util.Range;

import java.sql.Statement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Created by andres on 30/10/17.
 */

@Getter @Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public class BibleRange {

    @NonNull private final Range<BiblePosition> range;

    @Override
    public String toString() {
        BiblePosition lower = range.getLower();
        BiblePosition upper = range.getUpper();
        if (lower.getChapter() != upper.getChapter()) {
            return String.format("%s - %d", lower, upper);
        } else if (lower.getVerse() != upper.getVerse()) {
            return String.format("%d, %d - %d",
                    lower.getChapter(), lower.getVerse(), upper.getVerse());
        } else {
            return String.format("%d, %d", lower.getChapter(), lower.getVerse());
        }
    }

    public static BibleRange parse(String rangeAsStr) {
        // TODO
        throw new UnsupportedOperationException();
    }
}
