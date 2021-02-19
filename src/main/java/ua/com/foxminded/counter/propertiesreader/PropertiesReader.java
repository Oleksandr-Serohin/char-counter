package ua.com.foxminded.counter.propertiesreader;

import ua.com.foxminded.counter.exception.Validator;

import java.io.File;
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

    int sizeCache; //size cache

    /**
     * @param file input file with setting
     */
    public void ScanFile(File file) {
        String sizeCache = "";
        try {
            FileReader reader = new FileReader ( file );
            Scanner scanner = new Scanner ( reader );
            while (scanner.hasNextLine ()) { //scan file  and write result at string sizeCache
                sizeCache = sizeCache.concat ( String.valueOf ( scanner.nextLine () ) );
            }
            reader.close ();
        } catch (IOException e) {
            throw new RuntimeException ( "Something wrong with file setting" );
        }
        try {//delete all non-number
            this.sizeCache = Integer.valueOf ( sizeCache.replaceAll ( "\\D+", "" ) );
        } catch (NumberFormatException e) {
            throw new NumberFormatException ( "File setting is empty" );
        }
        Validator.validateSizeCache ( this.sizeCache ); //validate sizeCache
    }

    /**
     * @return int size cache
     */
    public int GetSizeCache() {
        ConnectFile connectFile = new ConnectFile ();
        File file = connectFile.getFile ( "SetSizeCache.txt" ); //set name file
        ScanFile ( file ); //send file to scan
        return sizeCache;
    }
}