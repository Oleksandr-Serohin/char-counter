package ua.com.foxminded.counter.propertiesreader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/**
 * Date: Feb 16-2021 Class read file
 * with setting size LinkedHashSet
 *
 * @author Aleksandr Serohin
 * @version 1.0001
 */

public class PropertiesReader {
    int result;

    /**
     * @param file input file with setting
     */
    public void ScanFile(File file) {
        String sizeCache = "";
        try {
            FileReader reader = new FileReader ( file );
            Scanner scanner = new Scanner ( reader );
            while (scanner.hasNextLine ()) {
                sizeCache = sizeCache.concat ( String.valueOf ( scanner.nextLine () ) );
            }
            reader.close ();
        } catch (IOException e) {
            System.out.println("Something wrong with file setting");
        }
        try {
            this.result = Integer.valueOf ( sizeCache.replaceAll ( "\\D+", "" ) );
        } catch (NumberFormatException e) {
            throw new NumberFormatException ( "File setting is empty" );
        }
    }

    /**
     * @return int size cache
     */
    public int SetSizeCache() {
        ConnectFile connectFile = new ConnectFile ();
        File file = connectFile.getFile ( "SetSizeCache.txt" );
        ScanFile ( file );
        return result;
    }
}