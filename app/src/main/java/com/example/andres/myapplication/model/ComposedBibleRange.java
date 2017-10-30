package com.example.andres.myapplication.model;

import android.util.Range;

import java.util.Arrays;
import java.util.List;
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
public class ComposedBibleRange {

    private List<BibleRange> ranges;

    public ComposedBibleRange(BibleRange...ranges) {
        this.ranges = Arrays.asList(ranges);
    }

    public ComposedBibleRange addRange(BibleRange range) {
        ranges.add(range);
//        range.sort(new Comparator<Range<BiblePosition>>() {
//            @Override
//            public int compare(Range<BiblePosition> lhs, Range<BiblePosition> rhs) {
//                return lhs.getLower().compareTo(rhs.getLower());
//            }
//        });
        return this;
    }

    @Override
    public String toString() {
        return ranges.stream().map(BibleRange::toString).collect(Collectors.joining("."));
    }

}
