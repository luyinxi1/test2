package base.analysis;

import base.basicalgorithms.BinarySearch;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class DoubleEqual {
    public static void main(String[] args) {
        final int MAX = 1000;
        int[] a = new int[1000];
        for (int i = 0; i < 1000; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        System.out.println(count(a));
    }
    public static int count(int[] a) {
        int n = a.length;
        int cnt = 0;

        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            if (BinarySearch.rank(a[i], a) > i) {
                cnt++;
            }
        }
        return cnt;
    }

}
