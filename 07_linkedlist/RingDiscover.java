package _07_linkedlist;

/**
 * Function:
 * 链表中环的检测
 *
 * @author huanlian77
 * Date: 29/04/2019 20:16
 * @since JDK 1.8
 */
public class RingDiscover {


	public static void main(String[] args) {
		Node node = Node.createNode('a','b','c');
		RingDiscover ringDiscover = new RingDiscover();
		boolean result = ringDiscover.invoke(node);

		if (result){
			System.out.println("有环");
		}else{
			System.out.println("没有环");
		}


		// 构建一个有环的链表
		Node node1 = new Node('a');
		Node node2 = new Node('b');
		Node node3 = new Node('c');
		Node node4 = new Node('d');

		node1.next= node2;
		node2.next= node3;
		node3.next= node4;
		node4.next= node1;

		boolean resultRing = ringDiscover.invoke(node1);

		if (resultRing){
			System.out.println("有环");
		}else{
			System.out.println("没有环");
		}
	}

	/**
	 * 环检测
	 */
	private boolean invoke(Node node) {
		Node quick = node;
		Node slow = node;
		while (quick != null && quick.next != null) {
			quick = quick.next.next;
			slow = slow.next;

			if (quick == slow) return true;
		}

		return false;
	}
}
