package _08_stack;

/**
 * Function:
 * <p>
 * 链表实现栈
 *
 * @author huanlian77
 * Date: 30/04/2019 11:35
 * @since JDK 1.8
 */
public class StackBaseLinkedList<T> {


	/**
	 * 默认容量
	 */
	private final static int DEFAULT_CAPACITY = 10;

	/**
	 * 链表
	 */
	private Node<T> node;

	/**
	 * 栈大小
	 */
	private int count;

	/**
	 * 栈容量
	 */
	private int capacity;

	public StackBaseLinkedList() {
		this.capacity = DEFAULT_CAPACITY;
		this.node = null;
		this.count = 0;
	}


	class Node<T> {
		T val;
		Node<T> next;


		public Node(T val) {
			this.val = val;
		}

	}


	/**
	 * 测试
	 */
	public static void main(String[] args) {
		StackBaseLinkedList<String> stringStackBaseLinkedList = new StackBaseLinkedList<>();
		stringStackBaseLinkedList.push("a");
		stringStackBaseLinkedList.push("b");
		stringStackBaseLinkedList.push("c");
		stringStackBaseLinkedList.push("d");
		stringStackBaseLinkedList.push("e");
		stringStackBaseLinkedList.printAll();

		String result = stringStackBaseLinkedList.pop();
		System.out.println("出栈：" + result);
		stringStackBaseLinkedList.printAll();
	}

	private T pop() {
		if (count == 0) {
			return null;
		}
		T val = node.val;
		node = node.next;
		return val;

	}

	/**
	 * 打印所有
	 */
	private void printAll() {
		Node next = node;
		while (next != null) {
			System.out.print(next.val + ",");
			next = next.next;
		}
		System.out.println();
	}

	/**
	 * 入栈
	 *
	 * @param a
	 */
	private void push(T a) {
		if (count == capacity) {
			return;
		}
		Node<T> newNode = new Node<>(a);
		newNode.next = node;
		node = newNode;
		count++;
	}
}
