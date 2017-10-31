package com.example.andres.community.model;

import com.orm.SugarRecord;

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
@EqualsAndHashCode(callSuper = true)
public class BibleGroup extends SugarRecord<BibleGroup> {

    private int order;
    private String name;
    private String description;

}
