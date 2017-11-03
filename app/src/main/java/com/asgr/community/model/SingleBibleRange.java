package com.asgr.community.model;

import android.util.Range;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Delegate;

import static com.asgr.community.model.BiblePosition.CHAPTER_VERSE_SEPARATOR;
import static com.asgr.community.model.BiblePosition.hasChapterVerseSeparator;

/**
 * Created by andres on 30/10/17.
 */

@Getter @Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public class SingleBibleRange implements Comparable<SingleBibleRange> {

    @Delegate
    @NonNull private final Range<BiblePosition> range;

    public static final char INTRA_RANGE_SEPARATOR = '-';

    public SingleBibleRange(BiblePosition lower, BiblePosition upper) {
        this.range = new Range<>(lower, upper);
    }

    public SingleBibleRange(BiblePosition position) {
        this.range = new Range<>(position, position);
    }

    @Override
    public String toString() {
        BiblePosition lower = range.getLower();
        BiblePosition upper = range.getUpper();
        if (lower.getChapter() != upper.getChapter()) {
            return String.format("%s %c %s", lower, INTRA_RANGE_SEPARATOR, upper);
        } else if (lower.getVerse() != upper.getVerse()) {
            return String.format("%d%c %d %c %d",
                    lower.getChapter(),
                    CHAPTER_VERSE_SEPARATOR,
                    lower.getVerse(),
                    INTRA_RANGE_SEPARATOR,
                    upper.getVerse());
        } else {
            return String.format("%d%c %d",
                    lower.getChapter(),
                    CHAPTER_VERSE_SEPARATOR,
                    lower.getVerse());
        }
    }

    @Override
    public int compareTo(@NonNull SingleBibleRange other) {
        BiblePosition lower = range.getLower();
        BiblePosition otherLower = other.getLower();
        return lower.compareTo(otherLower);
    }

    @NonNull
    public static SingleBibleRange parse(String singleRangeAsString) {
        String[] biblePositions = singleRangeAsString.split(String.valueOf(INTRA_RANGE_SEPARATOR));
        int positionsCount = biblePositions.length;
        if (positionsCount == 1) {
            return new SingleBibleRange(BiblePosition.parse(singleRangeAsString));
        } else if (positionsCount == 2) {
            String lowerAsString = biblePositions[0];
            String upperAsString = biblePositions[1];
            BiblePosition lower = BiblePosition.parse(lowerAsString);
            if (!hasChapterVerseSeparator(upperAsString)) {
                return new SingleBibleRange(
                        lower,
                        new BiblePosition(
                                lower.getChapter(),
                                Integer.parseInt(upperAsString.trim())));
            } else {
                return new SingleBibleRange(lower, BiblePosition.parse(upperAsString));
            }
        } else {
            throw new IllegalArgumentException(singleRangeAsString);
        }
    }

}
