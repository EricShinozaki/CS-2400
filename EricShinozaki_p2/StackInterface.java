package EricShinozaki_p2;

public interface StackInterface<T> {
	//Adds a new entry, @param newEntry, to the top of stack
	public void push(T newEntry);
	
	//Removes the entry at the top of the stack and returns it
	//@return the object at top of stack
	//@throws EmptyStackException if the stack is empty
	public T pop();
	
	//Retrieves entry at top of stack
	//@return object at top of stack
	//@throws EmptyStackException if the stack is empty
	public T peek();
	
	//Checks if stack is empty
	//@return true if empty, false if not
	public boolean isEmpty();
	
	//Removes all entries from stack
	public void clear();
}
