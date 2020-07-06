package base.basicalgorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Scanner;

/**
 * 常见的数组处理算法。
 * @author YCH
 */
public class ArrayProcessing
{
    public static double max(double[] a)
    {
        double max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        return max;
    }

    public static double average(double[] a)
    {
        double sum = 0;
        int length = a.length;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        return sum / length;
    }

    public static double[] copy(double[] a)
    {
        int length = a.length;
        double[] b = new double[length];

        for (int i = 0; i < length; i++) {
            b[i] = a[i];
        }

        return b;
    }

    /**
     * 翻转数组
     * @param a
     */

    public static void insert(double[] a)
    {
        int N = a.length;
        for (int i = 0; i < N / 2; i++) {
            double temp = a[i];
            a[i] = a[N - i - 1];
            a[N- i - 1] = temp;
        }
    }

    //	public static double[][] muxmtl(double[][] a)
//	{
//		int N =a.length;
//		double[][] c = new double[N][N];
//		
//	}

    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);

        for (int i = 0; i < N; i++) {
            double x = StdRandom.uniform(lo, hi);
            StdOut.printf("%.2f\n", x);
        }
    }
}

