package EricShinozaki_p1;

public class LinkedSet<T> implements SetInterface<T> {
	
	private int numOfEntries;
	private Node firstNode;
	
	public LinkedSet() {
		numOfEntries = 0;
	}

	//Required Method #1
	public int getCurrentSize() {
		return numOfEntries;
	}
	
	//Required Method #2
	public boolean isEmpty(){
		if(numOfEntries == 0) { //If number of Entries = 0, return true, otherwise false
			return true;
		}
		return false;
	}
	
	//Required Method #3
	public boolean add(T newEntry){
		boolean added = false;
		Node reference = getReferenceToNode(newEntry); //Get reference to node that contains newEntry if it exists, otherwise returns null value
		if(reference == null) { //if reference is null, then newEntry isn't in the Set so we can add it;
			Node newNode = new Node(newEntry); //Make new node with initialized value newEntry
			newNode.setNext(firstNode); //Set newNode next to be the first node
			firstNode = newNode; //Make newNode the first node 
			numOfEntries++; //increment number of entries
			added = true; 
		}
		return added;
	}	
	
	//Required Method #4
	public T remove(){
		T result = null; //Value that will be returned
		if(firstNode != null) {
			result = firstNode.getVal(); //Set return variable to be the value of the node being removed
			firstNode = firstNode.getNext(); //Set firstNode to be the next node in the list, dereferencing the first node in the list
			numOfEntries--; //A node was successfully removed so decrement number of entries
		}
		return result; //return value of the removed node
	}
	
	//Required Method #5
	public boolean remove(T anEntry){
		boolean result = false; 
		Node found = getReferenceToNode(anEntry); //Get a reference to the node we want to remove if it exists, otherwise returns a null value
		if(found != null) { //if reference isn't null, then we can remove node with value anEntry
			found.setVal(firstNode.getVal());	//Set the value of the reference to the value of the first node
			firstNode = firstNode.getNext();	//Set firstNode to the next node in the list, dereferencing the first node
			numOfEntries--;	//A node was removed so decrement number of entries
			result = true; 
		}
		return result;
	}
	
	//Required Method #6
	public void clear(){
		while(!isEmpty()){
			remove();
		}
	}
	
	//Required Method #7
	public boolean contains(T anEntry){
		Node reference = getReferenceToNode(anEntry); //Get a reference to the node with value anEntry or a null reference if it does not exist
		boolean contained = false; //variable to be returned initialized to false until we check 
		if(reference != null){ //Check if reference is null, if it is not, set contained to true
			contained = true;
		}
		return contained;
	}
	
	//Required Method #8
	public T[] toArray(){
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numOfEntries]; //Create new array for output
		int index = 0; //Tracks where to put next value into array
		Node currentNode = firstNode; 
		while((index < numOfEntries) && (currentNode != null)){ //Check that index doesn't exceed the number of entries and that current node is not null
			result[index] = currentNode.getVal(); //Update array
			index++; //
			currentNode = currentNode.getNext(); //get next node
		}
		return result;
	}
	
	//Required Method #9
	public SetInterface<T> union(SetInterface<T> otherSet){
		SetInterface<T> unionSet = new ResizableArraySet<T>();
		T[] currentSet = this.toArray(); //Get array of this set
		
		for(int i = 0; i < currentSet.length; i++) {
			unionSet.add(currentSet[i]); //add all of the values in this set to unionSet
		}
		
		currentSet = otherSet.toArray(); //Get array of other set
		
		for(int i = 0; i < currentSet.length; i++){
			unionSet.add(currentSet[i]); //add all of the values in other set to unionSet
		}
		return unionSet;
	}
	
	//Required Method #10
	public SetInterface<T> intersection(SetInterface<T> otherSet){
		SetInterface<T> intersectionSet = new ResizableArraySet<T>();
		T[] setOne = this.toArray(); //Get array of this set
		
		for(int i = 0; i < setOne.length; i++) {
			if(otherSet.contains(setOne[i])) { //Loop through set and check if otherSet contain this Set[i], add to intersection set if equal
				intersectionSet.add(setOne[i]);
			}
		}
		return intersectionSet;
	}
	
	//Required Method #11
	public SetInterface<T> difference(SetInterface<T> otherSet){
		SetInterface<T> differenceSet = new ResizableArraySet<T>();
		T[] currentSet = this.toArray(); //Get array of this set
		
		for(int i = 0; i < currentSet.length; i++) {
			differenceSet.add(currentSet[i]); //Add all of the values in this set to differenceSet
		}
		
		currentSet = otherSet.toArray(); //Get array of otherSet
		
		for(int i = 0; i < currentSet.length; i++){
			differenceSet.remove(currentSet[i]); //Try to remove all values in otherSet from differenceSet
		}
		return differenceSet;
	}
	
	public class Node {
		T value;
		Node next;
		
		public Node() {
			//default
		}
		
		public Node(T val) {
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
	
	public Node getReferenceToNode(T entry) { 
		boolean found = false;
		Node currentNode = firstNode;
		while(!found && (currentNode != null)){ //while node hasn't been found and node isn't false
			if(entry.equals(currentNode.getVal())){ //if node with value entry is found
				found = true; 
			} else {
				currentNode = currentNode.getNext(); //get next node 
			}
		}
		return currentNode;
	}
}
