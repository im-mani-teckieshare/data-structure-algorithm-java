package dll;

public class DLL {

	class Node {
		int data;
		Node next;
		Node prev;

		public Node(int data) {
			this.data = data;
		}
	}

	Node head;
	Node tail;

	int size = 0;

	public void add(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
	}

	public void add(int data, int index) {
		if (index < 0 || index > (size - 1)) {
			System.out.println("Index out of Bound");
			return;
		}
		Node newNode = new Node(data);
		Node curr = findNode(index);

		Node prevNode = curr.prev;
		if (curr == head) {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		} else {
			prevNode.next = newNode;
			newNode.prev = prevNode;
			newNode.next = curr;
			curr.prev = newNode;
		}
		size++;

	}

	public void set(int data, int index) {
		if (index < 0 || index > (size - 1)) {
			System.out.println("Index out of Bound");
			return;
		}
		Node curr = findNode(index);
		curr.data = data;
	}

	public void remove(int index) {
		if (index < 0 || index > (size - 1)) {
			System.out.println("Index out of Bound");
			return;
		}
		Node curr = findNode(index);

		Node prevNode = curr.prev;
		Node nextNode = curr.next;

		if (curr == head) {
			head = head.next;
			if (head != null) {
				head.prev = null;
			} else {
				head = tail = null;
			}
		} else if (curr == tail) {
			prevNode.next = null;
			tail = prevNode;
		} else {
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
		}
		curr.next = curr.prev = null;

		size--;
	}

	public void removeObj(int data) {
		Node curr = head;
		while (curr != null && curr.data != data) {
			curr = curr.next;
		}
		if (curr == null) {
			System.out.println("Target Data Not found");
			return;
		}

		Node prevNode = curr.prev;
		Node nextNode = curr.next;

		if (curr == head) {
			head = head.next;
			head.prev = null;
		} else if (curr == tail) {
			prevNode.next = null;
			tail = prevNode;
		} else {
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
		}
		curr.next = curr.prev = null;

		size--;
	}

	public int indexOf(int data) {
		int i = 0;
		Node curr = head;
		while (curr != null && curr.data != data) {
			curr = curr.next;
			i++;
		}
		if (curr == null) {
			i = -1;// data not found
		}
		return i;
	}

	public int lastIndexOf(int data) {
		int i = size - 1;
		Node curr = tail;
		while (curr != null && curr.data != data) {
			curr = curr.prev;
			i--;
		}
		if (curr == null) {
			i = -1;// data not found
		}
		return i;
	}

	public boolean contains(int data) {
		return indexOf(data) != -1;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		head = tail = null;
		size = 0;
	}

	public int get(int index) {
		if (index < 0 || index > (size - 1)) {
			System.out.println("Index out of Bound");
			return Integer.MIN_VALUE;
		}
		Node target = findNode(index);

		return target.data;
	}

	private Node findNode(int index) {
		int mid = (size - 1) / 2;
		if (mid > index) {
			return findForward(index);
		}
		return findReverse(index);

	}

	public void reverse() {
		Node prev = null;
		Node curr = head;
		Node next = null;
		while (curr != null) {
			prev = curr.prev;
			next = curr.next;
			curr.prev = next;
			curr.next = prev;
			curr = next;
		}
		if (prev != null) {
			this.head = prev.prev;
		}
	}

	private Node findForward(int index) {
		int i = 0;
		Node curr = head;
		while (curr != null && i != index) {
			curr = curr.next;
			i++;
		}
		return curr;
	}

	private Node findReverse(int index) {
		int i = size - 1;
		Node curr = tail;
		while (curr != null && i != index) {
			curr = curr.prev;
			i--;
		}
		return curr;
	}

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		Node curr = head;
		buf.append("[");
		while (curr != null) {
			buf.append(curr.data).append(",");
			curr = curr.next;
		}
		if (buf.length() > 1) {
			buf.deleteCharAt(buf.length() - 1);
		}
		buf.append("]");
		return buf.toString();
	}

	public static void main(String[] args) {
		DLL ls = new DLL();
		ls.add(40);
		ls.add(30);
//		ls.add(10);
//		ls.add(20);
		System.out.println(ls);
		ls.reverse();
		System.out.println(ls);
		System.out.println("Index of 10 will be " + ls.indexOf(10));
		System.out.println("Last Index of 10 will be " + ls.lastIndexOf(10));
		System.out.println("Is 20 contains in the List " + ls.contains(20));
		System.out.println("Size of the List will be " + ls.size());
		// ls.clear();
		// System.out.println("After clear the List: Size of the List will be
		// "+ls.size());
		// System.out.println(ls);
		// System.out.println("Is List Empty : "+ ls.isEmpty());
		ls.set(50, 3);
		System.out.println(ls);

	}

}
