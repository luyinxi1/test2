package search.symboltable;

import base.Queue.LinkedListQueue;
import base.Queue.Queue;
import search.ST;

import java.util.Iterator;

/**
 * 基于无序链表的顺序查找式符号表。
 * @author YCH
 */
public class SequentialSearchST<Key, Value> implements ST<Key, Value> {
    private Node first;
    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public void put(Key key, Value value) {
        if (value == null) {
            delete(key);
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }

        first = new Node(key, value, first);
    }

    @Override
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }

        return null;
    }

    @Override
    public void delete(Key key) {
        if (key.equals(first.key)) {
            first = first.next;
            return;
        }

        for (Node x = first; x.next != null; x = x.next) {
            if (key.equals(x.next)) {
                x.next = x.next.next;
                return;
            }
        }
    }

    @Override
    public int size() {
        int i = 0;
        for (Node x = first; x != null; x = x.next) {
            i++;
        }
        return i;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedListQueue<>();
        for (Node x = first; x != null ; x = x.next) {
            queue.enqueue(x.key);
        }

        return queue;
    }

}
