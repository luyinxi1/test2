package base.bag;

import base.stack.LinkedListStack;

import java.util.Iterator;
import java.util.Objects;

public class ArrayBag<E> implements Bag<E> {

    private Node first;
    private int n;
    private class Node {
        E e;
        Node next;
    }

    @Override
    public void add(E e) {
        Node oldFirst = first;
        first = new Node();
        first.e = e;
        first.next = oldFirst;
        n++;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
