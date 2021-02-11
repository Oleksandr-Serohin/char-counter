package ua.com.foxminded.counter.uniquechars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CounterTest {

    private static Counter counter;

    @BeforeEach
    void setUp() {
        counter = new Counter ();
    }

    @Test
    void whenABCString_formatString() {
        String actual = counter.calculatedUniqueCharacterTheirNumber ("Hello world!");
        String expected = """
                "H" - 1
                "e" - 1
                "l" - 3
                "o" - 2
                " " - 1
                "w" - 1
                "r" - 1
                "d" - 1
                "!" - 1
                """;
        assertEquals (expected, actual);
    }

    @Test
    void whenNullString_Expect_NullPointerException() {
        final String isNull = null;
        NullPointerException thrown = assertThrows (NullPointerException.class, () -> counter.calculatedUniqueCharacterTheirNumber (isNull));
        assertEquals ("Sentences is null", thrown.getMessage ());
    }

    @Test
    void whenStringEmpty_Expect_EmptyString() {
        final String expected = "";
        String actual = counter.calculatedUniqueCharacterTheirNumber ("");
        assertEquals (expected, actual);
    }

    @Test
    void whenStringDigits_Expect_FormatString() {
        final String expected = """
                "!" - 1
                "@" - 1
                "#" - 1
                "$" - 1
                "%" - 1
                "^" - 1
                "&" - 1
                "*" - 1
                "(" - 1
                ")" - 2
                "_" - 1
                """;
        String actual = counter.calculatedUniqueCharacterTheirNumber ("!@#$%^&*())_");
        assertEquals (expected, actual);
    }
}