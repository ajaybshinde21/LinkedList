class Node {
	private int data;
	private Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	public void setNext(Node n) {
		this.next = n;
	}

	public Node getNext() {
		return this.next;
	}

	public int getData() {
		// TODO Auto-generated method stub
		return this.data;
	}
}

public class LinkedList {
	Node head, tail;

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Node n1 = new Node(11);
		Node n2 = new Node(10);
		list.insertBeginning(n1);
		list.insertBeginning(n2);
//		list.insertEnd(13);
//		list.insertAfter(n1,123);
		Node n3 = new Node(123);
		list.insertAfter(n1, n3);
		list.traverse();
		System.out.println(list.tail);
		// insert after end node
		Node n4 = new Node(900);
		list.insertAfter(n3, n4);
		System.out.println(n4);
		System.out.println(list.tail);
		// current list = n2 > n1> n3 > n4
		list.traverse();
		System.out.println("===============");
		list.insertBefore(n2, 50);
		list.traverse();
		list.deleteBeginning();
		list.delete(n2);
		list.traverse();
		list.delEnd();
		list.traverse();

		LinkedList list2 = new LinkedList();
		list2.insertBeginning(12);
		Node tmp = list2.getNodeByValue(12);
		list2.insertAfter(tmp, 14);
		list2.insertAfter(tmp, 13);
		tmp = list2.getNodeByValue(14);
		list2.traverse();
		System.out.println("=============");
		list2.delAfter(tmp);
		tmp = list2.getNodeByValue(14);
		list2.delBefore(tmp);
		list2.traverse();

	}

	private Node getNodeByValue(int i) {
		Node tmp = head;
		while (tmp != null) {

			if (tmp.getData() == i) {
				return tmp;
			}
			tmp = tmp.getNext();
		}
		return null;
	}

	private void traverse() {
		Node tmp = head;
		while (tmp != null) {
			System.out.println(tmp.getData());
			tmp = tmp.getNext();
		}
	}

	public LinkedList() {
		head = tail = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void insertAfter(Node n, int data) {
		if (!isEmpty() && contains(n)) {
			Node newNode = new Node(data);
			insertAfter(n, newNode, true); // to skip recheking list isEmpty and contains(n) overloaded with true
		}
	}

	public void insertAfter(Node n, Node n2) {
		if (!isEmpty() && contains(n)) {
			insertAfter(n, n2, true);
		}
	}

	private void insertAfter(Node n, Node n2, boolean b) {
		n2.setNext(n.getNext());
		n.setNext(n2);
		if (n.equals(tail)) {
			tail = n2;
		}

	}

	public void insertBefore(Node n, int data) {
		if (!isEmpty() && contains(n)) {

			Node tmp = head;
			Node newNode = new Node(data);
			if (n.equals(tmp)) {
				newNode.setNext(n);
				head = newNode;
			}
			Node previousNodeOfN = getPreviousNode(n);
			if (previousNodeOfN.equals(null)) {
				System.out.println("doesn't exist");
			} else {
				previousNodeOfN.setNext(newNode);
				newNode.setNext(tmp);
			}

		}
	}

	private Node getPreviousNode(Node n) {
		Node tmp = head;
		Node previousNodeOfN = null;
		while (!tmp.equals(n)) {
			previousNodeOfN = tmp;
			tmp = tmp.getNext();
		}
		return previousNodeOfN;
	}

	private boolean contains(Node n) {
		Node tmp = head;
		while (tmp != null) {
			if (tmp.equals(n)) {
				return true;
			}
			tmp = tmp.getNext();
		}
		return false;
	}

	public void insertBeginning(int data) {
		Node n = new Node(data);
		insertBeginning(n);
	}

	public void insertBeginning(Node n) {
		n.setNext(head);
		head = n;
		if (tail == null) {
			tail = head;
		}
	}

	public void insertEnd(int data) {
		Node n = new Node(data);
		n.setNext(tail.getNext());
		tail.setNext(n);
		tail = n;
		// if list is empty
//		if(this.isEmpty()) {
//			head = tail =  n;	
//		}else {
//			Node tmp = tail;
//			tmp.setNext(n);
//			tail = n;
//		}
	}

	public void deleteBeginning() {
		// Exercise
		head = head.getNext();
	}

	public void delete(Node n) {// Exercise
		if (n.equals(head)) {
			head = n.getNext();
			return;
		}
		Node tmp = getPreviousNode(n);
		if (tmp != null) {
			tmp.setNext(n.getNext());
		} else {
			System.out.println("Node does't exist");
		}
	}

	public void delEnd() {// special case of delete, Exercise
		Node previousNode = getPreviousNode(tail);
		previousNode.setNext(null);
		tail = previousNode;

	}

	public void delAfter(Node n) {// Exercise

		if (n.equals(tail)) {
			System.out.println("tail reached");
			return;
		} else if (n.equals(head)) {
			head = n.getNext();
			return;
		} else {
			Node previousNode = getPreviousNode(n);
			previousNode = n.getNext();
		}

	}

	public void delBefore(Node n) {// Exercise
		Node previousNode = getPreviousNode(n);
		if (n.equals(head)) {
			System.out.println("head reached");
		} else if (n.equals(tail)) {
			previousNode.setNext(null);
			tail = previousNode;
		} else {
			previousNode.setNext(n.getNext());
		}

	}

}
