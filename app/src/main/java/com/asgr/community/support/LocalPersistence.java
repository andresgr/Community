package com.asgr.community.support;

import android.util.Range;

import com.asgr.community.model.BibleGroup;
import com.asgr.community.model.BibleGroupBookMembership;
import com.asgr.community.model.BiblePosition;
import com.asgr.community.model.BibleRange;
import com.asgr.community.model.Book;
import com.asgr.community.model.Quote;
import com.asgr.community.model.Testament;
import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;

/**
 * Created by andres on 1/11/17.
 */

public class LocalPersistence implements Persistence {

    @Override
    public void init() {
        deleteDB();
        insertBooks();
        insertGroups();
        insertGroupMemberships();
    }

    private void deleteDB() {
        Book.deleteAll(Book.class);
        BibleGroup.deleteAll(BibleGroup.class);
        Quote.deleteAll(Quote.class);
    }

    private void insertGroups() {
        BibleGroup.executeQuery("INSERT INTO BIBLE_GROUP(name, description) VALUES(?, ?)", "Pentateuco", "");
        BibleGroup.executeQuery("INSERT INTO BIBLE_GROUP(name, description) VALUES(?, ?)", "Históricos", "");
        BibleGroup.executeQuery("INSERT INTO BIBLE_GROUP(name, description) VALUES(?, ?)", "Sapienciales", "");
        BibleGroup.executeQuery("INSERT INTO BIBLE_GROUP(name, description) VALUES(?, ?)", "Proféticos", "");
        BibleGroup.executeQuery("INSERT INTO BIBLE_GROUP(name, description) VALUES(?, ?)", "Evangelios", "");
        BibleGroup.executeQuery("INSERT INTO BIBLE_GROUP(name, description) VALUES(?, ?)", "Hechos de los Apóstoles", "");
        BibleGroup.executeQuery("INSERT INTO BIBLE_GROUP(name, description) VALUES(?, ?)", "Epístolas de San Pablo", "");
        BibleGroup.executeQuery("INSERT INTO BIBLE_GROUP(name, description) VALUES(?, ?)", "Epístolas Católicas", "");
        BibleGroup.executeQuery("INSERT INTO BIBLE_GROUP(name, description) VALUES(?, ?)", "Apocalipsis", "");
    }

    private void insertBooks() {
        int index = 0;
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Génesis", "Gn", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Éxodo", "Ex", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Levítico", "Lv", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Números", "Nm", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Deuteronomio", "Dt", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Josué", "Jos", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Jueces", "Jc", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Rut", "Rt", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "1 Samuel", "1 S", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "2 Samuel", "2 S", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "1 Reyes", "1 R", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "2 Reyes", "2 R ", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "1 Crónicas", "1 Cro", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "2 Crónicas", "2 Cro", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Esdras", "Esd", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Nehemías", "Ne", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Tobías", "Tb", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Judit", "Jdt", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Ester", "Est", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "1 Macabeos", "1 M", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "2 Macabeos", "2 M", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Salmos", "Sal", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Cantar de los Cantares", "Ct", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Lamentaciones", "Lm", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Job", "Jb", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Proverbios", "Pr", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Eclesiastés (Qohélet)", "Qo", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Sabiduría", "Sb ", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Eclesiástico (Sirácida)", "Si", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Isaías", "Is", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Jeremías", "Jr", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Baruc", "Ba", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Ezequiel", "Ez", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Daniel", "Dn", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Oseas", "Os", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Joel", "Jl", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Amós", "Am", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Abdías", "Ab", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Jonás", "Jon", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Miqueas", "Mi", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Nahúm", "Na", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Habacuc", "Ha", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Sofonías", "So", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Ageo", "Ag", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Zacarías", "Za", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Malaquías", "Ml", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Evangelio San Mateo", "Mt", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Evangelio San Marcos", "Mc", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Evangelio San Lucas", "Lc", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Evangelio San Juan", "Jn", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Hechos de los Apóstoles", "Hch", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Epístola a los Romanos", "Rm", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Primera Epístola a los Corintios", "1 Co", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Segunda Epístola a los Corintios", "2 Co", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Epístola a los Gálatas", "Ga", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Epístola a los Efesios", "Ef", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Epístola a los Filipenses", "Flp", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Epístola a los Colosenses", "Col", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Primera Epístola a los Tesalonicenses", "1 Ts", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Segunda Epístola a los Tesalonicenses", "2 Ts", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Primera Epístola a Timoteo", "1 Tm", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Segunda Epístola a Timoteo", "2 Tm", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Epístola a Tito", "Tt", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Epístola a Filemón", "Flm", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Epístola a los Hebreos", "Hb ", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Epístola de Santiago", "St", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Primera Epístola de San Pedro", "1 P", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Segunda Epístola de San Pedro", "2 P", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Primera Epístola de Juan", "1 Jn", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Segunda Epístola de Juan", "2 Jn", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Tercera Epístola de Juan", "3 Jn", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Epístola de San Judas", "Judas", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Apocalipsis", "Ap", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
    }

    private void insertGroupMemberships() {
//        BibleGroupBookMembership.executeQuery("", "");
    }

    private boolean existsBook(String bookName) {
        return Select.from(Book.class).where(Condition.prop("name").eq(bookName)).count() > 0;
    }

    private void insertQuotes() {
        BibleRange bibleRange = new BibleRange(
                Range.create(
                        new BiblePosition(1, 1),
                        new BiblePosition(1, 34)));
        Quote quote = new Quote(bibleRange,"first quote", 12);
        quote.save();
    }

    @Override
    public List<Book> findBooks() {
        return Book.listAll(Book.class);
    }

    @Override
    public List<Quote> findQuotes() {
        return Quote.listAll(Quote.class);
    }

    @Override
    public List<BibleGroup> findGroups() {
        return BibleGroup.listAll(BibleGroup.class);
    }

}
