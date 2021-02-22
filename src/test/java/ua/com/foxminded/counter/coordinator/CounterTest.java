package ua.com.foxminded.counter.coordinator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CounterTest {

    private static Coordinator counter;

    @BeforeEach
    void setUp() {
        counter = new Coordinator ();
    }

    @Test
    void whenTwoString_getFromCacheFormatString() {
        String actual = counter.calculatedUniqueCharacterTheirNumber ("Hello world!");
        String actual1 = counter.calculatedUniqueCharacterTheirNumber ("Hello world!");
        String expected = """
                "H" - 1
                "e" - 1
                "l" - 3
                "o" - 2
                " " - 1
                "w" - 1
                "r" - 1
                "d" - 1
                "!" - 1""";
        assertEquals (expected, actual1);
    }
}