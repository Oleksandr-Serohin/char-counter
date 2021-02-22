package ua.com.foxminded.counter.formatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.counter.counter.Counter;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Formatter")
public class FormatStringTest {

    private FormatString formatString;

    @BeforeEach
    void setUp() {
        formatString = new FormatString ();
    }

    @Test
    void whenMapUniqueCharacter_mustReturnFormatString() {
        Map<String, Integer> uniqueCharacter = new LinkedHashMap<> ();
        uniqueCharacter.put ( "H", 1 );
        uniqueCharacter.put ( "e", 1 );
        uniqueCharacter.put ( "l", 3 );
        uniqueCharacter.put ( "o", 2 );
        uniqueCharacter.put ( " ", 1 );
        uniqueCharacter.put ( "W", 1 );
        uniqueCharacter.put ( "r", 1 );
        uniqueCharacter.put ( "d", 1 );
        uniqueCharacter.put ( "!", 1 );

        String expected = """
                "H" - 1
                "e" - 1
                "l" - 3
                "o" - 2
                " " - 1
                "W" - 1
                "r" - 1
                "d" - 1
                "!" - 1""";
        String result = formatString.format ( uniqueCharacter );
        assertEquals (expected,  result );
    }
}
