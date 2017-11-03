package com.asgr.community.model;

import android.support.annotation.NonNull;
import android.util.Range;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by andres on 30/10/17.
 */

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class BiblePosition implements Comparable<BiblePosition> {

    public static final char CHAPTER_VERSE_SEPARATOR = ',';

    private int chapter;
    private int verse;

    public BiblePosition(int chapter) {
        this(chapter, 0);
    }

    @Override
    public int compareTo(@NonNull BiblePosition other) {
        if (this.equals(other)) {
            return 0;
        }
        if (chapter < other.chapter) {
            return -1;
        } else if (chapter > other.chapter) {
            return 1;
        } else {
            return verse < other.verse ? -1 : (verse == other.verse ? 0 : 1);
        }
    }

    @Override
    public String toString() {
        return verse == 0 ?
                String.format("%d", chapter) :
                String.format("%d%c %d", chapter, CHAPTER_VERSE_SEPARATOR, verse);
    }

    @NonNull
    public static BiblePosition parse(@Nonnull String positionAsString) {
        String[] parts = positionAsString.split(String.valueOf(CHAPTER_VERSE_SEPARATOR));
        int positionsCount = parts.length;
        if (positionsCount == 1) {
            int chapter = Integer.parseInt(parts[0].trim());
            return new BiblePosition(chapter);
        } else if (positionsCount == 2) {
            String chapter = parts[0].trim();
            String verse = parts[1].trim();
            return new BiblePosition(Integer.parseInt(chapter), Integer.parseInt(verse));
        } else {
            throw new IllegalArgumentException(positionAsString);
        }
    }

    @Nonnull
    public static boolean hasChapterVerseSeparator(String upperAsString) {
        return upperAsString.contains(String.valueOf(CHAPTER_VERSE_SEPARATOR));
    }

}
