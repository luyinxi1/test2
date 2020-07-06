package sort;

import base.analysis.StopWatch;
import edu.princeton.cs.algs4.StdRandom;
import sort.merge.Merge;
import sort.primary.Insertion;
import sort.primary.InsertionFast;
import sort.primary.Selection;
import sort.primary.Shell;
import sort.priorityqueue.Heap;
import sort.quick.Quick;
import sort.quick.Quick3Way;

public class SortCompare {
    public static double time(String alg, Comparable[] a) {
        StopWatch timer = new StopWatch();
        switch (alg) {
            case "Insertion": Insertion.sort(a); break;
            case "Selection": Selection.sort(a); break;
            case "InsertionFast" : InsertionFast.sort(a); break;
            case "Shell" : Shell.sort(a); break;
            case "Merge" : Merge.sort(a); break;
            case "Quick" : Quick.sort(a); break;
            case "Quick3Way" : Quick3Way.sort(a); break;
            case "Heap" : Heap.sort(a); break;
            default: throw new RuntimeException("指定的算法有误");
        }

        return timer.elapseTime();
    }
    public static double timeRandomInput(String alg, int n, int t) {
        double total = 0.0;
        Double[] a = new Double[n];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n; j++) {
                a[j] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int n = Integer.parseInt(args[2]);
        int t = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, n, t);
        double t2 = timeRandomInput(alg2, n, t);
        System.out.println(alg1 + "的运行时间是：" + t1);
        System.out.println(alg2 + "的运行时间是：" + t2);
        System.out.printf("%s的运行时间是%s的%.1f倍。\n", alg2, alg1, t1 / t2);
    }
}
