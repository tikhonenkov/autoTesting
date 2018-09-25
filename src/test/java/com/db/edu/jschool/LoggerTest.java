package com.db.edu.jschool;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoggerTest {

    private static final String MESSAGE = "some message";

    @Mock
    private LoggerFilter filter;

    @Mock
    private LoggerSaver saver;

    private Logger logger;

    @Before
    public void setUp() {
        logger = new Logger(filter, saver);
    }


    @Test
    public void shouldCallFilterWithMessageWhenLogMessage() {
        when(filter.filter(anyString())).thenReturn(false);

        logger.log(MESSAGE);

        verify(filter, times(1)).filter(MESSAGE);
    }

    @Test
    public void shouldFilterOutWhenInvalidMessage() {
        when(filter.filter(anyString())).thenReturn(false);

        logger.log(MESSAGE);

        verify(saver, times(0)).save(anyString());
    }

    @Test
    public void shouldSaveWhenValidMessage() {
        when(filter.filter(anyString())).thenReturn(true);

        logger.log(MESSAGE);

        verify(saver, times(1)).save(MESSAGE);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotFailWhenFilterNull() {
        new Logger(null, saver).log(MESSAGE);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotFailWhenSaverNull() {
        new Logger(filter, null).log(MESSAGE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotFailWhenMessageNull() {
        logger.log(null);
    }
}
