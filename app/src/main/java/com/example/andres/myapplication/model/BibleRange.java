package com.example.andres.myapplication.model;

import android.util.Range;

import java.util.Arrays;
import java.util.stream.Collectors;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Created by andres on 30/10/17.
 */

@Getter @Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public class BibleRange {

    private Range<BiblePosition> range;

    public BibleRange(Range<BiblePosition> range) {
        this.range = range;
    }

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

}
