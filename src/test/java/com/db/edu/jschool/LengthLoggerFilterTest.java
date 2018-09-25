package com.db.edu.jschool;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LengthLoggerFilterTest {
    private LengthLoggerFilter loggerFilter;

    @Before
    public void setUp(){
        int maxLength = 5;
        loggerFilter = new LengthLoggerFilter(maxLength);
    }

    @Test
    public void shouldFilterOutWhenShotMessage(){
        boolean result = loggerFilter.filter("qwe");
        assertFalse(result);
    }

    @Test
    public void shouldFilterOutWhenLengthAlmostFine(){
        boolean result = loggerFilter.filter("qwert");
        assertFalse(result);
    }

    @Test
    public void shouldFilterOutWhenNullMessage(){
        boolean result = loggerFilter.filter(null);
        assertFalse(result);
    }

    @Test
    public void shouldNotFilterOutWhenLongMessage(){
        boolean result = loggerFilter.filter("qwertyyue");
        assertTrue(result);
    }
}
