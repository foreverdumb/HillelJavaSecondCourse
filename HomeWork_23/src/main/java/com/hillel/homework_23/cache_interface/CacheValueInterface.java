package com.hillel.homework_23.cache_interface;

import java.time.LocalDateTime;

public interface CacheValueInterface<V> {
    V getValue();

    LocalDateTime getCreatedAt();
}
