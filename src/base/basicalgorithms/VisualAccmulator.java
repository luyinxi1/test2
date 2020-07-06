package base.basicalgorithms;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class VisualAccmulator {
    private double total;
    private int n;

    public VisualAccmulator(int trials, double max) {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(0.005);
    }
    public void addDataValue(double val) {
        n++;
        total += val;
        double temp = total / n;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(n, val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(n, temp);
    }

    public static void main(String[] args) {
        int t = Integer.parseInt(args[0]);
        VisualAccmulator visualAccmulator = new VisualAccmulator(t, 1.0);

        for (int i = 0; i < t; i++) {
            visualAccmulator.addDataValue(StdRandom.random());
        }
    }
}
