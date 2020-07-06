package search.binarysearchtree;

import search.OrderedST;

/**
 * 非递归的二叉查找树。
 * @author YCH
 */
public class NonRecursiveBST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {
    private Node root;
    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int n;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }

    @Override
    public Key min() {
        Node x = root;
        while (x.left != null) {
            x = x.left;
        }
        return x.key;
    }

    @Override
    public Key max() {
        Node x = root;
        while (x.right != null) {
            x = x.right;
        }
        return x.key;
    }

    @Override
    public Key floor(Key key) {
        Node temp = null;
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp == 0) {
                return x.key;
            } else {
                temp = x;
                x = x.right;
            }
        }

        return temp.key;
    }

    @Override
    public Key ceiling(Key key) {
        Node temp = null;
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp > 0) {
                x = x.right;
            } else if (cmp == 0) {
                return x.key;
            } else {
                temp = x;
                x = x.left;
            }
        }

        return temp.key;
    }

    @Override
    public int rank(Key key) {
        int count = 0;
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return count + size(x.left);
            } else if (cmp < 0) {
                x = x.left;
            } else {
                count += size(x.left) + 1;
                x = x.right;
            }
        }

        return count;
    }

    @Override
    public Key select(int k) {
        Node x = root;
        while (x != null) {
            int ls = size(x.left);
            if (k < ls) {
                x = x.left;
            } else if (k > ls) {
                x = x.right;
                k -= (ls + 1);
            } else {
                return x.key;
            }
        }
        return null;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    @Override
    public void put(Key key, Value value) {

    }

    @Override
    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.value;
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.n;
        }
    }

}
