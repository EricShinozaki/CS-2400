package EricShinozaki_p2;
import java.util.*;

public class LinkedStack<T> implements StackInterface<T> {
	
	private Node topNode;

	public LinkedStack() {
		topNode = null;
	}

	public void push(T newEntry) {
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
	}
	
	public T pop() {
		T top = peek();
		if(top != null) {
			topNode = topNode.getNext();
		}
		return top;
	}
	
	public T peek() {
		T top;
		if(isEmpty()) {
			throw new EmptyStackException();
		} else {
			top = topNode.getVal();
		}
		return top;
	}
	
	public boolean isEmpty() {
		return topNode == null;
	}
	
	public void clear() {
		topNode = null;
	}
	
	public class Node {
		T value;
		Node next;
		
		public Node() {
			//default
		}
		
		public Node(T val, Node topNode) {
			next = topNode;
			value = val;
		}
		
		public Node getNext() {
			return this.next;
		}
		
		public T getVal(){
			return this.value;
		}
		
		public void setNext(Node next){
			this.next = next;
		}
		
		public void setVal(T value) {
			this.value = value;
		}
	}
}
