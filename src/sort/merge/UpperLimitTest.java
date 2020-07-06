package sort.merge;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import sort.SortTemplate;

import java.awt.*;

/**
 * 2.2.6-归并排序的实际数组访问次数与理论值的函数图像比较。
 * @author YCH
 */
public class UpperLimitTest {
    private static Comparable[] aux;
    private static int accessTimes;

    private static boolean less(Comparable v, Comparable w) {
        accessTimes += 2;
        return v.compareTo(w) < 0;
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
            accessTimes += 2;
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
                accessTimes += 2;
            } else if (j > hi) {
                a[k] = aux[i++];
                accessTimes += 2;
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
                accessTimes += 2;
            } else {
                a[k] = aux[i++];
                accessTimes += 2;
            }
        }
    }

    public static void draw() {
        StdDraw.setXscale(0, 512);
        StdDraw.setYscale(-1000, 28000);
        for (int i = 1; i <= 512; i++) {
            Double[] arr = new Double[i];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = StdRandom.uniform();
            }
            sort(arr);
            StdDraw.setPenColor(Color.RED);
            StdDraw.point(i, 6 * i * (Math.log(i) / Math.log(2)));
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.point(i, accessTimes);
            accessTimes = 0;
        }
    }

    public static void main(String[] args) {
        draw();
    }
}
