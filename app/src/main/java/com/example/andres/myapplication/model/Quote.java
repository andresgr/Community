package com.example.andres.myapplication.model;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by andres on 30/10/17.
 */

@Data
@AllArgsConstructor
public class Quote extends SugarRecord<Quote> {

    @Ignore
    private BibleRange range;

    private BibleRange rangeAsStr;
    private String comment;
    private String punctuation;

    public void setRangeAsStr(BibleRange rangeAsStr) {
        this.rangeAsStr = rangeAsStr;
//        this.range = BibleRange.parse(rangeAsStr);
    }
}
