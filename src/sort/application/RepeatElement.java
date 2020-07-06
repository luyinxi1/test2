package sort.application;

import edu.princeton.cs.algs4.Count;

import java.util.Arrays;

/**
 * 数组的重复元素问题。
 * @author YCH
 */
public class RepeatElement {
    /**
     * 数组是否存在重复的元素。
     */
    public static boolean isRepeat(Comparable[] a) {
        Arrays.sort(a);
        boolean flag = false;

        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) == 0) {
                //以flag作为重复元素出现的标识
                flag = true;
                break;
            }
        }

        return flag;
    }

    /**
     * 打印出数组中所有的重复值与重复值总数。
     * @param a
     * @return
     */
    public static int repeatElementQuantity(Comparable[] a) {
        int count = 0;
        Arrays.sort(a);
        //最后出现重复的元素
        Comparable temp = null;

        for (int i = 1; i < a.length; i++) {
            //有元素出现重复且与最后出现重复的元素不同（即出现了新的重复元素）
            if (a[i].compareTo(a[i-1]) == 0 && !a[i-1].equals(temp)) {
                temp = a[i-1];
                System.out.print(temp + " ");
                count++;
            }
        }

        return count;
    }

    public static Comparable max(Comparable[] a) {
        Arrays.sort(a);

        //最大重复次数
        int count = 0;
        //重复次数最多的元素
        Comparable temp = null;

        //记录某个元素重复的次数
        int num = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) == 0) {
                num++;
                //该元素重复次数大于已知最大重复次数
                if (num > count) {
                    count = num;
                    temp = a[i-1];
                }
            } else {
                //重复结束
                num = 0;
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        Integer[] integers = {9, 8, 4, 12, 5, 4, 4, 6, 6, 6, 6, 12};
        System.out.println(max(integers));
    }
}
