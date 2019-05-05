package _07_linkedlist;

/**
 * Function:
 * <p>
 * 有序链表合并
 *
 * @author huanlian77
 * Date: 29/04/2019 22:43
 * @since JDK 1.8
 */
public class MergeSorted {


	public static void main(String[] args) {
		Node node1 = Node.createNode('a', 'd', 'f');
		Node node2 = Node.createNode('b', 'c', 'e');

		MergeSorted mergeSorted = new MergeSorted();
		Node resultNode = mergeSorted.invoke(node1, node2);
		Node.printAll(resultNode);
	}

	/**
	 * 有序链表合并
	 *
	 * @param node1 有序链表1
	 * @param node2 有序链表2
	 * @return 返回合并的新链表，也是有序的
	 */
	private Node invoke(Node node1, Node node2) {
		// 边界处理
		if (node1 == null) return node2;
		if (node2 == null) return node1;

		// 找到头节点
		Node head;
		if (node1.val < node2.val) {
			head = node1;
			node1 = node1.next;
		} else {
			head = node2;
			node2 = node2.next;
		}


		// 比较 node1 和 node2 的大小
		Node r = head;
		while (node1 != null && node2 != null) {
			if (node1.val < node2.val) {
				r.next = node1;
				node1 = node1.next;
			} else {
				r.next = node2;
				node2 = node2.next;
			}
			r = r.next;
		}

		// node1 和 node2 不为 null 的一个，追加到 r 中
		if (node1 == null) {
			r.next = node2;
		} else {
			r.next = node1;
		}

		return head;
	}
}
