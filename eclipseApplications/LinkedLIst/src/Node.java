public class Node {
	int data;
	Node next;
	
	
	public Node (int data) {
		this.data = data;
	}
	
	public class LinkedList {
		Node head;

	
	
	public void append (int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}
		Node runner = head;
		while(runner.next != null) {
			runner = runner.next;
		}
		runner.next = new Node(data);
		
	}
	
	public void prepend(int data) {
		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;
	}
	
	public void deleteWithValue(int data) {
		if (head == null) return;
		if(head.data == data) {
			head = head.next;
			return;
		}
		Node runner = head;
		while (runner.next != null ) {
			if (runner.next.data == data) {
				runner.next = runner.next.next;
				return;
			}
			runner = runner.next;
		}
	}
	
	
	
	
	
	
	}
}