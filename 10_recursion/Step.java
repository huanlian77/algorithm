package _10_recursion;

/**
 * Function:
 * <p>
 * 有 n 个台阶，每次你可以跨 1 个台阶或者 2 个，请问走这 n 个台阶有多少种走法？
 *
 * @author huanlian77
 * Date: 30/04/2019 14:24
 * @since JDK 1.8
 */
public class Step {

	private final static int N = 46;

	/**
	 * 测试
	 */
	public static void main(String[] args) {
		Step step = new Step();
		long start = System.currentTimeMillis();
		int count = step.invoke(N);
		long end = System.currentTimeMillis();
		System.out.println(N + "个台阶有" + count + "种走法，计算出来耗时时间：" + (end - start) + "毫秒");

		start = System.currentTimeMillis();
		count = step.invokeNotRecursion(N);
		end = System.currentTimeMillis();
		System.out.println(N + "个台阶有" + count + "种走法，计算出来耗时时间：" + (end - start) + "毫秒");
	}

	/**
	 * 非递归 时间复杂度 O(n) 空间复杂度 O(1)
	 */
	private int invokeNotRecursion(int n) {
		if (n == 1) return 1;
		if (n == 2) return 2;

		int first = 1;
		int second = 2;
		int temp = 0;
		for (int i = 3; i <= n; i++) {
			temp = first;
			first = second;
			second = temp + first;
		}

		return second;
	}

	/**
	 * 递归 时间复杂度 O(n) 空间复杂度 O(n)
	 */
	private int invoke(int n) {
		if (n == 1) return 1;
		if (n == 2) return 2;
		return invoke(n - 1) + invoke(n - 2);
	}


}
