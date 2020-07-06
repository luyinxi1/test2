package sort.application;

import edu.princeton.cs.algs4.StdOut;
import sort.quick.Quick;

import java.util.Arrays;

/**
 * 2.5.4-双指针实现排序并删除重复元素。
 */
public class Test1 {
    public static String[] dedup(String[] a) {
        Quick.sort(a);

        //控制指针，当元素重复时停下，当不重复时交换i, j + 1的值实现数组的改变
        int i = 0;
        //遍历指针
        int j = 1;

        while (j < a.length) {
            if (a[j].compareTo(a[i]) != 0) {
                //当ij相邻时不改变数组，否则会将重复元素替换为正确的值
                a[++i] = a[j++];
            } else {
                //向前遍历直至不再重复
                j++;
            }
        }

        String[] temp = new String[i + 1];
        for (int k = 0; k < temp.length; k++) {
            temp[k] = a[k];
        }

        return temp;
    }

    public static void main(String[] args) {
        String[] s = {"W", "J", "H", "U", "R",  "B", "W", "B", "A",  "U", "Y", "N", "F", "Y", "H", "V", "P", "V", "K", "W",
                "Z", "Q", "N", "B", "C", "B", "E", "W", "L", "T", "T", "U", "E", "E", "E", "V", "Q", "D",  "P", "H",
                "U", "G", "E",  "U", "T", "W", "L", "W", "D", "I", "E", "B", "N", "G", "T", "K", "Y", "J", "P", "L", "B",
                "K", "N", "E", "Z", "N", "V", "I", "A", "V", "P", "J",  "X", "G", "V", "P"};
        StdOut.println(Arrays.toString(s));
        StdOut.println(Arrays.toString(dedup(s)));
    }
}
