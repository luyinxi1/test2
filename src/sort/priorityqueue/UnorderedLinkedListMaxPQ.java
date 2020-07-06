package sort.priorityqueue;

/**
 * 链表实现的最大值优先队列。使用了带头结点的单链表，标准的实现应该是双向链表。
 * @author YCH
 */
public class UnorderedLinkedListMaxPQ<Key extends Comparable<Key>> implements MaxPQ<Key> {
    private Node head = new Node();
    private int n;
    private class Node {
        Key key;
        Node next;
    }

    @Override
    public void insert(Key v) {
        Node x = new Node();
        x.key = v;
        x.next = head.next;
        head.next = x;

        n++;
    }

    @Override
    public Key getMax() {
        Key key = head.next.key;
        Node temp = head;
        for (Node x = head.next; x.next != null; x = x.next) {
            if (key.compareTo(x.next.key) < 0) {
                temp = x;
                key = x.next.key;
            }
        }
        return key;
    }

    @Override
    public Key delMax() {
        Key key = head.next.key;
        Node temp = head;
        for (Node x = head.next; x.next != null; x = x.next) {
            if (key.compareTo(x.next.key) < 0) {
                temp = x;
                key = x.next.key;
            }
        }

        temp.next = temp.next.next;
        n--;

        return key;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    public static void main(String[] args) {
        MaxPQ<Double> pq = new UnorderedLinkedListMaxPQ<>();
        pq.insert(30.0);
        pq.insert(21.0);
        pq.insert(58.0);
        pq.insert(4.0);
        pq.insert(90.0);
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
    }

}
