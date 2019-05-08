package _09_queue;

import java.util.NoSuchElementException;

/**
 * Function:
 * <p>
 * 使用数组实现循环队列
 *
 * @author huanlian77
 * Date: 30/04/2019 13:57
 * @since JDK 1.8
 */
public class Cycle {


	/**
	 * 默认容量
	 */
	private final static int DEFAULT_CAPACITY = 4;

	/**
	 * 队列容量
	 */
	private int capacity;

	/**
	 * 队列大小
	 */
	private int size;

	private String[] strs;

	/**
	 * 头指针和尾指针
	 */
	private int head;
	private int tail;

	public Cycle() {
		this.capacity = DEFAULT_CAPACITY;
		this.size = 0;
		this.strs = new String[this.capacity];
		this.head = 0;
		this.tail = 0;
	}

	/**
	 * 测试
	 */
	public static void main(String[] args) {
		Cycle cycle = new Cycle();
		cycle.add("a");
		cycle.printAll();
		cycle.add("b");
		cycle.printAll();
		cycle.add("c");
		cycle.printAll();
		cycle.remove();
		cycle.printAll();
		cycle.remove();
		cycle.printAll();
		cycle.remove();
		cycle.printAll();
		cycle.remove();
		cycle.printAll();
		cycle.add("d");
		cycle.printAll();
	}

	/**
	 * 出队
	 */
	private void remove() {
		if (size == 0){
			throw new NoSuchElementException("队列为空了");
		}

		int offset = (head++) % capacity;
		strs[offset] = null;
		size--;
	}

	/**
	 * 打印
	 */
	private void printAll() {
		for (String str : strs) {
			System.out.print(str + ",");
		}
		System.out.println();
	}

	/**
	 * 入队
	 */
	private void add(String str) {
		// 判断队列是否已满
		if (size == capacity) {
			throw new IllegalStateException("队列已满");
		}

		int offset = (tail++) % capacity;
		strs[offset] = str;
		size++;
	}

}
