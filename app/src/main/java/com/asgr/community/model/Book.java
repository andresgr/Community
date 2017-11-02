package com.asgr.community.model;

import com.orm.SugarRecord;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Book extends SugarRecord<Book> {

    private int bookIndex;
    private String name;
    private String abbreviation;
    private Testament testament;

}
