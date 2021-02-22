package ua.com.foxminded.counter.counter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Date: Feb 22-2021 Class select unique chars,
 * calculated their number
 *
 * @author Aleksandr Serohin
 * @version 1.0001
 */
public class Counter {

    /**
     * @param sentences input string
     * @return unique chars and their number
     */
    public Map<String, Integer> calculatedUniqueCharacters(String sentences) {
        Map<String, Integer> unique = sentences.chars ().mapToObj ( e -> (char) e ).
                collect ( LinkedHashMap::new, (map, value) ->
                        map.merge ( String.valueOf ( value ), 1, Integer::sum ), LinkedHashMap::putAll );
        return  unique;
    }
}