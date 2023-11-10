package EricShinozaki_p2;
import java.util.*;

public class ResizableArrayStack<T> implements StackInterface<T> {
	
	private T[] stack;
	private int topIndex; 
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	public ResizableArrayStack() {
		this(DEFAULT_CAPACITY);
	}
	
	public ResizableArrayStack(int initialCapacity) {
		@SuppressWarnings("unchecked")
		T[] tempSet = (T[]) new Object[initialCapacity];
		stack = tempSet;
		topIndex = -1;
	}
	
	public void push(T newEntry) {
		checkCapacity();
		stack[topIndex + 1] = newEntry;
		topIndex++;
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		} else {
			T top = stack[topIndex];
			stack[topIndex] = null; 
			topIndex--;
			return top;
		}
	}
	
	public T peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		} else {
			return stack[topIndex];
		}
	}
	
	public boolean isEmpty() {
		return topIndex < 0; //topIndex = -1 when empty
	}
	
	public void clear() {
		while(topIndex > -1) {
			stack[topIndex] = null;
			topIndex--;
		}
	}
	
	private void checkCapacity() {
		if(topIndex >= stack.length - 1) { //double the size of the array if capacity has been reached
			int newLength = 2 * stack.length;
			this.increaseSize(newLength);
		}
	}
	
	private void increaseSize(int newLength) {
		if(newLength > MAX_CAPACITY) {
			newLength = MAX_CAPACITY;
		}
		@SuppressWarnings("unchecked")			
		T[] tempSet = (T[]) new Object[newLength]; //Create new array with doubled size
		for(int i = 0; i < newLength; i++) { //Move stack to new array
			tempSet[i] = this.stack[i];
		}
		stack = tempSet;
	}

}
