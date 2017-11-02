package com.asgr.community.model;

import com.orm.SugarRecord;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by andres on 31/10/17.
 */
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class BibleGroupBookMembership extends SugarRecord<BibleGroupBookMembership> {

    private int bookId;
    private int groupId;

}
