package base.Queue;

import java.util.Iterator;

public class    ResizingArrayQueue<E> implements Queue<E> {
    private E[] a = (E[]) new Object[1];
    int head = 0;
    int tail = 0;
    int n = 0;

    @Override
    public void enqueue(E e) {
        if (n == a.length) {
            resize(a.length * 2);
        }

        a[tail++] = e;
        if (tail == a.length) {
            tail = 0;
        }
        n++;
    }

    @Override
    public E dequeue() {
        if (n == 0) {
            throw new RuntimeException("栈已空");
        }

        E e = a[head++];
        a[head - 1] = null;
        if (head == a.length) {
            head = 0;
        }
        n--;

        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }
        return e;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterator<E> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<E>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }

    private void resize(int max) {
        E[] item = (E[]) new Object[max];
        if (n >= 0) {
            System.arraycopy(a, 0, item, 0, n);
        }
        this.a = item;
    }
}
