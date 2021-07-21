package com.hillel.homework_23.cacheInterface;

import java.time.LocalDateTime;

public interface CacheValueInterface<V> {
    V getValue();

    LocalDateTime getCreatedAt();
}
