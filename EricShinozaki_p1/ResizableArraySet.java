package EricShinozaki_p1;

public class ResizableArraySet<T> implements SetInterface<T> {
	
	private int numOfEntries; //current number of entries
	private T[] Set; //Holds our Set
	private int len; //Size of Array - Double when Set is full
	
	//Constructor 
	public ResizableArraySet(){
		numOfEntries = 0;
		len = 1;
		@SuppressWarnings("unchecked")
		T[] tempSet = (T[]) new Object[len];
		Set = tempSet;
	}
	
	public ResizableArraySet(T[] Set, int numOfEntries) {
		this.Set = Set;
		this.numOfEntries = numOfEntries;
		len = this.numOfEntries;
	}
	
	//Required Method #1 
	public int getCurrentSize() {
		return numOfEntries;
	}

	//Required Method #2 
	public boolean isEmpty(){
		if(numOfEntries == 0) {
			return true;
		}
		return false;
	}
	
	//Required Method #3 
	public boolean add(T newEntry){
		if(this.findIndexOf(newEntry) == -1) {
			this.checkCapacity(); //Check that the Set can hold another value, if not, doubles the size of the Set
			Set[numOfEntries] = newEntry;
			numOfEntries++;
			return true;
		}
		return false;
	}
	
	//Required Method #4
	//Does not set last value to null but decrements the list
	public T remove(){
		return removeEntry(numOfEntries - 1);
	} 
	
	
	//Required Method #5
	public boolean remove(T anEntry){
		int index = this.findIndexOf(anEntry); //findIndexOf returns the index where parameter anEntry is found 
		T valueAtIndex = this.removeEntry(index); //removes the value at index from the Set and returns the removed T value if found, otherwise returns -1
		if(valueAtIndex != null) {
			if(valueAtIndex.equals(anEntry)) { //Checks that the removed value is the same as the parameter anEntry, returns true if they are the same, otherwise return false
				return true; 
			}
		}
		return false;
	}

	//Required Method #6
	public void clear() {
		numOfEntries = 0; //Does not set values to null but changes number of Entries 0
	}
	
	//Required Method #7
	public boolean contains(T anEntry){
		int found = findIndexOf(anEntry); //Gets the index of anEntry if found otherwise returns -1
		if(found != -1) { //If findIndexOf returns -1, then return false as value was not found, otherwise return true
			return true;
		}
		return false;
	}

	//Required Method #8
	public T[] toArray(){
		@SuppressWarnings("unchecked")
		T[] tempSet = (T[]) new Object[numOfEntries]; //Create New Array for output
		for(int i = 0; i < this.numOfEntries; i++) {
			tempSet[i] = Set[i]; //Add all values of Set to Array
		}
		return tempSet;
	}

	//Required Method #9
	public SetInterface<T> union(SetInterface<T> otherSet){
		SetInterface<T> unionSet = new ResizableArraySet<T>(this.toArray(), this.numOfEntries); //Create a new SetInterface<T> with Set initialized to this.Set
		T[] setTwo = otherSet.toArray(); //Get Array of other Set
		for(int i = 0; i < setTwo.length; i++) {
			unionSet.add(setTwo[i]); //Add items to unionSet, add already checks for repeating value
		}
		return unionSet;
	}
	
	
	//Required Method #10
	public SetInterface<T> intersection(SetInterface<T> otherSet){
		SetInterface<T> intersectionSet = new ResizableArraySet<T>();
		for(int i = 0; i < numOfEntries; i++){
			if(otherSet.contains(this.Set[i])) { //Loop through this Set and check if otherSet contains Set[i], if it does add Set[i] to intersectionSet
				intersectionSet.add(this.Set[i]);
			}
		}
		return intersectionSet;
	}
	

	//Required Method #11
	public SetInterface<T> difference(SetInterface<T> otherSet){
		SetInterface<T> differenceSet = new ResizableArraySet<T>(this.toArray(), this.numOfEntries); //Make a new SetInterface with Set initialized to this Set
		T[] setTwo = otherSet.toArray();
		for(int i = 0; i < setTwo.length; i++) { //Remove values in otherSet from difference Set
			differenceSet.remove(setTwo[i]);
		}
		return differenceSet;
		
	}
	
	public void checkCapacity(){
		if(numOfEntries == Set.length){ //double the size of the array if numOfEntries equals current length of the array
			len *= 2;
			this.increaseSize();
		}
	}
	
	public void increaseSize() {
		@SuppressWarnings("unchecked")
		T[] tempSet = (T[]) new Object[len]; //Create a new array with doubled size
		for(int i = 0; i < Set.length; i++) { //Add values into new array
			tempSet[i] = this.Set[i];
		}
		Set = tempSet; 
	}
	
	public int findIndexOf(T entry) {
		for(int i = 0; i < numOfEntries; i++) { //Loop through this Set until you find a value equal to entry, otherwise return -1
			if(Set[i].equals(entry)) {
				return i;
			}
		}
		return -1;
	}
	
	public T removeEntry(int index) {
		T result = null; 
		if(!isEmpty() && (index >= 0)) { //if the set isn't empty and the index is valid
			result = Set[index]; 
			Set[index] = Set[numOfEntries - 1]; //Set the value at index to the last entry then decrement number of entries, effectively deleting the value previously at index
			numOfEntries--;
		}
		return result;
	}
}
