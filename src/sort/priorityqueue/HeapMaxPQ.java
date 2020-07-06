package sort.priorityqueue;

import edu.princeton.cs.algs4.StdOut;

/**
 * 二叉堆实现的最大值优先队列。
 * @author YCH
 */
public class HeapMaxPQ<Key extends Comparable<Key>> implements MaxPQ<Key> {
    private Key[] pq;
    private int n = 0;
    private Key min;

    public HeapMaxPQ(Comparable[] a) {
        int l = a.length;
        this.pq = (Key[]) a;
        for (int i = l / 2; i <= 1; i--) {
            sink(i);
        }
        while (n > 1) {
            exch(1, l--);
            sink(1, l);
        }
    }
    public HeapMaxPQ(int maxN) {
        this.pq = (Key[]) new Comparable[maxN];
    }

    @Override
    public void insert(Key v) {
        pq[++n] = v;
        if (n == 1 || min.compareTo(v) > 0) {
            min = v;
        }
        swim(n);
    }

    @Override
    public Key getMax() {
        return pq[1];
    }

    @Override
    public Key delMax() {
        Key max = pq[1];
        exch(1, n--);
        pq[n+1] = null;
        sink(1);

        if (isEmpty()) {
            min = null;
        }

        return max;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return 0;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }

            exch(k, j);
            k = j;
        }
    }
    private void sink(int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }

            exch(k, j);
            k = j;
        }
    }
    public Key min() {
        return min;
    }
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key key = pq[i];
        pq[i] = pq[j];
        pq[j] = key;
    }
    public static void main(String[] args) {
        MaxPQ<String> pq = new HeapMaxPQ<>(20);
        pq.insert("E");
        pq.insert("A");
        pq.insert("S");
        pq.insert("Y");
        pq.insert("Q");
        pq.insert("U");
        pq.insert("E");
        pq.insert("S");
        pq.insert("T");
        pq.insert("I");
        pq.insert("O");
        pq.insert("N");
        while (!pq.isEmpty()) {
            StdOut.print(pq.delMax() + " ");
        }
    }
}
