package com.hillel.homework_23.cache_interface;

import java.util.Optional;

public interface CacheInterface<K, V> {
    boolean put(K key, V value);

    Optional<V> get(K key);

    void clear();

    void clear(K key);

    void clean();
}
