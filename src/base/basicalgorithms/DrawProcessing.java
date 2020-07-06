package base.basicalgorithms;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class DrawProcessing {
    public static void function() {
        int n = 100;
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n * 10);
        StdDraw.setPenRadius(.01);

        for (int i = 1; i <= n; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * i);
            StdDraw.point(i, i * Math.log(i));
        }
    }

    public static void randomArray() {
        int n = 100;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.random();
        }

        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            double x = 1.0 * i / n;
            double y = a[i] / 2.0;
            double rw = 0.5 / n;
            double rh = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

    public static void main(String[] args) {
        randomArray();
    }
}
