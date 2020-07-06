package search.symboltable;

import base.Queue.LinkedListQueue;
import base.Queue.Queue;
import search.OrderedST;

public class BinarySearchST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int n;

    public BinarySearchST(int capacity) {
        this.keys = (Key[]) new Comparable[capacity];
        this.values = (Value[]) new Object[capacity];
    }

    @Override
    public Key min() {
        isNull();
        return keys[0];
    }

    @Override
    public Key max() {
        isNull();
        return keys[n-1];
    }

    @Override
    public Key floor(Key key) {
        isNull();
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) {
            return keys[i];
        } else {
            return keys[i - 1];
        }
    }

    @Override
    public Key ceiling(Key key) {
        isNull();

        int i = rank(key);
        return keys[i];
    }

    @Override
    public int rank(Key key) {
        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp > 0) {
                lo = mid + 1;
            } else if (cmp < 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        return lo;
    }

    @Override
    public Key select(int k) {
        isNull();
        if (k < 0 || k > size()) {
            throw new RuntimeException("索引不合法！");
        }
        return keys[k];
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new LinkedListQueue<>();
        for (int i = rank(lo); i < rank(hi); i++) {
            queue.enqueue(keys[i]);
        }
        if (contains(hi)) {
            queue.enqueue(keys[rank(hi)]);
        }

        return queue;
    }

    @Override
    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) {
            values[i] = value;
            return;
        }

        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }

    @Override
    public Value get(Key key) {
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) {
            return values[i];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public void delete(Key key) {
        isNull();

        int i = rank(key);
        for (int j = i; j < n; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
    }

    private void isNull() {
        if (isEmpty()) {
            throw new RuntimeException("符号表为空！");
        }
    }
}
