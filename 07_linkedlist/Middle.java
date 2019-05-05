package _07_linkedlist;

/**
 * Function:
 * <p>
 * 链表中间结点
 *
 * @author huanlian77
 * Date: 30/04/2019 10:06
 * @since JDK 1.8
 */
public class Middle {

	/**
	 * 测试
	 */
	public static void main(String[] args) {
		Node node = Node.createNode('a', 'b', 'c', 'd', 'e','f');
		Middle middle = new Middle();
		Node result = middle.invoke(node);
		Node.printCurr(result);
	}

	/**
	 * 中间结点
	 *
	 * @return
	 */
	private Node invoke(Node node) {
		// 边界处理
		if (node == null) {
			return node;
		}

		Node fast = node;
		Node slow = node;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}
}
