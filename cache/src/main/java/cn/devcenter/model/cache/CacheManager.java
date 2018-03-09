package cn.devcenter.model.cache;

/**
 * 用于在单一jvm中提供多个Cache实例
 *
 * @author gaosong
 */
public interface CacheManager {

    <K, V> Cache<K, V> getCache(String name) throws CacheException;
}
