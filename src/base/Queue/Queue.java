package base.Queue;

public interface Queue<E> extends Iterable<E> {
    /**
     * 向栈中添加一个元素。
     * @param e
     */
    void enqueue(E e);

    /**
     * 删除栈顶元素。
     * @return
     */
    E dequeue();

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
