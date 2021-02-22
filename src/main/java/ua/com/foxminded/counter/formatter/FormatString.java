package ua.com.foxminded.counter.formatter;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Date: Feb 22-2021 Class takes Map,
 * format to string
 *
 * @author Aleksandr Serohin
 * @version 1.0001
 */
public class FormatString {

    /**
     * @param uniqueCharacter unique chars and their number
     * @return format string
     */
    public String format(Map<String, Integer> uniqueCharacter) {
        String result = uniqueCharacter.keySet ().stream ().map ( ch -> String.format ( "%s",
                "\"" + ch + "\" - " + uniqueCharacter.get ( ch ) + "\n" ) )
                .collect ( Collectors.joining () );
        return result.trim ();
    }
}