package sort.quick;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import sort.SortCompare;
import sort.SortTemplate;

/**
 * 快速排序
 * @author YCH
 */
public class Quick {
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
                //左指针边界处理（切分元素恰好为最大）
                if (i == hi) {
                    break;
                }
            }
            while (SortTemplate.less(v, a[--j])) {
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

    public static void main(String[] args) {
        String[] a = In.readStrings(args[0]);
        sort(a);
        assert SortTemplate.isSorted(a);
        SortTemplate.show(a);
    }
}
