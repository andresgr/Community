package com.asgr.community.model;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.stream.Collectors;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by andres on 30/10/17.
 */

@Getter @Setter
@EqualsAndHashCode
public class ComposedBibleRange {

    private final List<BibleRange> ranges;

    public ComposedBibleRange(BibleRange...ranges) {
        // ordering
        this.ranges = ImmutableList.<BibleRange>builder().add(ranges).build();
    }

//    public ComposedBibleRange addRange(BibleRange range) {
//        ranges.add(range);
//        range.sort(new Comparator<Range<BiblePosition>>() {
//            @Override
//            public int compare(Range<BiblePosition> lhs, Range<BiblePosition> rhs) {
//                return lhs.getLower().compareTo(rhs.getLower());
//            }
//        });
//        return this;
//    }

    @Override
    public String toString() {
        return ranges.stream().map(BibleRange::toString).collect(Collectors.joining("."));
    }

}
