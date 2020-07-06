package base.basicalgorithms;


/**
 * 常见数值处理算法
 * @author YCH
 */
public class NumericalProcessing {
	/**
	 * 计算绝对值。
	 * @param x
	 */
	public static double abs(double x)
	{
		if(x < 0) {
			return -x;
		} else {
			return x;
		}
	}

	/**
	 * 判断给定数字是否是素数。
	 * @param n
	 */
	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 计算调和级数。
	 * @param n
	 */
	public static double h(int n) {
		double sum = 0.0;
		for (int i = 1; i <= n; i++) {
			sum += 1.0 / i;
		}
		return sum;
	}
	public static void main(String[] args) {

	}

}
