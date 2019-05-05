package _06_linkedlist;

/**
 * Function:
 * <p>
 * 判断字符串是否是回文 时间复杂度O(n)
 *
 * @author huanlian77
 * Date: 29/04/2019 14:30
 * @since JDK 1.8
 */
public class PalindromeLinkedList {


	/**
	 * 单链表定义
	 */
	class LinkNode {
		char val;
		LinkNode next;

		LinkNode(char x) {
			val = x;
		}
	}


	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
		LinkNode node1 = palindromeLinkedList.new LinkNode('1');
		LinkNode node2 = palindromeLinkedList.new LinkNode('2');
		LinkNode node3 = palindromeLinkedList.new LinkNode('3');
		LinkNode node4 = palindromeLinkedList.new LinkNode('3');
		LinkNode node5 = palindromeLinkedList.new LinkNode('2');
		LinkNode node6 = palindromeLinkedList.new LinkNode('1');

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		if (palindromeLinkedList.isPalindrome(node1)) {
			System.out.println("是回文！");
		} else {
			System.out.println("不是回文！");
		}


	}

	/**
	 * 回文判断
	 */
	private boolean isPalindrome(LinkNode node) {

		// 边界判断
		if (node == null || node.next == null) {
			return false;
		}

		// 使用快慢指针，并反转慢指针
		LinkNode quick = node;
		LinkNode slow = node;
		LinkNode reverse = null;
		while (quick != null && quick.next != null) {
			quick = quick.next.next;
			LinkNode temp = slow.next;
			slow.next = reverse;
			reverse = slow;
			slow = temp;
		}

		// 当回文是奇数时，此时快指针指向最后一个字符，慢指针指向中间字符，
		// 要让慢指针指向下一个字符
		if (quick != null) {
			slow = slow.next;
		}

		while (slow != null && reverse != null) {
			if (slow.val != reverse.val) {
				return false;
			}
			slow = slow.next;
			reverse = reverse.next;
		}
		return true;
	}
}
