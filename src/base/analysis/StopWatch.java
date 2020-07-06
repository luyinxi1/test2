package base.analysis;

import edu.princeton.cs.algs4.StdRandom;

public class StopWatch {
    private long start;

    public StopWatch() {
        this.start = System.currentTimeMillis();
    }

    public double elapseTime() {
        long now = System.currentTimeMillis();
        double p = (now - start) / 1000.0;
        return p;
    }

    public static void main(String[] args) {
        int[] a = new int[1000];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(-1000000, 1000000);
        }
        StopWatch timer = new StopWatch();
        int cnt = ThreeSum.count(a);
        double time = timer.elapseTime();
        System.out.println(time);
    }
}
