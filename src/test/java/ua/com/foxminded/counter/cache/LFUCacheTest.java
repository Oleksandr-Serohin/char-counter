package ua.com.foxminded.counter.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.counter.propertiesreader.PropertiesReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Counts how often an item is needed. Those that are used least often are discarded first.")
class LFUCacheTest {

    private LFUCache lfuCache;
    private PropertiesReader propertiesReader;

    @BeforeEach
    void setUp() {
        propertiesReader = new PropertiesReader ();
        lfuCache = new LFUCache ();
        int sizeCache = propertiesReader.GetSizeCache ();
        for (; 0 < sizeCache; sizeCache--) {
            lfuCache.put ( String.valueOf ( sizeCache ), String.valueOf ( sizeCache ) );
        }
    }

    @Test
    void remove_the_less_accessed() {
        int sizeCache = propertiesReader.GetSizeCache ();
        for (int i = 1; sizeCache > i; i++) {
            lfuCache.get ( String.valueOf ( i ) );
        }
        lfuCache.put ( String.valueOf ( sizeCache + 1 ), String.valueOf ( sizeCache + 1 ) );
        assertEquals ( null, lfuCache.get ( String.valueOf ( sizeCache ) ) );
    }

    @Test
    void remove_the_less_then_FIFO_method() {
        int sizeCache = propertiesReader.GetSizeCache ();
        for (int i = 1; i >= sizeCache; i++) {
            lfuCache.get ( String.valueOf ( i ) );
        }
        lfuCache.put ( String.valueOf ( sizeCache + 1 ), String.valueOf ( sizeCache + 1 ) );
        assertEquals ( null, lfuCache.get ( String.valueOf ( sizeCache ) ) );
    }

    @Test
    void should_return_true(){
        assertEquals ( true, lfuCache.containsKey ( String.valueOf ( 10 ) ) );
    }

    @Test
    void should_replace_contains_element(){
        int sizeCache = propertiesReader.GetSizeCache ();
        String result = String.valueOf ( sizeCache+1 );
        lfuCache.put ( String.valueOf ( sizeCache ), result );
        assertEquals ( result, lfuCache.get ( String.valueOf ( sizeCache ) ) );
    }
}