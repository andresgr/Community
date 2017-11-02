package com.asgr.community.support;

import com.asgr.community.model.BibleGroup;
import com.asgr.community.model.Book;
import com.asgr.community.model.Quote;

import java.util.List;

/**
 * Created by andres on 1/11/17.
 */

public interface Persistence {

    void init();

    List<Book> findBooks();

    List<Quote> findQuotes();

    List<BibleGroup> findGroups();

}
