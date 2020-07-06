package base.basicalgorithms;

import java.util.Arrays;
import java.util.Random;

import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {
	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (key > a[mid]) {
				lo = mid + 1;
			} else if (key < a[mid]) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Random random = new Random();
		int[] a = new int[50];

		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(1000);
		}
		Arrays.sort(a);
		StdOut.print(rank(246, a));
	}

}
