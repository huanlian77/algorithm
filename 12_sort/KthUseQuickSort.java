package _12_sort;

/**
 * Function:
 * 思考题：使用快排思想在O(n)内查找第K大的元素？
 * <p>
 * 分析：快速排序的时间复杂度是 O(nlogn)，直接使用是不行的，
 * 对快速排序进行改造，对要查找的数组进行分区，第一次需要遍历 n 个元素，第二次需要遍历 n/2 个元素，依次内推，
 * 需要遍历 n + n/2 + n/4 + ... + 1 = 2n -2 ，所以时间复杂度是 O(n)
 *
 * @author huanlian77
 * Date: 04/05/2019 21:42
 * @since JDK 1.8
 */
public class KthUseQuickSort {

	private static final int K = 2;

	/**
	 * 测试
	 */
	public static void main(String[] args) {
		int[] arr = new int[]{1, 1, 2};
		KthUseQuickSort kthUseQuickSort = new KthUseQuickSort();
		int kth = kthUseQuickSort.invoke(arr, 0, arr.length - 1, K);
		System.out.println(kth);

	}

	/**
	 * 使用快排思想在O(n)内查找第K大的元素
	 *
	 * @param arr 原元素
	 * @param p   开始索引
	 * @param r   结束索引
	 * @param k   指定第K大的数
	 */
	private int invoke(int[] arr, int p, int r, int k) {
		// 分区
		int q = partition(arr, p, r);
		while (q + 1 != k) {
			if (q + 1 < k) {
				q = partition(arr, q + 1, r);
			} else {
				q = partition(arr, p, q - 1);
			}
		}
		return arr[q];
	}

	/**
	 * 获取分区点
	 *
	 * @param arr 原数组
	 * @param p   开始索引
	 * @param r   结束索引
	 */
	private int partition(int[] arr, int p, int r) {
		int pivot = arr[r];
		int i = p;
		for (int j = p; j < r; j++) {
			// 这里要是 <= ，不然会出现死循环，比如查找数组 [1,1,2] 的第二小的元素
			if (arr[j] <= pivot) {
				if (i != j) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				i++;
			}
		}

		int temp = arr[i];
		arr[i] = arr[r];
		arr[r] = temp;

		return i;
	}

}
