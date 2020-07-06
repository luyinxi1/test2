package search;

import java.util.Iterator;

/**
 * 有序符号表的API
 * @author acer
 */
public interface OrderedST<Key extends Comparable<Key>, Value> extends ST<Key, Value> {
    /**
     * 最小的键。
     * @return
     */
    Key min();

    /**
     * 最大的键。
     * @return
     */
    Key max();

    /**
     * 小于等于key的最大键。
     * @param key
     * @return
     */
    Key floor(Key key);

    /**
     * 大于等于key的最小键。
     * @param key
     * @return
     */
    Key ceiling(Key key);

    /**
     * 小于key的键的数量。
     * @param key
     * @return
     */
    int rank(Key key);

    /**
     * 排名为k的键。
     * @param k
     * @return
     */
    Key select(int k);

    /**
     * 删除最小的键。
     */
    default void deleteMin() {
        delete(min());
    }

    /**
     * 删除最大的键。
     */
    default void deleteMax() {
        delete(max());
    }

    /**
     * [lo...hi]之间的键的数量。
     * @param lo
     * @param hi
     * @return
     */
    default int size(Key lo, Key hi) {
        if (hi.compareTo(lo) < 0) {
            return 0;
        } else if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }
    }

    /**
     * [lo...hi]之间的键的集合，已排序。
     * @param lo
     * @param hi
     * @return 一个可以遍历指定范围键的迭代器。
     */
    Iterable<Key> keys(Key lo, Key hi);

    @Override
    default Iterable<Key> keys() {
        return keys(min(), max());
    }
}
