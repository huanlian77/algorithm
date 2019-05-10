package _11_sort;

/**
 * Function:
 * 冒泡排序
 *
 * @author huanlian77
 * Date: 30/04/2019 15:51
 * @since JDK 1.8
 */
public class BubbleSort {

	/**
	 * 测试
	 */
	public static void main(String[] args) {

		int[] arr = new int[]{4, 5, 6, 3, 2, 1};
		BubbleSort bubbleSort = new BubbleSort();
		int[] result = bubbleSort.invoke(arr);
		bubbleSort.printAll(result);
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

	/**
	 * 冒泡排序
	 * <p>
	 * 最坏时间复杂度 O(n^2) 最好时间复杂度O(n) 平均时间复杂度O(n^2)
	 * 空间复杂度O(1)
	 * <p>
	 * 是原地排序算法
	 * <p>
	 * 是稳定排序算法
	 */
	private int[] invoke(int[] arr) {
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			// 提前退出冒泡排序标识
			boolean flag = false;
			for (int j = 0; j < length - 1 - i; j++) {
				// 进行交换
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = true;
				}
			}

			if (!flag) break;
		}

		return arr;
	}


}
