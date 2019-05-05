package _06_linkedlist;

import java.util.Scanner;

/**
 * Function:
 * <p>
 * 使用数组实现LRU
 *
 * @author huanlian77
 * Date: 29/04/2019 14:07
 * @since JDK 1.8
 */
public class LRUBaseArray<T> {

	/**
	 * 默认数组大小
	 */
	private final static Integer DEFAULT_CAPACITY = (1 << 3);

	/**
	 * 数组容量
	 */
	private Integer capacity;

	/**
	 * 数组大小
	 */
	private Integer count;

	private T[] value;

	public LRUBaseArray() {
		this.capacity = DEFAULT_CAPACITY;
		this.count = 0;
		this.value = (T[]) new Object[capacity];
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		LRUBaseArray lruBaseArray = new LRUBaseArray();
		Scanner sc = new Scanner(System.in);
		while (true) {
			lruBaseArray.add(sc.nextInt());
			lruBaseArray.printAll();
		}


	}

	/**
	 * 打印所有元素
	 */
	private void printAll() {
		for (T t : value) {
			System.out.print(t + ",");
		}
		System.out.println();
	}

	/**
	 * 添加元素
	 */
	private void add(T data) {
		if (data == null) {
			return;
		}

		int offset = findData(data);
		// 查找到数据
		if (offset != -1) {
			deleteAtOffset(offset);
		} else {
			// 判断数组是否已满
			if (count >= capacity) {
				deleteAtFirst();
			}
		}
		insertAtEnd(data);
	}

	/**
	 * 删除头部元素
	 */
	private void deleteAtFirst() {
		deleteAtOffset(0);
	}

	/**
	 * 加入末尾
	 */
	private void insertAtEnd(T item) {
		value[count] = item;
		count++;
	}

	/**
	 * 删除元素
	 */
	private void deleteAtOffset(int offset) {
		System.arraycopy(value, offset + 1, value, offset,
				value.length - offset - 1);
		count--;
	}

	/**
	 * 查询元素
	 */
	private int findData(T data) {
		for (int i = 0; i < value.length; i++) {
			if (data.equals(value[i])) {
				return i;
			}
		}
		return -1;
	}
}
