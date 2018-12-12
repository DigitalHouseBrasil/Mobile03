package br.com.digitalhouse.app.mob3.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class StringUtilsTest {

    @Test
    public void testIsEmailValid() {
        assertTrue(StringUtils.validateEmail("tairo@digitalhouse.com"));
    }

    @Test
    public void testNotEmailValid() {
        assertFalse(StringUtils.validateEmail("digitalhouse.com"));
    }

    @Test
    public void testIsPasswordValid() {
        assertTrue(StringUtils.validatePassword("123456"));
    }

    @Test
    public void testNotPasswordValid() {
        assertFalse(StringUtils.validatePassword("123"));
    }
}