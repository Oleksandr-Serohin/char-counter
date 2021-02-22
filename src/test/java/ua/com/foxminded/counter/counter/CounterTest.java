package ua.com.foxminded.counter.counter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Counter")
class CounterTest {

    private Counter counter;

    @BeforeEach
    void setUp() {
        counter = new Counter ();
    }

    @Test
    void whenString_MustReturn_MapCalculatedUniqueCharacters() {
        Map<String, Integer> expected = new LinkedHashMap <>();
        expected.put ( "H", 1 );
        expected.put ( "e", 1 );
        expected.put ( "l", 3 );
        expected.put ( "o", 2 );
        expected.put ( " ", 1 );
        expected.put ( "W", 1 );
        expected.put ( "r", 1 );
        expected.put ( "d", 1 );
        expected.put ( "!", 1 );

        Map<String, Integer> result = counter.calculatedUniqueCharacters ( "Hello World!" );
        assertEquals (expected,  result );
    }
}