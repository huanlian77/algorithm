package _11_sort;

/**
 * Function:
 * 选择排序
 *
 * @author huanlian77
 * Date: 30/04/2019 17:01
 * @since JDK 1.8
 */
public class SelectSort {

	/**
	 * 测试
	 */
	public static void main(String[] args) {
		int[] arr = new int[]{4, 5, 6, 3, 2, 1};
		SelectSort selectSort = new SelectSort();
		int[] result = selectSort.invoke(arr);
		selectSort.printAll(result);
	}


	/**
	 * 选择排序
	 * <p>
	 * 最坏时间复杂度 O(n^2) 最好时间复杂度O(n^2) 平均时间复杂度 O(n^2)
	 * 空间复杂度O(1)
	 * <p>
	 * 原地排序算法
	 * <p>
	 * 不是稳定排序算法，列入 5,3,5,2,6 在第一次交换位后变为 2,3,5,5  这时两个 5 的前后关系发生了变化
	 */
	private int[] invoke(int[] arr) {
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			// 假设第一个数是最小的
			int min = i;
			// 找到剩余位中最小的
			int j = i + 1;
			for (; j < length; j++) {
				if (arr[min] > arr[j]){
					min = j;
				}
			}

			// 找到最小数后，将它与 i 位的数进行交换
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}

		return arr;
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
