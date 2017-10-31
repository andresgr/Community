package com.example.andres.community.model;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by andres on 30/10/17.
 */

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class Quote extends SugarRecord<Quote> {

    @Ignore
    private BibleRange range;

    private String rangeAsStr;
    private String comment;
    private float punctuation;

    public void setRangeAsStr(String rangeAsStr) {
        this.rangeAsStr = rangeAsStr;
//        this.range = BibleRange.parse(rangeAsStr);
    }
}
