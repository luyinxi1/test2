package base.analysis;

import base.basicalgorithms.BinarySearch;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/**
 * @author acer
 */
public class ThreesumFast {
    public static int count(int[] a) {
        int n = a.length;
        int cnt = 0;

        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (BinarySearch.rank(-(a[i] + a[j]), a) > j) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        System.out.println(count(a));
    }
}
