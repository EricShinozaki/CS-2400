package EricShinozaki_p1;
public interface SetInterface<T> {
	
	/* Counts items in Set
	 * @return number of items in Set
	 */
	public int getCurrentSize();
	
	/* Checks if the set is Empty
	 * @return true if set is Empty, otherwise false
	 */
	public boolean isEmpty();
	
	/* Adds a new Entry to the Set
	 * @parameter newEntry - object to add to Set
	 * @return true if newEntry successfully added, otherwise false
	 */
	public boolean add(T newEntry);
	
	/* Removes any Entry from the Set
	 * @return value T removed from Set
	 */
	public T remove();
	
	/* Removes a specific Entry from the Set
	 * @parameter anEntry - the Entry user wants to remove
	 * @return true if anEntry was successfully removed, otherwise false
	 */
	public boolean remove(T anEntry);
	
	/* Removes all Entries from this set
	 * @return nothing
	 */
	public void clear();
	
	/* Checks for a specific value
	 * @parameter anEntry - The value user is checking for
	 * @return true if anEntry is found, otherwise false
	 */
	public boolean contains(T anEntry);
	
	/* Get all values from the set
	 * @return T[] holding all of the values from the set
	 */
	public T[] toArray();
	
	/* Get all unique values in this Set and otherSet 
	 * @parameter otherSet - the other set the operation is performed on
	 * @return SetInterface<T> containing all of the unique values
	 */
	public SetInterface<T> union(SetInterface<T> otherSet);
	
	/* Get all values present in both this set and otherSet
	 * @parameter otherSet - the other set the operation is performed on
	 * @return SetInterface<T> containing all values found in both sets
	 */
	public SetInterface<T> intersection(SetInterface<T> otherSet);
	
	/* Get all values found in this set, that are not found in otherSet: this set - otherSet
	 * @parameter otherSet - the set subtracted from this set
	 * @return SetInterface<T> containing values from this set - otherSet
	 */
	public SetInterface<T> difference(SetInterface<T> otherSet);
}
