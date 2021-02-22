package ua.com.foxminded.counter.coordinator;

import ua.com.foxminded.counter.cache.FIFOCache;
import ua.com.foxminded.counter.counter.Counter;
import ua.com.foxminded.counter.exception.Validator;
import ua.com.foxminded.counter.formatter.FormatString;

/**
 * Date: Feb 11-2021 Class launches select unique chars,
 * calculated their number and the result is passed  to formatting
 *
 * @author Aleksandr Serohin
 * @version 1.0001
 */
public class Coordinator {

    FIFOCache FIFOCache = new FIFOCache ();

    /**
     * @param sentences string
     * @return format string with unique character calculated their number
     */
    public String calculatedUniqueCharacterTheirNumber(String sentences) {
        Validator.validateArguments ( sentences );
        if (FIFOCache.containsKey ( sentences )) {
            return FIFOCache.get ( sentences );
        }
        Counter counter = new Counter ();
        FormatString formatString = new FormatString ();
        FIFOCache.put ( sentences, formatString.format ( counter.calculatedUniqueCharacters (sentences)));
        return FIFOCache.get ( sentences );
    }
}