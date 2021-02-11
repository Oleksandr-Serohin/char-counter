package ua.com.foxminded.counter.uniquechars;

import ua.com.foxminded.counter.exception.Validator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Date: Feb 11-2021 Class select unique chars,
 * calculated their number, format to string
 *
 * @author Aleksandr Serogin
 * @version 1.0001
 */

public class Counter {

    private static String cash;
    private static String formatString;

    /**
     * @param sentences string
     * @return format string with unique character calculated their number
     */
    public static String calculatedUniqueCharacterTheirNumber(String sentences) {
        Validator validator = new Validator ();
        validator.validateArguments (sentences);
        if (sentences.equals (cash)) {
            return formatString;
        }
        List<Character> chars = convertStringToCharList (sentences);
        LinkedHashMap<String, Integer> uniqueCharacter = calculatedUniqueCharacters (chars);
        String result = format (uniqueCharacter);
        cash = sentences;
        formatString = result;
        return result;
    }

    /**
     * @param sentences input string
     * @return decompose the input string into list characters
     */
    private static List<Character> convertStringToCharList(String sentences) {
        List<Character> chars = sentences
                .chars ()
                .mapToObj (e -> (char) e)
                .collect (Collectors.toList ());
        return chars;
    }

    /**
     * @param chars characters input string
     * @return unique chars and their number
     */
    private static LinkedHashMap<String, Integer> calculatedUniqueCharacters(List<Character> chars) {
        LinkedHashMap<String, Integer> unique = chars.stream ().collect (LinkedHashMap::new, (map, value) -> {
            map.merge (String.valueOf (value), 1, Integer::sum);
        }, LinkedHashMap::putAll);
        return unique;
    }

    /**
     * @param uniqueCharacter unique chars and their number
     * @return format string
     */
     private static String format(LinkedHashMap<String, Integer> uniqueCharacter) {
        String result = uniqueCharacter.keySet ().stream ()
                .map (ch -> new StringBuilder ().append ("\"").append (ch).append ("\" - ")
                        .append (uniqueCharacter.get (ch)).append ("\n").toString ())
                .collect (Collectors.joining ());
        return result;
    }
}