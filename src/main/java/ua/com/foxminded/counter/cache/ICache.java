package ua.com.foxminded.counter.cache;

public interface ICache{

    boolean containsKey(String value);

    String get(String key);

    void put(String key, String value);
}