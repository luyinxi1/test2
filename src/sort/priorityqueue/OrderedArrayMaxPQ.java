package sort.priorityqueue;

import sort.SortTemplate;

/**
 * 有序数组实现的最大值优先队列，插入操作是线性级别，删除操作是常数级别。
 * @author YCH
 */
public class OrderedArrayMaxPQ<Key extends Comparable<Key>> implements MaxPQ<Key>{
    private Key[] a = (Key[]) new Comparable[2];
    int n;

    @Override
    public void insert(Key v) {
        if (a.length == n) {
            resize(2 * a.length);
        }
        a[n++] = v;

        for (int i = n - 1; i > 0 && SortTemplate.less(a[i], a[i-1]); i--) {
            SortTemplate.exch(a, i, i - 1);
        }
    }

    @Override
    public Key getMax() {
        return a[n - 1];
    }

    @Override
    public Key delMax() {
        Key k = a[--n];
        a[n] = null;

        return k;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    private void resize(int max) {
        Key[] item = (Key[]) new Comparable[max];
        if (n >= 0) {
            System.arraycopy(a, 0, item, 0, n);
        }
        this.a = item;
    }

    public static void main(String[] args) {
        MaxPQ<Double> pq = new OrderedArrayMaxPQ<>();
        pq.insert(30.0);
        pq.insert(21.0);
        pq.insert(58.0);
        pq.insert(4.0);
        pq.insert(5.0);
        System.out.println(pq.delMax());
        System.out.println(pq.getMax());

    }
}
