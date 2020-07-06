package base.analysis;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

/**
 * 统计一个文件中所有和为0的三整数元组的数量-暴力算法。
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        System.out.println(count(a));
    }

    public static int count(int[] a) {
        int n = a.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((long)a[i] + a[j] + a[k] == 0) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}
