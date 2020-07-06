package search;

/**
 * 符号表的API
 * @author YCH
 */
public interface ST<Key, Value> {
    /**
     * 将键值对存入符号表中，若值为空则将键key从表中删除。
     * @param key
     * @param value
     */
    void put(Key key, Value value);


    /**
     * 获取键对应的值。
     * @param key
     * @return 若键不存在则返回null
     */
    Value get(Key key);

    /**
     * 删除键key及其对应的值（默认为延时实现）。
     * @param key
     */
    default void delete(Key key) {
        put(key, null);
    }

    /**
     * 键key在表中是否有对应的值。
     * @param key
     * @return
     */
    default boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     * @return
     */
    default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * @return
     */
    int size();

    /**
     * 表中所有键的集合。
     * @return 一个可以遍历所有键的迭代器。
     */
    Iterable<Key> keys();
}
