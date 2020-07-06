package base.linkedlist;

public class LinkedList<E> {
    private class Node {
        E e;
        Node next;
    }
    private Node first;

    public void firstInsert(E e) {
        Node oldFirst = first;
        first = new Node();
        first.e = e;
        first.next = oldFirst;
    }

    public E firstDelete() {
        E e = first.e;
        first = first.next;

        return e;
    }

    public void lastInsert(E e) {
        Node x = first;
        while (x != null) {
            if (x.next == null) {
                break;
            }
            x = x.next;
        }

        Node oldLast = x;
        x = new Node();
        x.e = e;
        x.next = null;

        if (oldLast != null) {
            oldLast.next = x;
        }
    }
}
