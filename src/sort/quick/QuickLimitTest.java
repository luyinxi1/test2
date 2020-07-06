package sort.quick;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import sort.SortTemplate;

import java.awt.*;

/**
 * @author acer
 */
public class QuickLimitTest {
    private static int accessTimes = 0;
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        //左右扫描指针
        int i = lo;
        int j = hi + 1;
        //切分元素
        Comparable v = a[lo];

        while (true) {
            while (SortTemplate.less(a[++i], v)) {
                accessTimes++;
                //左指针边界处理（切分元素恰好为最大）
                if (i == hi) {
                    break;
                }
            }
            while (SortTemplate.less(v, a[--j])) {
                accessTimes++;
                //右指针边界处理（切分元素恰好为最小）
                if (j == lo) {
                    break;
                }
            }
            //指针相遇
            if (i >= j) {
                break;
            }
            SortTemplate.exch(a, i, j);
        }

        //将切分元素放置到合适的位置
        SortTemplate.exch(a, lo, j);
        return j;
    }

    public static void draw() {
        StdDraw.setXscale(0, 10000);
        StdDraw.setYscale(-1000, 190000);
        for (int i = 1; i <= 10000; i++) {
            Double[] arr = new Double[i];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = StdRandom.uniform();
            }
            sort(arr);
            StdDraw.setPenColor(Color.RED);
            StdDraw.point(i, 2 * i * (Math.log(i) / Math.log(Math.E)));
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.point(i, accessTimes);
            accessTimes = 0;
        }
    }
    public static void main(String[] args) {
        draw();
    }
}
