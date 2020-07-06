package base.bag;

import java.util.Iterator;

/**
 * 抽象数据类型-背包的接口定义。
 * @param <E>
 * @author YCH
 */
public interface Bag<E> extends Iterable<E> {
    /**
     * 添加一个元素
     * @param e
     */
    void add(E e);

    /**
     * 背包是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 背包中的元素数量
     */
    int size();
}
