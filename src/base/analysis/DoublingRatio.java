package base.analysis;

import edu.princeton.cs.algs4.StdRandom;

public class DoublingRatio {
    public static void main(String[] args) {
        double prev = timeTrial(125);
        for (int n = 250; true; n += n) {
            double time = timeTrial(n);
            System.out.printf("%6d %7.1f", n, time);
            System.out.printf("%5.1f\n", time / prev);
            prev = time;
        }
    }
    public static double timeTrial(int n) {
        final int MAX = 1000000;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        StopWatch timer = new StopWatch();
        int cnt = ThreeSum.count(a);
        return timer.elapseTime();
    }
}
