package search.binarysearchtree;

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.StdIn;

public class TestBST {
    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            bst.put(key, i);
        }

        System.out.println(bst.max());
        System.out.println(bst.min());
        System.out.println(bst.floor("H"));
        System.out.println(bst.ceiling("H"));
        if ("S".equals(bst.select(bst.rank("S"))) ) {
            System.out.println("isTrue");
        }

        bst.delete("A");
        bst.deleteMin();
        bst.deleteMax();

        for (String s : bst.keys("H", "R")) {
            System.out.println(s + " " + bst.get(s));
        }
    }
}
