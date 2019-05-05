package _06_linkedlist;

import java.util.Scanner;

/**
 * Function:
 * <p>
 * 使用单链表实现LRU
 *
 * @author huanlian77
 * Date: 29/04/2019 11:09
 * @since JDK 1.8
 */
public class LRUBaseLinkedList<T> {

	/**
	 * 头节点
	 */
	private Node<T> headNode;
	/**
	 * 默认链表容量
	 */
	private final static Integer DEFAULT_CAPACITY = 10;
	/**
	 * 链表长度
	 */
	private Integer length;

	/**
	 * 链表容量
	 */
	private Integer capacity;


	public LRUBaseLinkedList() {
		this.headNode = new Node<>();
		this.length = 0;
		this.capacity = DEFAULT_CAPACITY;
	}

	/**
	 * 单链表
	 */
	class Node<T> {
		private T value;
		private Node next;

		public Node() {
		}

		public Node(T value, Node next) {
			this.value = value;
			this.next = next;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}


	/**
	 * 加入数据
	 */
	private void add(T data) {
		// 获取要查询数据的前驱节点
		Node preNode = findPreData(data);
		// 查询到数据
		if (preNode != null) {
			// 删除该数据,并插入到头部
			deleteAtOffset(preNode);
		} else {
			// 没有查到该数据，判断链表是否已满，已满要删除末尾节点
			if (length >= this.capacity) {
				// 删除末尾节点
				deleteEnd();
			}
		}

		// 都是插入头部
		insertAtFirst(data);
	}

	/**
	 * 删除末尾节点
	 */
	private void deleteEnd() {
		Node node = headNode;
		if (node.getNext() == null) {
			return;
		}

		// 找到倒数第二个节点
		while (node.getNext().getNext() != null) {
			node = node.getNext();
		}
		Node temp = node.getNext();
		node.setNext(null);
		temp = null;
		length--;
	}

	/**
	 * 删除数据
	 */
	private void deleteAtOffset(Node preNode) {
		// 要被删除的数据
		Node temp = preNode.getNext();
		// 删除数据
		preNode.setNext(preNode.getNext().getNext());

		// 删除数据置为null，帮助垃圾回收
		temp = null;

		length--;
	}

	/**
	 * 查找数据的前一个节点
	 *
	 * @param data
	 * @return
	 */
	private Node findPreData(T data) {
		Node node = headNode;
		while (node.getNext() != null) {
			if (data.equals(node.getNext().getValue())) {
				// 找到数据，返回前驱节点
				return node;
			}
			node = node.getNext();
		}

		return null;
	}

	/**
	 * 插入头部
	 *
	 * @param data
	 */
	private void insertAtFirst(T data) {
		Node next = headNode.getNext();
		headNode.setNext(new Node<>(data, next));
		length++;
	}


	/**
	 * 打印数据
	 */
	private void printAll() {
		Node node = headNode.getNext();
		while (node != null) {
			System.out.print(node.value + ",");
			node = node.getNext();
		}

		System.out.println(" ");

	}


	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		LRUBaseLinkedList<Integer> lruBaseLinkedList = new LRUBaseLinkedList<>();
		// 单链表中放入数据
		Scanner sc = new Scanner(System.in);
		while (true) {
			lruBaseLinkedList.add(sc.nextInt());
			lruBaseLinkedList.printAll();
		}

	}


}
