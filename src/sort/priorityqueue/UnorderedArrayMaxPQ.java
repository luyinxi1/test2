package sort.priorityqueue;

import sort.SortTemplate;

/**
 * 无序数组实现的最大值优先队列，插入操作是常数级别，删除操作是线性级别。
 * @author YCH
 */
public class UnorderedArrayMaxPQ<Key extends Comparable<Key>> implements MaxPQ<Key> {
    private Key[] a = (Key[]) new Comparable[2];
    int n;

    @Override
    public void insert(Key v) {
        if (a.length == n) {
            resize(2 * a.length);
        }
        a[n++] = v;
    }

    @Override
    public Key getMax() {
        int max = n - 1;
        for (int i = max - 1; i >= 0; i--) {
            if (SortTemplate.less(a[max], a[i])) {
                max = i;
            }
        }
        return a[max];
    }

    @Override
    public Key delMax() {
        int max = n - 1;
        for (int i = max - 1; i >= 0; i--) {
            if (SortTemplate.less(a[max], a[i])) {
                max = i;
            }
        }
        SortTemplate.exch(a, n - 1, max);

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
        UnorderedArrayMaxPQ<Double> unorderedArrayMaxPQ = new UnorderedArrayMaxPQ<>();
        unorderedArrayMaxPQ.insert(30.0);
        unorderedArrayMaxPQ.insert(21.0);
        unorderedArrayMaxPQ.insert(58.0);
        unorderedArrayMaxPQ.insert(4.0);
        unorderedArrayMaxPQ.insert(5.0);
        System.out.println(unorderedArrayMaxPQ.delMax());
        System.out.println(unorderedArrayMaxPQ.getMax());

    }
}
