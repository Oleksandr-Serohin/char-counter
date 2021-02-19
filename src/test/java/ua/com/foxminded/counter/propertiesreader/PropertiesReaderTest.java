package ua.com.foxminded.counter.propertiesreader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PropertiesReaderTest {

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
        assertEquals ( expected, propertiesReader.GetSizeCache () );
    }

    @Test
    public void whenEmptyFile_Expected_NumberFormatException() throws IOException {
        File file = File.createTempFile ("tempFile", ".txt");
        NumberFormatException thrown = assertThrows ( NumberFormatException.class, () ->  propertiesReader.ScanFile ( file ) );
        assertEquals ( "File setting is empty", thrown.getMessage () );
        file.deleteOnExit();
    }


    @Test
    public void whenNonFile_Expected_RuntimeExceptionMessage() {
        File file = new File  ("");
        RuntimeException thrown = assertThrows ( RuntimeException.class, () ->  propertiesReader.ScanFile ( file ) );
        assertEquals ( "Something wrong with file setting", thrown.getMessage () );
    }

    @Test
    public void whenSizeCacheZero_Expected_IOExceptionMessage() throws IOException {
        File file = File.createTempFile ("tempFile", ".txt");
        FileWriter fw = new FileWriter ( file );
        PrintWriter pw = new PrintWriter ( fw );
        pw.println ("sizeCache = 0");
        pw.close ();
        IllegalArgumentException thrown = assertThrows ( IllegalArgumentException.class, () ->  propertiesReader.ScanFile ( file ) );
        assertEquals ( "Cache size must be at least 1!", thrown.getMessage () );
        file.deleteOnExit();
    }

    @Test
    public void When_NonFile_Expect_NullPointerException()  {
        File file = mock ( File.class );
        String isNull= null;
        NullPointerException thrown = assertThrows ( NullPointerException.class, () -> new PropertiesReader ().ScanFile ( file ) );
        assertEquals ( isNull, thrown.getMessage () );
    }
}
