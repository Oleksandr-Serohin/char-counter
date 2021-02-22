package ua.com.foxminded.counter.cache;

import ua.com.foxminded.counter.propertiesreader.PropertiesReader;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Date: Feb 22-2021 Class eviction policy LIFO (Last In First Out)
 * is a data structure where
 * the last element added is the first
 * to be removed. Input key and value,
 * set size cache, returns boolean by key,
 * returns by key value.
 *
 * @author Aleksandr Serohin
 * @version 1.0001
 */
public class LIFOCache implements ICache {

    private PropertiesReader propertiesReader = new PropertiesReader ();
    private final int sizeCache = propertiesReader.GetSizeCache (); // get size cache
    private String newest;
    private Map<String, String> cache = new LinkedHashMap<> ( sizeCache );

    /**
     * @param key input key(string)
     * @return boolean if has key
     */
    @Override
    public boolean containsKey(String key) {
        return cache.containsKey ( key );
    }

    /**
     * @param key key for search in cache
     * @return returns value if hase
     */
    @Override
    public String get(String key) {
        return cache.get ( key );
    }

    /**
     * @param key   put as key in cache
     * @param value put as value in cache
     */
    @Override
    public void put(String key, String value) { //check if cache full deleted last input key and value
        if (cache.size () == sizeCache) {
            cache.remove ( newest );
        }
        cache.put ( key, value );
        this.newest = key;
        cache.put ( key, value );
    }
}