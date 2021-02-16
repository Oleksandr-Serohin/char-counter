package ua.com.foxminded.counter.propertiesreader;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Date: Feb 15-2021 Class read file
 * with setting size LinkedHashSet
 *
 * @author Aleksandr Serogin
 * @version 1.0001
 */

public class PropertiesReader {

    public static int PropertiesReader() {
        Path path = Paths.get ("src/main/resources/SetSizeCache.txt");
        File file = new File (path.toUri ());
        Scanner scanner = null;
        try {
            scanner = new Scanner (file);
        } catch (FileNotFoundException e) {
            System.out.format ("File " + "SetSizeCache.txt" + " not found in " + "src/main/resources/");
        }
        String sizeCache = "";
        while (scanner.hasNextLine ()) {
            sizeCache = sizeCache.concat (String.valueOf (scanner.nextLine ()));
        }
        int result = Integer.valueOf (sizeCache.replaceAll ("\\D+", ""));
        return result;
    }
}