package ua.com.foxminded.counter.uniquechars;

import ua.com.foxminded.counter.exception.Validator;
import ua.com.foxminded.counter.sizehashmap.MaxSizeHashMap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Date: Feb 11-2021 Class select unique chars,
 * calculated their number, format to string
 *
 * @author Aleksandr Serogin
 * @version 1.0001
 */

public class Counter {

    static MaxSizeHashMap<String, String> cache = new MaxSizeHashMap<String, String> (1);//set size LinkedHashMap

    /**
     * @param sentences string
     * @return format string with unique character calculated their number
     */

    public String calculatedUniqueCharacterTheirNumber(String sentences) {
        Validator.validateArguments (sentences);
        cache.computeIfAbsent (sentences, this::calculatedUniqueCharacters);
        return cache.get (sentences);
    }

    /**
     * @param sentences input string
     * @return unique chars and their number
     */
    private String calculatedUniqueCharacters(String sentences) {
        Map<String, Integer> unique = sentences.chars ().mapToObj (e -> (char) e).
                collect (LinkedHashMap::new, (map, value) ->
                        map.merge (String.valueOf (value), 1, Integer::sum), LinkedHashMap::putAll);
        return format (unique);
    }

    /**
     * @param uniqueCharacter unique chars and their number
     * @return format string
     */
    private static String format(Map<String, Integer> uniqueCharacter) {
        String result = uniqueCharacter.keySet ().stream ().map (ch -> String.format ("%s",
                "\"" + ch + "\" - " + uniqueCharacter.get (ch) + "\n"))
                .collect (Collectors.joining ());
        return result.trim ();
    }
}
