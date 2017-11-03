package com.asgr.community;

import com.asgr.community.model.BiblePosition;
import com.asgr.community.model.BibleRange;
import com.asgr.community.model.Book;
import com.asgr.community.model.Quote;
import com.asgr.community.support.LocalPersistence;
import com.asgr.community.support.Persistence;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
//
//    private static Persistence sPersistence;
//    private static Book sBook;
//
//    @BeforeClass
//    public static void init() {
//        sPersistence = new LocalPersistence();
//        sPersistence.init();
//        sBook = sPersistence.findBookByName("Génesis");
//    }

    @Test
    public void testSingleVerseQuote() {
        testSaveAndLoadQuote(new BibleRange(new BiblePosition(23, 1)));
    }

    @Test
    public void testSingleChapterQuote() {
        testSaveAndLoadQuote(
                new BibleRange(
                        new BiblePosition(2, 0),
                        new BiblePosition(3, 0)));
    }

    @Test
    public void testVerseRangeWithinChapterQuote() {
        testSaveAndLoadQuote(
                new BibleRange(
                        new BiblePosition(1, 1),
                        new BiblePosition(1, 34)));
    }

    @Test
    public void testRangeAmongChaptersQuote() {
        testSaveAndLoadQuote(
                new BibleRange(
                        new BiblePosition(2, 0),
                        new BiblePosition(3, 0)));
    }

    @Test
    public void testRangeAmongChaptersStartingInVerseQuote() {
        testSaveAndLoadQuote(
                new BibleRange(
                        new BiblePosition(21, 10),
                        new BiblePosition(22, 0)));
    }

    @Test
    public void testRangeAmongChaptersEndingInVerseQuote() {
        testSaveAndLoadQuote(
                new BibleRange(
                        new BiblePosition(14, 0),
                        new BiblePosition(15, 10)));
    }

    @Test @Ignore
    public void testComposedRangesQuote() {
        testSaveAndLoadQuote(
                new BibleRange(
                        new BiblePosition(14),
                        new BiblePosition(15, 10)));
    }

    private void testSaveAndLoadQuote(BibleRange bibleRange) {
        String bibleRangeAsString = bibleRange.toString();
        BibleRange parsed = BibleRange.parse(bibleRangeAsString);
        Assert.assertEquals(bibleRangeAsString, parsed);
    }

}
