package _07_linkedlist;

/**
 * Function:
 * <p>
 * 反转单链表，时间复杂度 O(n)
 *
 * @author huanlian77
 * Date: 29/04/2019 17:36
 * @since JDK 1.8
 */
public class Reverse {

	public static void main(String[] args) {
		Node node = Node.createNode('a', 'b', 'c', 'd', 'e');
		Reverse reverse = new Reverse();
		Node resultNode = reverse.invoke(node);
		Node.printAll(resultNode);
	}


	/**
	 * 反转
	 */
	private Node invoke(Node node) {

		// 边界处理
		if (node == null || node.next == null) {
			return node;
		}

		Node reverse = null;
		while (node != null) {
			Node temp = node.next;
			node.next = reverse;
			reverse = node;
			node = temp;
		}

		return reverse;
	}


}
