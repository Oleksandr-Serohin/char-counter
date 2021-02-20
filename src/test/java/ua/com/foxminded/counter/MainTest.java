package ua.com.foxminded.counter;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    public void testMain_returnFormatString() {
        String inputString = "Hello world!";
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
        ByteArrayOutputStream outContent = new ByteArrayOutputStream ();
        System.setOut ( new PrintStream ( outContent ) );
        System.setIn ( new ByteArrayInputStream ( inputString.getBytes () ) );
        Main.main ( null );
        assertEquals ( expected, outContent.toString () );
    }
}
