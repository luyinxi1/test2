package search;

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.StdIn;
import search.binarysearchtree.RecursiveBST;

import java.util.Iterator;

/**
 * YCH
 * @author acer
 */
public class BehaviorTest {
    public static void main(String[] args) {
        RecursiveBST<String, Integer> st = new RecursiveBST<>();

        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        for (String s : st.keys()) {
            System.out.println(s + " " + st.get(s));
        }
    }
}
