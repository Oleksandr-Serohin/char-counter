package ua.com.foxminded.counter.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.counter.propertiesreader.PropertiesReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("FIFO")
public class FIFICacheTest {

    private FIFOCache fifoCache;
    private PropertiesReader propertiesReader;

    @BeforeEach
    void setUp() {
        fifoCache = new FIFOCache ();
        propertiesReader = new PropertiesReader ();
        int sizeCache = propertiesReader.GetSizeCache ();
        for (; 0 < sizeCache; sizeCache--) {
            fifoCache.put ( String.valueOf ( sizeCache ), String.valueOf ( sizeCache ) );
        }
    }

    @Test
    void should_remove_elements_when_reach_the_limit() {
        int sizeCache = propertiesReader.GetSizeCache ();
        int i = sizeCache;
        for (; 0 < i; i--) {
            fifoCache.put ( String.valueOf ( i ), String.valueOf ( i ) );
        }
        fifoCache.put ( String.valueOf ( sizeCache + 1 ), String.valueOf ( sizeCache + 1 ) );
        assertEquals ( null, fifoCache.get ( String.valueOf ( sizeCache ) ) );
    }
}
