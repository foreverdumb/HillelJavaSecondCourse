package com.hillel.homework_23.cache_service;

import com.hillel.homework_23.cache_interface.CacheInterface;
import com.hillel.homework_23.cache_interface.CacheValueInterface;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class CacheImplClass<K, V> implements CacheInterface<K, V> {
    private static final Logger info_logger = LogManager.getLogger("appLogger");
    private static final Logger warn_logger = LogManager.getLogger("appLogger");

    public static final Long DEFAULT_CACHE_TIMEOUT = 60000L;

    protected Map<K, CacheValueInterface<V>> cacheMap;
    protected Long cacheTimeout;


    public CacheImplClass() {
        this(DEFAULT_CACHE_TIMEOUT);
    }

    public CacheImplClass(Long cacheTimeout) {
        this.cacheTimeout = cacheTimeout;
        this.clear();
    }

    /**
     * <p>
     * Description of clean() method...
     * Cleans cache by searching expired keys
     * </p>
     *
     * @since 1.0
     */
    @Override
    public void clean() {
        if (getExpiredKeys().size() == 0) {
            warn_logger.log(Level.WARN, "No expired keys found...");
        }
        for (K key : this.getExpiredKeys()) {
            this.clear(key);
            info_logger.log(Level.INFO, "Key [" + key + "] is deleted...");
        }
    }

    @Override
    public boolean containsKey(K key) {
        return this.cacheMap.containsKey(key);
    }


    /**
     * <p>
     * Description of put(K key, V value) method...
     * Puts element into cache
     * </p>
     *
     * @param key   is the elements' key in the map
     * @param value is the elements' value in the map
     * @return true if element is added and false if not
     * @since 1.0
     */
    @Override
    public boolean put(K key, V value) {
        if (key != null && value != null) {
            if (containsKey(key)) {
                this.cacheMap.put(key, this.createCacheValue(value));
                warn_logger.log(Level.WARN, "Found key duplicate, new value was wrote");
            }
            int size_before = this.cacheMap.size();
            this.cacheMap.put(key, this.createCacheValue(value));
            int size_after = this.cacheMap.size();
            info_logger.log(Level.INFO, "Key [" + key + "] with value [" + value + "] is added...");
            return size_before < size_after;
        }
        return false;
    }

    /**
     * <p>
     * Description of createCacheValue(V value) method...
     * Creates cache value
     * </p>
     *
     * @param value is the elements' value in the map
     * @return CacheValueInterface which returns cache value and current date and time
     * @since 1.0
     */
    protected CacheValueInterface<V> createCacheValue(V value) {
        LocalDateTime now = LocalDateTime.now();
        return new CacheValueInterface<>() {
            @Override
            public V getValue() {
                return value;
            }

            @Override
            public LocalDateTime getCreatedAt() {
                return now;
            }
        };
    }

    /**
     * <p>
     * Description of get(K key) method...
     * Gets element by its' key
     * </p>
     *
     * @param key is the elements' key in the map
     * @return keys' value
     * @since 1.0
     */
    @Override
    public Optional<V> get(K key) {
        this.clean();
        if (this.cacheMap.size() == 0) {
            warn_logger.log(Level.WARN, "Map is empty, nothing to get...");
        } else {
            info_logger.log(Level.INFO, "Got key [" + key + "]...");
        }
        return Optional.ofNullable(this.cacheMap.get(key)).map(CacheValueInterface::getValue);
    }

    /**
     * <p>
     * Description of clear() method...
     * Makes map --> empty HashMap
     * </p>
     *
     * @since 1.0
     */
    @Override
    public void clear() {
        this.cacheMap = new HashMap<>();
        info_logger.log(Level.INFO, "Cache is cleared...");
    }

    /**
     * <p>
     * Description of clear(K key) method...
     * Removes element by key
     * </p>
     *
     * @param key is the elements' key in the map
     * @since 1.0
     */
    @Override
    public void clear(K key) {
        this.cacheMap.remove(key);
        info_logger.log(Level.INFO, "Key [" + key + "] is removed...");
    }

    /**
     * <p>
     * Description of isExpired(K key) method...
     * Checks if the key is expired
     * </p>
     *
     * @param key is the elements' key in the map
     * @return true if time expired false if it's not
     * @since 1.0
     */
    protected boolean isExpired(K key) {
        LocalDateTime expirationDateTime = this.cacheMap.get(key).getCreatedAt().plus(this.cacheTimeout,
                ChronoUnit.MILLIS);
        return LocalDateTime.now().isAfter(expirationDateTime);
    }

    /**
     * <p>
     * Description of getExpiredKeys() method...
     * Collects expired keys into set
     * </p>
     *
     * @return set of expired keys
     * @since 1.0
     */
    protected Set<K> getExpiredKeys() {
        return this.cacheMap.keySet().parallelStream()
                .filter(this::isExpired)
                .collect(Collectors.toSet());
    }

    /**
     * <p>
     * Description of mapSize() method...
     * Calculates maps' size
     * </p>
     *
     * @return maps' size
     * @since 1.0
     */
    public int mapSize() {
        info_logger.log(Level.INFO, "Printed map size");
        return this.cacheMap.size();
    }
}
