package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LL {

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	Node head = null;
	Node tail = null;
	int size = 0;

	public void add(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	public void add(int data, int index) {
		if (index < 0 || index > (size - 1)) {
			System.out.println("Index out of bound");
			return;
		}
		Node newNode = new Node(data);
		int i = 0;
		Node curr = head;
		Node prev = null;
		while (curr != null && i != index) {
			prev = curr;
			curr = curr.next;
			i++;
		}
		if (prev == null) {
			newNode.next = head;
			head = newNode;
		} else {
			prev.next = newNode;
			newNode.next = curr;
		}
		size++;
		System.out.println(this);
	}

	public void remove(int index) {
		if (index < 0 || index > (size - 1)) {
			System.out.println("Index out of bound");
			return;
		}
		int i = 0;
		Node curr = head;
		Node prev = null;
		while (curr != null && i != index) {
			prev = curr;
			curr = curr.next;
			i++;
		}
		if (prev == null) {
			head = head.next;
		} else {
			prev.next = curr.next;
		}

		if (curr == tail) {
			tail = prev;
		}
		curr.next = null;
		size--;
		System.out.println(this);

	}

	public void removeObject(int data) {
		Node curr = head;
		Node prev = null;
		while (curr != null && curr.data != data) {
			prev = curr;
			curr = curr.next;
		}
		if (curr == null) {
			System.out.println("Data not found");
			return;
		}
		if (prev == null) {
			head = head.next;
		} else {
			prev.next = curr.next;
		}
		if (curr == tail) {
			tail = prev;
		}
		curr.next = null;
		size--;
		System.out.println(this);

	}

	public int indexOf(int data) {
		Node curr = head;
		int i = 0, index = -1;
		while (curr != null) {
			if (curr.data == data) {
				index = i;
				break;
			}
			curr = curr.next;
			i++;
		}
		return index;
	}

	public int lastIndexOf(int data) {
		Node curr = head;
		int i = 0, index = -1;
		while (curr != null) {
			if (curr.data == data) {
				index = i;
			}
			curr = curr.next;
			i++;
		}
		return index;
	}

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
//		buf.append("[");
		Node curr = head;
		while (curr != null) {
			buf.append(curr.data).append("->");
			curr = curr.next;
		}
		if (buf.length() > 0) {
			buf.deleteCharAt(buf.length() - 1);
			buf.deleteCharAt(buf.length() - 1);
		}
//		buf.append("]");
		return buf.toString();
	}
	
	//Approach 1
//	public void reverse() {
//		List<Node> list = new ArrayList<>();
//		Node curr = this.head;
//		while(curr != null) {
//			list.add(curr);
//			curr = curr.next;
//		}
//		int size = list.size();
//		for(int i=size-1;i>0;i--) {
//			list.get(i).next = list.get(i-1);
//			list.get(i-1).next = null;
//		}
//		this.head = list.get(size-1);
//	}
	
	public void reverse() {
		Node prev = null;
		Node next = null;
		Node curr = this.head;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		this.head = prev;
	}

	public static void main(String[] args) {
		LL ls = new LL();
		ls.add(1);
		ls.add(2);
		ls.add(3);
		ls.add(4);
		System.out.println(ls);
		ls.reverse();
		System.out.println(ls);

	}
}
