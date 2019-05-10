package _11_sort;

/**
 * Function:
 * 插入排序
 *
 * @author huanlian77
 * Date: 30/04/2019 17:01
 * @since JDK 1.8
 */
public class InsertSort {

	/**
	 * 测试
	 */
	public static void main(String[] args) {
		int[] arr = new int[]{4, 5, 6, 3, 2, 1};
		InsertSort insertSort = new InsertSort();
		int[] result = insertSort.invoke(arr);
		insertSort.printAll(result);
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
	 * 插入排序
	 * <p>
	 * 最坏时间复杂度 O(n^2) 最好时间复杂度O(n) 平均时间复杂度 O(n^2)
	 * 空间复杂度O(1)
	 * <p>
	 * 原地排序算法
	 * <p>
	 * 稳定排序算法
	 */
	private int[] invoke(int[] arr) {
		int length = arr.length;
		for (int i = 1; i < length; i++) {
			int value = arr[i];
			// 从前几位中找到大于 value 的并把它们后移以为
			int j = i - 1;
			for (; j >= 0; j--) {
				if (value < arr[j]) {
					arr[j + 1] = arr[j];
				} else {
					break;
				}
			}
			// 注意，这里是j+1，因为for循环循环完一次要执行j--
			arr[j + 1] = value;
		}

		return arr;
	}
}
