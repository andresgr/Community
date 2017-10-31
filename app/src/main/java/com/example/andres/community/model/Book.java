package com.example.andres.community.model;

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

    private String name;
    private int bookIndex;
    private Testament testament;

}
