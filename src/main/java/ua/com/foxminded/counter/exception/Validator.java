package ua.com.foxminded.counter.exception;

import java.util.Objects;
import java.util.Optional;

/**
 * Date: Feb 11-2021 Checks input string
 * if validation fails prints a message
 *
 * @author Aleksandr Serohin
 * @version 1.0001
 */

public class Validator {

    /**
     * @param sentences input string
     */
    public static void validateArguments(String sentences) {
        Objects.requireNonNull (sentences, "Sentences is null");
        Optional<String> Checking = Optional.of (sentences);
        String input = Checking.orElseThrow (() -> new RuntimeException ("Sentences is empty"));
    }
}