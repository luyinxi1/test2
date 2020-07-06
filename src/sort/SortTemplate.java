package sort;

public class SortTemplate {
    /**
     * 判断第一个参数的主键是否小于第二个参数的主键。
     * @param v
     * @param w
     * @return
     */
     public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换一个Comparble数组中两个索引对应的元素。
     * @param a
     * @param i
     * @param j
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 在单行打印出数组a的内容。
     * @param a
     */
    public static void show(Comparable[] a) {
        for (Comparable comparable : a) {
            System.out.print(comparable + " ");
        }
    }

    /**
     * 判断数组a是否已有序。
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

}
