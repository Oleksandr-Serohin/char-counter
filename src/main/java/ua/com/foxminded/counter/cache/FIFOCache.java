package ua.com.foxminded.counter.cache;

import ua.com.foxminded.counter.propertiesreader.PropertiesReader;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Date: Feb 22-2021 Class eviction policy First In First Out algorithm
 * stores the first item into
 * the head of the list and last on the tail
 * and the head is the element to leave
 * the list save. Input key and value,
 * set size cache, returns boolean by key,
 * returns by key value.
 *
 * @author Aleksandr Serohin
 * @version 1.0001
 */
public class FIFOCache implements ICache {
    private PropertiesReader propertiesReader = new PropertiesReader ();
    private final int sizeCache = propertiesReader.GetSizeCache (); // get size cache

    private final Map<String, String> cache = new LinkedHashMap<> () {
        protected boolean removeEldestEntry(Map.Entry<String, String> eldest) { //overload method for set size cache
            return size () > sizeCache;
        }
    };

    /**
     * @param key input key(string)
     * @return boolean if has key
     */
    @Override
    public boolean containsKey(String key) {
        return cache.containsKey ( key );
    }

    /**
     * @param value key for search in cache
     * @return returns value if hase
     */
    @Override
    public String get(String value) {
        return cache.get ( value );
    }

    /**
     * @param key   put as key in cache
     * @param value put as value in cache
     */
    @Override
    public void put(String key, String value) {
        cache.put ( key, value );
    }
}