package _12_sort;

/**
 * Function:
 * <p>
 * 快速排序
 *
 * @author huanlian77
 * Date: 30/04/2019 23:46
 * @since JDK 1.8
 */
public class QuickSort {

	/**
	 * 测试
	 */
	public static void main(String[] args) {
		int[] arr = new int[]{1,3,5,7,3};
		QuickSort quickSort = new QuickSort();
		quickSort.invoke(arr, 0, arr.length - 1);
		quickSort.printAll(arr);
	}

	/**
	 * 快速排序
	 * <p>
	 * 时间复杂度 O(nlogn)
	 * 空间复杂度 O(1)
	 * <p>
	 * 是原地排序算法
	 * <p>
	 * 不是稳定排序算法
	 *
	 * @param arr 原数组
	 * @param p   开始索引
	 * @param r   结束索引
	 */
	private void invoke(int[] arr, int p, int r) {
		if (p >= r) return;

		// 获取分区点
		int q = partition(arr, p, r);
		// 分治
		invoke(arr, p, q - 1);
		invoke(arr, q + 1, r);
	}

	/**
	 * 获取分区点
	 *
	 * @param arr 原数组
	 * @param p   开始索引
	 * @param r   结束索引
	 */
	private int partition(int[] arr, int p, int r) {
		// 划分点
		int pivot = arr[r];
		int i = p;
		for (int j = p; j < r; j++) {
			if (arr[j] < pivot) {
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

	/**
	 * 打印数组
	 */
	private void printAll(int[] arr) {
		for (int i : arr) {
			System.out.print(i + ",");
		}
		System.out.println();
	}

}
