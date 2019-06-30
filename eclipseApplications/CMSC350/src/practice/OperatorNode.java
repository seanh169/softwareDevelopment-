package practice;

public class OperatorNode extends Node {

	private Node prev;
	private Node next;
	
	
	public OperatorNode(String data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	
	public OperatorNode(String data, Node prev, Node next) {
		super(data);
		this.setPrev(prev);
		this.setNext(next);
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
	
}
