package sort.primary;

import edu.princeton.cs.algs4.In;
import sort.SortTemplate;

/**
 * 插入排序。
 * @author YCH
 */
public class Insertion {
   public static void sort(Comparable[] a) {
       int n = a.length;
       for (int i = 1; i < a.length; i++) {
           //将a[i]插入到a[i-1]、a[i-2]、a[i-3]...中
           for (int j = i; j > 0 && SortTemplate.less(a[j], a[j-1]); j--) {
               SortTemplate.exch(a, j, j - 1);
           }
       }
   }
}
