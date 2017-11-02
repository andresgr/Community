package com.asgr.community.model;

import com.orm.SugarRecord;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by andres on 31/10/17.
 */
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class BibleGroupBook extends SugarRecord<BibleGroupBook> {

    private int groupId;
    private int bookId;

}
