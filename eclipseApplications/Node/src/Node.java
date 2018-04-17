
public class Node {
	public String bookName;
	public int millionsSold;
	
	public Node next;
	
	public Node(String bookName, int millionsSold) {
		this.bookName = bookName;
		this.millionsSold = millionsSold;
	}
	
	public void display() { 
		
		System.out.println(bookName + ": " + millionsSold + ",000,000");
		
	}
	
	public String toString() {
		return bookName; 
	}
	
	
	public static void main(String[] args) {
		
		
		
		
		
	}
	
	
}

class LinkList {
	public Node firstLink;
	
	LinkList() {
		firstLink = null;
	}
	public boolean isEmpty() {
		return(firstLink == null);
	}
	
	public void insertFirstLink(String bookName, int millionsSold) {
		
		Node newLink = new Node(bookName, millionsSold);
		
		newLink.next = firstLink;
		firstLink = newLink; 
	}
	
	
	
		
	}
	
	
	
	
	
	
	
