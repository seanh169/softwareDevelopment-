import java.util.LinkedList;
import java.util.Scanner;
//Queue data structure implementation with Linked List
//FIFO - Think of waiting in line for ice cream. First person in line is first to get served.
public class Queue {
	LinkedList queue;
	
	public Queue() {
		queue = new LinkedList();
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	public int size() {
		return queue.size();
	}
	
	public void enqueue(int n) {
		queue.addLast(n);
	}
	
	public int dequeue() {
		return (int) queue.remove(0);
	}
	
	public int peek() {
		return (int) queue.get(0);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arguments = in.nextInt();
		
//		for(int i = 0 ; i  <)
		
		
		//		Stack<String> stacky = new Stack<>();
//		//["There"] 
//		stacky.push("There");
//		//["There", "Hi"]
//		stacky.push("Hi");
//		System.out.println(stacky.size());
//		System.out.println(stacky.peek());
//		System.out.print(stacky.pop() + " ");
//		System.out.println(stacky.pop() + "! ");
//		System.out.println(stacky.size());
		
				Queue numberQueue = new Queue();
		numberQueue.enqueue(5);
		numberQueue.enqueue(7);
		numberQueue.enqueue(6);
//		numberQueue.
		System.out.println(numberQueue.peek());
		System.out.println("First out: "+ numberQueue.dequeue());
		System.out.println("Second out: "+ numberQueue.dequeue());
		System.out.println("Third out: "+ numberQueue.dequeue());
		
		
		
		
		
	}
}
