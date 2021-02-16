package ua.com.foxminded.counter.propertiesreader;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PropertiesReaderTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private PropertiesReader propertiesReader;
    @BeforeEach
    public void preTestSetup()
    {
        propertiesReader = new PropertiesReader (); // initialize the classToTest
        // variable before each test.
    }

    @Test
    void whenSettingTen_expected_Int_Ten() {
        int expected = 10;
        System.out.println ( propertiesReader.SetSizeCache () );
        assertEquals ( expected, propertiesReader.SetSizeCache () );
    }

    @Test
    public void whenEmptyFile_Expected_NumberFormatException() {
        File file = new File("dsfsdf.txt");
        NumberFormatException thrown = assertThrows ( NumberFormatException.class, () -> new PropertiesReader ().ScanFile ( file ) );
        assertEquals ( "File setting is empty", thrown.getMessage () );
    }


    @Test
    public void whenNonFile_Expected_IOExceptionMessage() {
        File file = new File("");
        expectedException.expect(IOException.class);
    }

    @Test
        public void When_NonFile_Expect_NullPointerException()  {
        File file = mock ( File.class );
        String isNull= null;
        NullPointerException thrown = assertThrows ( NullPointerException.class, () -> new PropertiesReader ().ScanFile ( file ) );
        assertEquals ( isNull, thrown.getMessage () );
    }
}
