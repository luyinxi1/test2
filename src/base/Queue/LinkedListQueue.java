package base.Queue;

import base.stack.LinkedListStack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class LinkedListQueue<E> implements Queue<E>{

    private Node first;
    private Node last;
    private int n;
    private class Node {
        E e;
        Node next;
    }
    @Override
    public void enqueue(E e) {
        Node oldLast = last;
        last = new Node();
        last.e = e;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }

    @Override
    public E dequeue() {
        E e = first.e;
        first = first.next;

        if (isEmpty()) {
            last = null;
        }
        n--;

        return e;
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
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E e = current.e;
            current = current.next;

            return e;
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new LinkedListQueue<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (!"-".equals(s)) {
                queue.enqueue(s);
            } else if (!queue.isEmpty()){
                StdOut.print(queue.dequeue() + " ");
            }
        }
        StdOut.print("(" + queue.size() + ")");
    }
}
