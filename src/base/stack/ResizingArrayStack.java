package base.stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * 下压栈-基于动态调整数组大小方法的实现。
 * @author acer
 */
public class ResizingArrayStack<E> implements Stack<E> {

    private E[] a = (E[]) new Object[1];
    int n = 0;

    @Override
    public void push(E e) {
        if (n == a.length) {
            resize(2 * a.length);
        }
        a[n++] = e;
    }

    @Override
    public E pop() {
        if (n == 0) {
            throw new RuntimeException("栈已空");
        }

        E e = a[--n];
        a[n] = null;

        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }
        return e;
    }

    @Override
    public E peek() {
        return a[n - 1];
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

    private class ReverseArrayIterator implements Iterator<E> {
        private int i = n;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public E next() {
            return a[--i];
        }
    }

    private void resize(int max) {
        E[] item = (E[]) new Object[max];
        if (n >= 0) {
            System.arraycopy(a, 0, item, 0, n);
        }
        this.a = item;
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> ras = new ResizingArrayStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!"-".equals(item)) {
                ras.push(item);
            } else if (!ras.isEmpty()) {
                StdOut.print(ras.pop() + " ");
            }
        }
        StdOut.println("(" + ras.size() + ")");
    }
}
