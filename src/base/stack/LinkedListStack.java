package base.stack;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class LinkedListStack<E> implements Stack<E>{

    private Node first;
    private int n;
    private int modify;
    private class Node {
        E e;
        Node next;
    }
//--------- 在构造方法中利用头插法构造一条链表，first指向头？-------------- //
//    public LinkedListStack(LinkedListStack<E> s) {
//        Node x;
//        for (E e : s) {
//            Node  =
//        }
//    }

    @Override
    public void push(E e) {
        Node oldFirst = first;
        first = new Node();
        first.e = e;
        first.next = oldFirst;

        modify++;
        n++;
    }

    @Override
    public E pop() {
        E e = first.e;
        first = first.next;

        modify++;
        n--;

        return e;
    }

    @Override
    public E peek() {
        return first.e;
    }


    /**
     * 1.3.47 - 连接两个栈（破坏性的）。
     */
    public void catenation(LinkedListStack<E> s) {
        for (E e : s) {
            this.push(e);
        }
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
        return new StackIterator();
    }

    private class StackIterator implements Iterator<E>{
        private Node current = first;
        private int count = modify;
        @Override
        public boolean hasNext() {
            if (count != modify) {
                throw new ConcurrentModificationException();
            }

            return current != null;
        }

        @Override
        public E next() {
            if (count != modify) {
                throw new ConcurrentModificationException();
            }

            E e = current.e;
            current = current.next;

            return e;
        }
    }
}
