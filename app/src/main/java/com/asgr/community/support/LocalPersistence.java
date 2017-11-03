package com.asgr.community.support;

import android.util.Range;

import com.asgr.community.model.BibleGroup;
import com.asgr.community.model.BibleGroupBook;
import com.asgr.community.model.BiblePosition;
import com.asgr.community.model.BibleRange;
import com.asgr.community.model.SingleBibleRange;
import com.asgr.community.model.Book;
import com.asgr.community.model.Quote;
import com.asgr.community.model.Testament;
import com.google.common.collect.ImmutableList;
import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;
import java.util.stream.Collectors;

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
        insertQuotes();
    }

    private void deleteDB() {
        Quote.deleteAll(Quote.class);
        BibleGroupBook.deleteAll(BibleGroupBook.class);
        Book.deleteAll(Book.class);
        BibleGroup.deleteAll(BibleGroup.class);
    }

    private void insertGroups() {
        BibleGroup.executeQuery("INSERT INTO BIBLE_GROUP(name, description) VALUES(?, ?)", "Pentateuco", "");
        BibleGroup.executeQuery("INSERT INTO BIBLE_GROUP(name, description) VALUES(?, ?)", "Histórico", "");
        BibleGroup.executeQuery("INSERT INTO BIBLE_GROUP(name, description) VALUES(?, ?)", "Sapiencial", "");
        BibleGroup.executeQuery("INSERT INTO BIBLE_GROUP(name, description) VALUES(?, ?)", "Profético", "");
        BibleGroup.executeQuery("INSERT INTO BIBLE_GROUP(name, description) VALUES(?, ?)", "Evangelio", "");
        BibleGroup.executeQuery("INSERT INTO BIBLE_GROUP(name, description) VALUES(?, ?)", "Hechos de los Apóstoles", "");
        BibleGroup.executeQuery("INSERT INTO BIBLE_GROUP(name, description) VALUES(?, ?)", "Epístola de San Pablo", "");
        BibleGroup.executeQuery("INSERT INTO BIBLE_GROUP(name, description) VALUES(?, ?)", "Epístola Católica", "");
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
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Primera Epístola de San Juan", "1 Jn", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Segunda Epístola de San Juan", "2 Jn", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Tercera Epístola de San Juan", "3 Jn", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Epístola de San Judas", "Judas", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
        Book.executeQuery("INSERT INTO BOOK(book_index, name, abbreviation, testament) VALUES(?, ?, ?, ?)", String.valueOf(++index), "Apocalipsis", "Ap", index <= 46 ? Testament.OLD.name() : Testament.NEW.name());
    }

    private void insertGroupMemberships() {
        // Pentateuco
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Pentateuco", "Génesis");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Pentateuco", "Éxodo");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Pentateuco", "Levítico");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Pentateuco", "Números");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Pentateuco", "Deuteronomio");

        // Históricos
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Histórico", "Josué");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Histórico", "Jueces");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Histórico", "Rut");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Histórico", "1 Samuel");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Histórico", "2 Samuel");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Histórico", "1 Reyes");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Histórico", "2 Reyes");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Histórico", "1 Crónicas");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Histórico", "2 Crónicas");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Histórico", "Esdras");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Histórico", "Nehemías");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Histórico", "Tobías");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Histórico", "Judit");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Histórico", "Ester");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Histórico", "1 Macabeos");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Histórico", "2 Macabeos");

        // Sapienciales
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Sapiencial", "Salmos");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Sapiencial", "Cantar de los Cantares");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Sapiencial", "Lamentaciones");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Sapiencial", "Job");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Sapiencial", "Proverbios");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Sapiencial", "Eclesiastés (Qohélet)");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Sapiencial", "Sabiduría");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Sapiencial", "Eclesiástico (Sirácida)");

        // Profetas
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Profético", "Isaías");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Profético", "Jeremías");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Profético", "Baruc");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Profético", "Ezequiel");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Profético", "Daniel");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Profético", "Oseas");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Profético", "Joel");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Profético", "Amós");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Profético", "Abdías");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Profético", "Jonás");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Profético", "Miqueas");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Profético", "Nahúm");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Profético", "Habacuc");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Profético", "Sofonías");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Profético", "Ageo");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Profético", "Zacarías");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Profético", "Malaquías");

        // Evangelios
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Evangelio", "Evangelio San Mateo");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Evangelio", "Evangelio San Marcos");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Evangelio", "Evangelio San Lucas");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Evangelio", "Evangelio San Juan");

        // Hechos de los Apóstoles
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Hechos de los Apóstoles", "Hechos de los Apóstoles");

        // Epístolas de San Pablo
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Epístola de San Pablo", "Epístola a los Romanos");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Epístola de San Pablo", "Primera Epístola a los Corintios");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Epístola de San Pablo", "Segunda Epístola a los Corintios");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Epístola de San Pablo", "Epístola a los Gálatas");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Epístola de San Pablo", "Epístola a los Efesios");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Epístola de San Pablo", "Epístola a los Filipenses");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Epístola de San Pablo", "Epístola a los Colosenses");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Epístola de San Pablo", "Primera Epístola a los Tesalonicenses");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Epístola de San Pablo", "Segunda Epístola a los Tesalonicenses");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Epístola de San Pablo", "Primera Epístola a Timoteo");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Epístola de San Pablo", "Segunda Epístola a Timoteo");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Epístola de San Pablo", "Epístola a Tito");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Epístola de San Pablo", "Epístola a Filemón");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Epístola de San Pablo", "Epístola a los Hebreos");

        // Epístolas Católicas
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Epístola Católica", "Epístola de Santiago");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Epístola Católica", "Primera Epístola de San Pedro");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Epístola Católica", "Segunda Epístola de San Pedro");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Epístola Católica", "Primera Epístola de San Juan");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Epístola Católica", "Segunda Epístola de San Juan");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Epístola Católica", "Tercera Epístola de San Juan");
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Epístola Católica", "Epístola de San Judas");

        // Apocalipsis
        BibleGroupBook.executeQuery("INSERT INTO BIBLE_GROUP_BOOK(group_id, book_id) VALUES((SELECT ID FROM BIBLE_GROUP WHERE NAME = ?), (SELECT ID FROM BOOK WHERE NAME = ?))", "Apocalipsis", "Apocalipsis");
    }

    private void showGroupBooks() {
        BibleGroup.listAll(BibleGroup.class).stream()
                .forEach(group -> {
                    List<Book> groupBooks = getGroupBooks(group);
                    System.out.println(String.format("groupBooks(%s) = %s",
                            group.getName(),
                            groupBooks.stream().map(Book::getName).collect(Collectors.joining(", "))));
                });
    }

    private void showBookGroups() {
        Book.listAll(Book.class).stream()
                .forEach(book -> {
                    List<BibleGroup> bookGroups = getBookGroups(book);
                    System.out.println(String.format("bookGroups(%s) = %s",
                            book.getName(),
                            bookGroups.stream().map(BibleGroup::getName).collect(Collectors.joining(", "))));
                });

    }

    @Override
    public List<BibleGroup> getBookGroups(Book book) {
        List<Long> groupIds = Select.from(BibleGroupBook.class)
                .where(Condition.prop("book_id").eq(book.getId()))
                .list().stream()
                .map(BibleGroupBook::getGroupId)
                .collect(Collectors.toList());
        return getGroupsById(groupIds);
    }

    @Override
    public List<Book> getGroupBooks(BibleGroup group) {
        List<Long> bookIds = Select.from(BibleGroupBook.class)
                .where(Condition.prop("group_id").eq(group.getId()))
                .list().stream()
                .map(BibleGroupBook::getBookId)
                .collect(Collectors.toList());
        return getBooksById(bookIds);
    }

    private List<BibleGroup> getGroupsById(List<Long> groupIds) {
        return BibleGroup.findWithQuery(
                BibleGroup.class,
                String.format("select * from bible_group where id in (%s)", listToInClause(groupIds)));
    }

    private List<Book> getBooksById(List<Long> bookIds) {
        return Book.findWithQuery(
                Book.class, String.format("select * from book where id in (%s)", listToInClause(bookIds)));
    }

    private String listToInClause(List<Long> inClauseList) {
        return inClauseList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("', '", "'", "'"));
    }

    @Override
    public boolean existsBookByName(String bookName) {
        return Select.from(Book.class).where(Condition.prop("name").eq(bookName)).count() > 0;
    }

    @Override
    public Book findBookByName(String bookName) {
        return Select.from(Book.class).where(Condition.prop("name").eq(bookName)).first();
    }

    private void insertQuotes() {
        Book genesis = findBookByName("Génesis");
        Quote quote;

        // Single verse
        quote = new Quote(genesis, new BibleRange(new BiblePosition(23, 1)));
        quote.save();

        // Single chapter
        quote = new Quote(
                genesis,
                new BibleRange(new BiblePosition(2)));
        quote.save();

        // Verse range within chapter
        quote = new Quote(
                genesis,
                new BibleRange(
                        new BiblePosition(1, 1),
                        new BiblePosition(1, 34)));
        quote.save();

        // Range among chapters
        quote = new Quote(
                genesis,
                new BibleRange(
                        new BiblePosition(2),
                        new BiblePosition(3)));
        quote.save();

        // Range among chapters starting in verse
        quote = new Quote(
                genesis,
                new BibleRange(
                        new BiblePosition(21, 10),
                        new BiblePosition(22)));
        quote.save();

        // Range among chapters ending in verse
        quote = new Quote(
                genesis,
                new BibleRange(
                        new BiblePosition(14),
                        new BiblePosition(15, 10)));
        quote.save();

        // Composed ranges
        List<SingleBibleRange> ranges = ImmutableList.of(
                new SingleBibleRange(new BiblePosition(25, 10)),
                new SingleBibleRange(new BiblePosition(25, 20)));
        quote = new Quote(genesis, new BibleRange(ranges));
        quote.save();

        quote = new Quote(
                findBookByName("Joel"),
                new BibleRange(
                        new BiblePosition(1, 12),
                        new BiblePosition(2, 1)));
        quote.save();

        quote = new Quote(
                findBookByName("Baruc"),
                new BibleRange(
                        new BiblePosition(1, 3)));
        quote.save();

        quote = new Quote(
                findBookByName("Hechos de los Apóstoles"),
                new BibleRange(
                        new BiblePosition(2, 3),
                        new BiblePosition(2, 12)));
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
