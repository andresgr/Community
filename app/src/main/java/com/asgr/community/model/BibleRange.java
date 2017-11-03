package com.asgr.community.model;

import android.support.annotation.NonNull;
import android.util.Range;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by andres on 30/10/17.
 */

@Getter @Setter
@EqualsAndHashCode
public class BibleRange implements Comparable<BibleRange> {

    public static final char INTER_RANGE_SEPARATOR = '.';

    private final List<SingleBibleRange> ranges;

    public BibleRange(BiblePosition lower, BiblePosition upper) {
        this(new SingleBibleRange(lower, upper));
    }

    public BibleRange(BiblePosition position) {
        this(new SingleBibleRange(position));
    }

    private BibleRange(SingleBibleRange range) {
        this(Arrays.asList(range));
    }

    public BibleRange(List<SingleBibleRange> ranges) {
        this.ranges = ImmutableList.sortedCopyOf(ranges);
    }

    @Override
    public String toString() {
        return ranges.stream()
                .map(SingleBibleRange::toString)
                .collect(Collectors.joining(String.valueOf(INTER_RANGE_SEPARATOR)));
    }

    @Override
    public int compareTo(@NonNull BibleRange bibleRange) {
        return ranges.get(0).compareTo(bibleRange.ranges.get(0));
    }

    @Nonnull
    public static BibleRange parse(@Nonnull String rangeAsStr) {
        String[] singleRanges = rangeAsStr.split(
                String.format("\\%s", String.valueOf(INTER_RANGE_SEPARATOR)));
        int singleRangesCount = singleRanges.length;
        if (singleRangesCount == 1) {
            return new BibleRange(SingleBibleRange.parse(rangeAsStr));
        } else {
            // TODO: Use previous chapter
            List<SingleBibleRange> ranges = new ArrayList<>(singleRangesCount);
            for (int i = 0; i < singleRangesCount; i++) {
                ranges.add(SingleBibleRange.parse(singleRanges[i]));
            }
            return new BibleRange(ranges);
        }
    }

}
