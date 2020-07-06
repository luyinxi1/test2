package base.stack;

import java.util.Iterator;

public interface Stack<E> extends Iterable<E> {
    /**
     * 向栈中添加一个元素。
     * @param e
     */
    void push(E e);

    /**
     * 删除栈顶元素并返回。
     * @return
     */
    E pop();

    /**
     * 返回栈顶元素。
     * @return
     */
    E peek();
    /**
     * 栈是否为空。
     * @return
     */
    boolean isEmpty();

    /**
     * 栈中的元素数量。
     * @return
     */
    int size();
}
