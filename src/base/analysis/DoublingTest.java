package base.analysis;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.ThreeSumFast;

import java.math.BigDecimal;
import java.util.Random;

public class DoublingTest {
    public static void main(String[] args) {
//        for (int n = 250; true; n += n) {
//            double time = timeTrial(n);
//            System.out.printf("%7d %5.3f\n", n, time);
//        }
        drawLgN(3000);
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
    public static void drawStd(int n) {
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, 1);
        StdDraw.setPenRadius(0.005);
        for (int i = 1; i <= n; i++) {
            StdDraw.point(i, timeTrial(i));
        }
    }
    public static void drawLgN(int n) {
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(-1, 1);
        StdDraw.setPenRadius(0.005);
        for (int i = 1; i <= n; i++) {
            double y = Math.log(timeTrial(i));
            StdDraw.point(i, y);
        }
    }
}
