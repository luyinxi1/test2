package sort.priorityqueue;

/**
 * 优先队列的接口定义
 * @author YCH
 */
public interface MaxPQ<Key extends Comparable<Key>> {
    /**
     * 向优先队列中插入一个元素。
     * @param v
     */
    void insert(Key v);

    /**
     * 返回最大元素。
     * @return
     */
    Key getMax();

    /**
     * 删除并返回最大元素。
     * @return
     */
    Key delMax();

    /**
     * 队列是否为空。
     * @return
     */
    boolean isEmpty();

    /**
     * 返回元素个数。
     * @return
     */
    int size();
}
