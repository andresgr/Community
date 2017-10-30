package com.example.andres.myapplication.model;

import com.orm.SugarRecord;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book extends SugarRecord<Book> {

    private String name;
    private int index;
    private Testament testament;
    private BibleGroup bibleGroup;

}
