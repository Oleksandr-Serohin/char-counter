package ua.com.foxminded.counter.sizehashmap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Date: Feb 15-2021 Class for set size
 * LinkedHashMap
 *
 * @author Aleksandr Serogin
 * @version 1.0001
 */

public class MaxSizeHashMap<K, V> extends LinkedHashMap<K, V> {
    private final int maxSize;

    /**
     * @param maxSize number size LinkedHashMap
     */
    public MaxSizeHashMap(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxSize;
    }
}