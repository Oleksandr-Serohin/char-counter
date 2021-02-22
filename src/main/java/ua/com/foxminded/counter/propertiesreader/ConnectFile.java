package ua.com.foxminded.counter.propertiesreader;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Date: Feb 16-2021 Class connect with file
 * and return file
 *
 * @author Aleksandr Serohin
 * @version 1.0001
 */
public class ConnectFile {

    /**
     * @return file
     */
    public File getFile(String setURI) {
        Path path = Paths.get ( setURI );
        File file = new File ( path.toUri () );
        return file;
    }
}