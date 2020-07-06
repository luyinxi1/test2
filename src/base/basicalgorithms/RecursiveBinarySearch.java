package base.basicalgorithms;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Random;

/**
 * 二分查找的递归实现。
 * @author YCH
 */
public class RecursiveBinarySearch {
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }

        int mid = (lo + hi) / 2;
        if (key < a[mid]) {
            return rank(key, a, lo, mid - 1);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, 0);
        } else {
            return mid;
        }
    }
    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[50];

        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(1000);
        }
        Arrays.sort(a);
        StdOut.print(rank(246, a));
    }
}
