package ua.com.foxminded.counter.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.counter.propertiesreader.PropertiesReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LIFO")
public class LIFOCacheTest {

    private LIFOCache lifoCache;
    private PropertiesReader propertiesReader;

    @BeforeEach
    void setUp() {
        lifoCache = new LIFOCache ();
        propertiesReader = new PropertiesReader ();
        int sizeCache = propertiesReader.GetSizeCache ();
        for (; 0 < sizeCache; sizeCache--) {
            lifoCache.put ( String.valueOf ( sizeCache ), String.valueOf ( sizeCache ) );
        }
    }

    @Test
    void should_remove_elements_when_reach_the_limit() {
        int sizeCache = propertiesReader.GetSizeCache ();
        int i = sizeCache;
        for (; 0 < i; i--) {
            lifoCache.put ( String.valueOf ( i ), String.valueOf ( i ) );
        }
        lifoCache.put ( String.valueOf ( sizeCache + 1 ), String.valueOf ( sizeCache + 1 ) );
        assertEquals ( null, lifoCache.get (String.valueOf ( i + 1 )) );
    }

    @Test
    void should_return_true(){
        assertEquals ( true, lifoCache.containsKey ( String.valueOf ( 10 ) ) );
    }
}
