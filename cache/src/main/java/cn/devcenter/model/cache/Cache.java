package cn.devcenter.model.cache;

import java.util.Map;
import java.util.Set;

public interface Cache<K, V> {

    K put(K key, V value) throws CacheException;

    K put(K key, V value, Long expiredTime) throws CacheException;

    boolean putIfAbsent(K key, V value) throws CacheException;

    void putAll(Map<? extends K, ? extends V> kvmap) throws CacheException;

    V get(K key) throws CacheException;

    Map<K, V> getAll(Set<? extends K> keyset) throws CacheException;

    V getAndPut(K key, V value) throws CacheException;

    boolean containsKey(K key) throws CacheException;

    boolean remove(K key) throws CacheException;

    V getAndRemove(K key) throws CacheException;

    void removeAll(Set<? extends K> keyset) throws CacheException;

    void clear() throws CacheException;

}
