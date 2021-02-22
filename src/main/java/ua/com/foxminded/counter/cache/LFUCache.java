package ua.com.foxminded.counter.cache;

import ua.com.foxminded.counter.propertiesreader.PropertiesReader;

import java.time.Clock;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Date: Feb 22-2021 Class eviction policy Least Frequently Used
 * is a data structure where the element least used
 * is evicted when the max limit
 * of the list is reached. Input key and value,
 * set size cache, returns boolean by key,
 * returns by key value.
 *
 * @author Aleksandr Serohin
 * @version 1.0001
 */
public class LFUCache implements ICache {

    /**
     * Class save key them lastTime used and them number in map.
     */
        private static class CountItem implements Comparable<CountItem> {
        protected final String key;
        protected int count;
        protected long lastTime;

        protected CountItem(String key, long lastAccess) {
            this.key = key;
            this.lastTime = lastAccess;
        }

        @Override
        public int compareTo(CountItem other) {
            int count = Integer.compare ( this.count, other.count );
            return count == 0 ? Long.compare ( this.lastTime, other.lastTime ) : count;
        }
    }

    private PropertiesReader propertiesReader = new PropertiesReader ();
    private final int sizeCache = propertiesReader.GetSizeCache (); // get size cache

    private Map<String, String> cache = new LinkedHashMap<> ();
    private final Map<String, CountItem> countItemMap = new LinkedHashMap<> ();

    private void removeElement() { // remove element by key
        CountItem countItem = Collections.min ( countItemMap.values () );
        cache.remove ( countItem.key );
        countItemMap.remove ( countItem.key );
    }

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
        String value = cache.get ( key );
        if (nonNull ( value )) {
            addHitCount ( key );
            return value;
        }
        return null;
    }

    /**
     * @param key   put as key in cache
     * @param value put as value in cache
     */
    @Override
    public void put(String key, String value) {
        String v = cache.get ( key );
        if (isNull ( v )) {
            if (sizeCache == cache.size ()) {
                removeElement ();
            }
            countItemMap.put ( key, new CountItem ( key, Clock.systemUTC ().millis () ) );
        } else {
            addHitCount ( key );
        }
        cache.put ( key, value );
    }

    /**
     * @param key put as key
     */
    private void addHitCount(String key) { //replacing an existing value by key in CountItem
        CountItem countItem = countItemMap.get ( key );
        countItem.count = countItem.count + 1;
        countItem.lastTime = Clock.systemUTC ().millis ();
    }
}