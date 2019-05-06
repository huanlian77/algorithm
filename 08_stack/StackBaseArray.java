package _08_stack;

/**
 * Function:
 * <p>
 * 数组实现栈
 *
 * @author huanlian77
 * Date: 30/04/2019 11:21
 * @since JDK 1.8
 */
public class StackBaseArray {

	/**
	 * 栈中元素
	 */
	private int count;

	/**
	 * 栈容量
	 */
	private int capacity;

	/**
	 * 数组
	 */
	private String[] strs;

	/**
	 * 默认容量
	 */
	private final static int DEFAULT_CAPACITY = 10;

	public StackBaseArray() {
		this.capacity = DEFAULT_CAPACITY;
		this.strs = new String[this.capacity];
		this.count = 0;
	}

	/**
	 * 测试
	 */
	public static void main(String[] args) {
		StackBaseArray stackBaseArray = new StackBaseArray();
		// 入栈
		stackBaseArray.push("a");
		stackBaseArray.push("b");
		stackBaseArray.push("c");
		stackBaseArray.push("d");
		stackBaseArray.printAll();

		// 出栈
		String pop = stackBaseArray.pop();
		System.out.println("出栈：" + pop);
		stackBaseArray.printAll();
	}

	/**
	 * 打印全部
	 */
	private void printAll() {
		for (String str : strs) {
			System.out.print(str + ",");
		}
		System.out.println();
	}

	/**
	 * 出栈
	 */
	private String pop() {
		// 空栈
		if (count == 0) {
			return null;
		}
		String str = strs[--count];
		strs[count] = null;
		return str;
	}

	/**
	 * 入栈
	 */
	private void push(String c) {
		// 栈已满
		if (count == capacity) {
			return;
		}

		strs[count++] = c;
	}


}
