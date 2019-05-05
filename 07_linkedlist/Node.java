package _07_linkedlist;

/**
 * Function:
 * <p>
 * 链表定义
 *
 * @author huanlian77
 * Date: 29/04/2019 17:36
 * @since JDK 1.8
 */
public class Node {
	char val;
	Node next;

	Node(char x) {
		val = x;
	}

	/**
	 * 打印
	 */
	public static void printAll(Node node) {

		if (node == null) {
			return;
		}

		while (node != null) {
			System.out.print(node.val + ",");
			node = node.next;
		}

		System.out.println();

	}


	/**
	 * 根据chars创建结点（没有环)
	 */
	public static Node createNode(char... chars) {
		// 参数长度为0，返回null
		if (chars.length == 0) {
			return null;
		}

		// 创建头节点
		Node head = null;
		Node r = null;
		for (char c : chars) {
			if (head == null) {
				head = new Node(c);
				r = head;
			} else {
				r.next = new Node(c);
				r = r.next;
			}
		}
		return head;
	}


	/**
	 * 获取链表长度
	 */
	public static int length(Node node) {
		if (node == null) {
			return 0;
		}
		int length = 0;
		while (node != null) {
			length++;
			node = node.next;
		}
		return length;
	}

	public static void main(String[] args) {
		Node node = null;
		int length = Node.length(node);

		System.out.println(length);
	}

	/**
	 * 打印当前结点
	 */
	public static void printCurr(Node node) {
		if (node == null) return;
		System.out.println(node.val);
	}
}
