package _07_linkedlist;

/**
 * Function:
 * <p>
 * 删除链表倒数第k个结点
 *
 * @author huanlian77
 * Date: 29/04/2019 23:58
 * @since JDK 1.8
 */
public class DeleteLastKth {

	private final static int K = 5;

	/**
	 * 测试
	 */
	public static void main(String[] args) {
		Node node = Node.createNode('a', 'b', 'c', 'd', 'e');

		DeleteLastKth deleteLastKth = new DeleteLastKth();
		Node result = deleteLastKth.invoke(node, K);
		Node.printAll(result);
	}

	/**
	 * 删除倒数第k个结点
	 *
	 * @param node 链表
	 * @param k    倒数K值
	 */
	private Node invoke(Node node, int k) {
		// 边界处理
		if (Node.length(node) < k) {
			throw new IllegalArgumentException("链表长度为：" + Node.length(node) + ", 但是要删除的K值为：" + k);
		}

		Node temp = node;
		int step = Node.length(node) - k;
		// 删除头结点
		if (step == 0) {
			temp = temp.next;
			return temp;
		}
		// 不是头结点，获取要删除结点的前一个结点
		while (--step > 0) {
			temp = temp.next;
		}

		// 获取删除结点
		Node deleteNode = temp.next;
		temp.next = temp.next.next;
		// 置为null,帮助垃圾回收器收集
		deleteNode = null;

		return node;
	}

}
