package practice;

abstract class Node {
	
	private String data;
	private Node prev;
	private Node next;
	
	public Node(String data) {
		this.data = data;
	}
	
	public Node(String data, Node prev, Node next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
