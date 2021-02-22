package ua.com.foxminded.counter.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.counter.propertiesreader.PropertiesReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Discards the least recently used items first.")
public class LRUCacheTest {

    private LRUCache lruCache;
    private PropertiesReader propertiesReader;

    @BeforeEach
    void setUp() {
        propertiesReader = new PropertiesReader ();
        lruCache = new LRUCache ();
        int sizeCache = propertiesReader.GetSizeCache ();
        for (; 0 < sizeCache; sizeCache--) {
            lruCache.put ( String.valueOf ( sizeCache ), String.valueOf ( sizeCache ) );
        }
    }

    @Test
    void remove_the_less_accessed() {
        int sizeCache = propertiesReader.GetSizeCache ();
        for (int i = 1; sizeCache >= i; i++) {
            lruCache.get ( String.valueOf ( i ) );
        }
        System.out.println ( lruCache.getAll () );
        lruCache.put ( String.valueOf ( sizeCache + 1 ), String.valueOf ( sizeCache + 1 ) );
        System.out.println ( lruCache.getAll () );
        assertEquals ( null, lruCache.get ( String.valueOf ( 1 ) ) );
    }

    @Test
    void should_return_true(){
        assertEquals ( true, lruCache.containsKey ( String.valueOf ( 10 ) ) );
    }
}