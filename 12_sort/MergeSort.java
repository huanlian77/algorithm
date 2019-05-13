package _12_sort;

/**
 * Function:
 * <p>
 * 归并排序
 *
 * @author huanlian77
 * Date: 30/04/2019 23:45
 * @since JDK 1.8
 */
public class MergeSort {
	/**
	 * 测试
	 */
	public static void main(String[] args) {
		int[] arr = new int[]{4, 5, 6, 3, 2, 1};
		MergeSort mergeSort = new MergeSort();
		mergeSort.invoke(arr, 0, arr.length - 1);
		mergeSort.printAll(arr);
	}

	/**
	 * 归并排序
	 * <p>
	 * 时间复杂度 O(nlogn)
	 * 空间复杂度 O(n) - 因为需要临时数组
	 * <p>
	 * 不是原地排序算法
	 * <p>
	 * 是稳定排序算法
	 *
	 * @param arr 原数组
	 * @param p   开始索引
	 * @param r   结束索引
	 */
	private void invoke(int[] arr, int p, int r) {
		if (p >= r) return;

		// 求中间位
		int q = p + (r - p) / 2;
		invoke(arr, p, q);
		invoke(arr, q + 1, r);

		merge(arr, p, q, r);
	}


	/**
	 * 合并
	 *
	 * @param arr 原数组
	 * @param p   开始索引
	 * @param q   中间索引
	 * @param r   结束索引
	 */
	private void merge(int[] arr, int p, int q, int r) {
		// 临时数组
		int[] temp = new int[r - p + 1];
		int i = p;
		int j = q + 1;
		int index = 0;

		while (i <= q && j <= r) {
			if (arr[i] <= arr[j]) {
				temp[index++] = arr[i++];
			} else {
				temp[index++] = arr[j++];
			}
		}

		while (i <= q) {
			temp[index++] = arr[i++];
		}

		while (j <= r) {
			temp[index++] = arr[j++];
		}

		// 临时数组复制到arr中
		for (int k = 0; k < temp.length; k++) {
			arr[p + k] = temp[k];
		}
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
