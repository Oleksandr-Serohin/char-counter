package ua.com.foxminded.counter.cache;

import ua.com.foxminded.counter.propertiesreader.PropertiesReader;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Date: Feb 22-2021 Class eviction policy Least Recently Used algorithm,
 * by sampling a small number of keys,
 * and evicting the one that is the best (with the oldest access time)
 * among the sampled keys. Input key and value,
 * set size cache, returns boolean by key,
 * returns by key value.
 *
 * @author Aleksandr Serohin
 * @version 1.0001
 */
public class LRUCache implements ICache {

    private PropertiesReader propertiesReader = new PropertiesReader ();
    private final int sizeCache = propertiesReader.GetSizeCache (); // get size cache
    private static final float LOAD_FACTORY = 0.75f;
    int capacity = (int)Math.ceil(sizeCache / LOAD_FACTORY) + 1;
    private Map<String, String> cache = new LinkedHashMap<> (capacity, LOAD_FACTORY, true){
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
            return size() > sizeCache;
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
    public Map getAll(){
       return cache;
    }
}