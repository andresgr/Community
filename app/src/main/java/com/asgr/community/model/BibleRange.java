package com.asgr.community.model;

import android.util.Range;

import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class BibleRange implements Comparable<BibleRange> {

    @NonNull private final Range<BiblePosition> range;

    @Override
    public String toString() {
        BiblePosition lower = range.getLower();
        BiblePosition upper = range.getUpper();
        if (lower.getChapter() != upper.getChapter()) {
            return String.format("%s - %s", lower, upper);
        } else if (lower.getVerse() != upper.getVerse()) {
            return String.format("%d, %d - %d",
                    lower.getChapter(), lower.getVerse(), upper.getVerse());
        } else {
            return String.format("%d, %d", lower.getChapter(), lower.getVerse());
        }
    }

    public static BibleRange parse(String rangeAsStr) {
        String regex = "(\\d{1,3}) \\- (\\d{1,3})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(rangeAsStr);
        if (matcher.matches()) {
            String group = matcher.group(1);
            String group1 = matcher.group(2);
            Integer lowerChapter = Integer.parseInt(group);
            Integer upperChapter = Integer.parseInt(group1);
            return new BibleRange(new Range<>(
                    new BiblePosition(lowerChapter, 0),
                    new BiblePosition(upperChapter, 0)));
        }
        throw new IllegalArgumentException(rangeAsStr);
    }

    @Override
    public int compareTo(@NonNull BibleRange other) {
        BiblePosition lower = range.getLower();
        Range<BiblePosition> otherRange = other.getRange();
        return lower.compareTo(otherRange.getLower());
    }

}
