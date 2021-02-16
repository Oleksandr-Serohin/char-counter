package ua.com.foxminded.counter;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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
        PrintStream out = System.out;
        InputStream in = System.in;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream ();
        System.setOut (new PrintStream (outContent));
        System.setIn (new ByteArrayInputStream (inputString.getBytes ()));
        Main.main (null);
        assertEquals (expected, outContent.toString ());
    }

    @Test
    public void testMainTwoString_returnTwoFormatString() {
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
        PrintStream out = System.out;
        InputStream in = System.in;
        ByteArrayOutputStream outContentString1 = new ByteArrayOutputStream ();
        System.setOut (new PrintStream (outContentString1));
        System.setIn (new ByteArrayInputStream (inputString.getBytes ()));
        Main.main (null);
        assertEquals (expected, outContentString1.toString ());

        PrintStream outs = System.out;
        InputStream ins = System.in;
        ByteArrayOutputStream outContentString2 = new ByteArrayOutputStream ();
        System.setOut (new PrintStream (outContentString2));
        System.setIn (new ByteArrayInputStream (inputString.getBytes ()));
        Main.main (null);
        assertEquals (expected, outContentString2.toString ());
    }
    @Test
    public void testMainFourString_returnFourFormatString() {
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
        String inputString2 = "Hello world";
        String expected2 = """
                "H" - 1
                "e" - 1
                "l" - 3
                "o" - 2
                " " - 1
                "w" - 1
                "r" - 1
                "d" - 1""";

        PrintStream out1 = System.out;
        InputStream in1 = System.in;
        ByteArrayOutputStream outContentString1 = new ByteArrayOutputStream ();
        System.setOut (new PrintStream (outContentString1));
        System.setIn (new ByteArrayInputStream (inputString.getBytes ()));
        Main.main (null);
        assertEquals (expected, outContentString1.toString ());

        PrintStream out2 = System.out;
        InputStream in2 = System.in;
        ByteArrayOutputStream outContentString2 = new ByteArrayOutputStream ();
        System.setOut (new PrintStream (outContentString2));
        System.setIn (new ByteArrayInputStream (inputString.getBytes ()));
        Main.main (null);
        assertEquals (expected, outContentString2.toString ());

        PrintStream out3 = System.out;
        InputStream in3 = System.in;
        ByteArrayOutputStream outContentString3 = new ByteArrayOutputStream ();
        System.setOut (new PrintStream (outContentString3));
        System.setIn (new ByteArrayInputStream (inputString2.getBytes ()));
        Main.main (null);
        assertEquals (expected2, outContentString3.toString ());

        PrintStream out4 = System.out;
        InputStream in4 = System.in;
        ByteArrayOutputStream outContentString4 = new ByteArrayOutputStream ();
        System.setOut (new PrintStream (outContentString4));
        System.setIn (new ByteArrayInputStream (inputString2.getBytes ()));
        Main.main (null);
        assertEquals (expected2, outContentString4.toString ());
  }

}
