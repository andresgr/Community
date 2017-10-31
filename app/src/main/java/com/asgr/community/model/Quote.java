package com.asgr.community.model;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import java.util.Optional;

import javax.annotation.Nonnull;

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
public class Quote extends SugarRecord<Quote> {

    @Ignore @Getter(AccessLevel.PRIVATE)
    private Optional<BibleRange> maybeRange = Optional.empty();

    @Nonnull private String rangeAsStr;
    private String comment;
    private float punctuation;

    public Quote(BibleRange range, String comment, float punctuation) {
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
}
