package ua.com.foxminded.counter.uniquechars;

import org.junit.jupiter.api.Test;
import ua.com.foxminded.counter.sizelinkedhashmap.MaxSizeLinkedHashMap;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSizeLinkedHashMapTest {

    private static MaxSizeLinkedHashMap<String, String> cache;
    private static LinkedHashMap<String, String> expected;

    @Test
    void whenSetSizeOne_expectedOneElement() {

        expected = new LinkedHashMap<> ();
        expected.put ("1", "Hello World!");
        cache = new MaxSizeLinkedHashMap<String, String> (1);
        cache.put ("1", "Hello World!");
        assertEquals (expected.get ("1"), cache.get ("1"));
    }

    @Test
    void whenSetSizeOne_expectedNull() {

        String isNull = null;
        cache = new MaxSizeLinkedHashMap<String, String> (1);
        cache.put ("1", "Hello World!");
        cache.put ("2", "Hello World");
        assertEquals (isNull, cache.get ("1"));
    }
}