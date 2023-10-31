package EricShinozaki_p1;
public class ArraySetTest {

	public static void main(String[] args) {
		SetInterface<Integer> testSet = new ResizableArraySet<Integer>();
		SetInterface<Integer> testSet2 = new ResizableArraySet<Integer>();
		System.out.println("This");
		
		//Method #1 (getCurrentSize) & 2 (isEmpty)
		System.out.println("Size of Array 1 & 2");
		System.out.println(testSet.getCurrentSize());
		System.out.println(testSet2.getCurrentSize());
		System.out.println("is Empty:");
		System.out.println(testSet.isEmpty());
		System.out.println(testSet2.isEmpty() + "\n");
		System.out.println("toArray 1: ");
		Object[] set1ToArray = testSet.toArray();
		Object[] set2ToArray = testSet2.toArray();
		for(int i = 0; i < set1ToArray.length; i++) {
			System.out.print(set1ToArray[i] + ", ");
		}
		System.out.println("toArray 2: ");
		for(int i = 0; i < set2ToArray.length; i++) {
			System.out.print(set2ToArray[i] + ", ");
		}
		
		System.out.print("\n");
		
		//Method #3 (add(T newEntry));
		System.out.println("add 0-9 to Set 1 - should all return true:");
		for(int i = 0; i < 10; i++){
			System.out.print(testSet.add(i) + ", ");
		}
		System.out.println("");
		System.out.println("\ntry to add 0-9 to set 1 again = should all return false");
		for(int i = 0; i < 10; i++) {
			System.out.print(testSet.add(i) + ", ");
		}
		System.out.println("\n");
		System.out.println("add 0-14 to set 2 - should all return true");
		for(int i = 0; i < 15; i++) {
			System.out.print(testSet2.add(i) +  ", ");
		}
		System.out.println("\n");
		
		//test to Array method
		
		System.out.println("toArray 1: ");
		set1ToArray = testSet.toArray();
		set2ToArray = testSet2.toArray();
		for(int i = 0; i < set1ToArray.length; i++) {
			System.out.print(set1ToArray[i] + ", ");
		}
		System.out.println("\n\ntoArray 2: ");
		for(int i = 0; i < set2ToArray.length; i++) {
			System.out.print(set2ToArray[i] + ", ");
		}
		System.out.println("\n");
		
		//Method #1 (getCurrentSize) & 2 (isEmpty) after adding values
		
		System.out.println("Size of Array 1 & 2");
		System.out.println(testSet.getCurrentSize());
		System.out.println(testSet2.getCurrentSize());
		System.out.println("\nis Empty:");
		System.out.println(testSet.isEmpty());
		System.out.println(testSet2.isEmpty() + "\n");
		
		//Method #4 - remove();
		
		System.out.println("call remove 5 times: ");
		for(int i = 0; i < 5; i++) {
			System.out.println(testSet.remove());
		}
		System.out.println("\n" + "call remove 5 times: ");
		for(int i = 0; i < 5; i++) {
			System.out.println(testSet2.remove());
		}
		
		//test Method #8  toArray after removing items
		
		System.out.println("\ntoArray 1: ");
		set1ToArray = testSet.toArray();
		set2ToArray = testSet2.toArray();
		for(int i = 0; i < set1ToArray.length; i++) {
			System.out.print(set1ToArray[i] + ", ");
			}
			System.out.println("\n\ntoArray 2: ");
		for(int i = 0; i < set2ToArray.length; i++) {
			System.out.print(set2ToArray[i] + ", ");
		}
				
		
		//Check Method #1 (getCurrentSize), #2 (isEmpty) after removing some values
		
		System.out.println("\n\n" + "Current Size: ");
		System.out.println(testSet.getCurrentSize());
		System.out.println(testSet2.getCurrentSize());
		System.out.println("\n" + "is Empty: ");
		System.out.println(testSet.isEmpty());
		System.out.println(testSet2.isEmpty());
		
		//Test Method #5 - remove specific item, one of which exists, one of which does not exist
		System.out.println("\ntest remove specific items \n");
		System.out.println("remove 5, should return true: " + testSet2.remove(5));
		System.out.println("remove 3, should return true: " + testSet2.remove(3));
		System.out.println("remove 20, should return false: " + testSet2.remove(20));
		
		
		System.out.println("\ntoArray on testSet2");
		set2ToArray = testSet2.toArray();
		for(int i = 0; i < set2ToArray.length; i++) {
			System.out.print(set2ToArray[i] + ", ");
		}
		System.out.println("\ngetCurrentSize: " + testSet2.getCurrentSize() + "\n");
		
		// Method #7 contains - 
		
		System.out.println("contains: 20 and 3?");
		System.out.println(testSet2.contains(20) + " should be false");
		System.out.println(testSet2.contains(4)+ " should be true");
		System.out.println("");
		
		//re-test methods after clearing set
		
		System.out.println("Clear the set");
		testSet2.clear();
		System.out.println("getCurrentSize: " + testSet2.getCurrentSize());
		System.out.println("isEmpty: " + testSet2.isEmpty());
		System.out.println("remove: " + testSet2.remove());
		System.out.println("remove 5: " + testSet2.remove(5));
		System.out.println("contains 5: " + testSet2.contains(5));
		set2ToArray = testSet2.toArray();
		System.out.println("print the array - should print nothing");
		for(int i = 0; i < set2ToArray.length; i++) {
			System.out.print(set2ToArray[i] + ", ");
		}
		
		//test union, intersection, and difference
		
		System.out.println("\nTest union, intersection, and difference");
		System.out.println("Set 1 contains 0-9");
		System.out.println("Set 2 contains 0-15");
		
		SetInterface<Integer> testSet3 = new ResizableArraySet<Integer>();
		SetInterface<Integer> testSet4 = new ResizableArraySet<Integer>();
		for(int i = 0; i < 10; i++) {
			testSet3.add(i);
		}
		for(int i = 0; i < 15; i++) {
			testSet4.add(i);
		}
		
		System.out.println("\nTest union");
		System.out.println("Print out all values in the union Set of set 1 and set 2 - Expect 0-14:");
		SetInterface<Integer> unionSet = new ResizableArraySet<Integer>();
		unionSet = testSet3.union(testSet4);
		Object[] unionToArray = unionSet.toArray();
		for(int i = 0; i < unionToArray.length; i++) {
			System.out.print(unionToArray[i] + ", ");
		}
		
		System.out.println("\n\nCheck that sets remain unchanged");
		System.out.println("toArray 1: ");
		Object[] set3ToArray = testSet3.toArray();
		Object[] set4ToArray = testSet4.toArray();
		for(int i = 0; i < set3ToArray.length; i++) {
			System.out.print(set3ToArray[i] + ", ");
		}
		System.out.println("\n\ntoArray 2: ");
		for(int i = 0; i < set4ToArray.length; i++) {
			System.out.print(set4ToArray[i] + ", ");
		}
		
		System.out.println("\n\nTest Intersection");
		System.out.println("Print out all values in the intersection Set of set 1 and 2- Expect: 0-9:");
		SetInterface<Integer> intersectionSet = new ResizableArraySet<Integer>();
		intersectionSet = testSet3.intersection(testSet4);
		Object[] intersectionToArray = intersectionSet.toArray();
		for(int i = 0; i < intersectionToArray.length; i++) {
			System.out.print(intersectionToArray[i] + ", ");
		}
		
		System.out.println("\n\nCheck that sets remain unchanged");
		System.out.println("toArray 1: ");
		set3ToArray = testSet3.toArray();
	    set4ToArray = testSet4.toArray();
		for(int i = 0; i < set3ToArray.length; i++) {
			System.out.print(set3ToArray[i] + ", ");
		}
		System.out.println("\n\ntoArray 2: ");
		for(int i = 0; i < set4ToArray.length; i++) {
			System.out.print(set4ToArray[i] + ", ");
		}
		
		System.out.println("\n\nTest difference");
		System.out.println("Set 1 - Set 2 - expect empty set");
		SetInterface<Integer> differenceSet = new ResizableArraySet<Integer>();
		differenceSet = testSet3.difference(testSet4);
		Object[]differenceToArray = differenceSet.toArray();
		for(int i = 0; i < differenceToArray.length; i++) {
			System.out.print(differenceToArray[i] + ", ");
		}
		System.out.println("getCurrentSize: " + differenceSet.getCurrentSize());
		
		System.out.println("\nCheck that sets remain unchanged");
		System.out.println("\ntoArray 1: ");
		set3ToArray = testSet3.toArray();
	    set4ToArray = testSet4.toArray();
		for(int i = 0; i < set3ToArray.length; i++) {
			System.out.print(set3ToArray[i] + ", ");
		}
		System.out.println("\n\ntoArray 2: ");
		for(int i = 0; i < set4ToArray.length; i++) {
			System.out.print(set4ToArray[i] + ", ");
		}
		
		System.out.println("\n\nSet 2 - Set 1 - expect set containing 10-14");
		SetInterface<Integer> differenceSet2 = new ResizableArraySet<Integer>();
		differenceSet2 = testSet4.difference(testSet3);
		Object[] differenceToArray2 = differenceSet2.toArray();
		for(int i = 0; i < differenceToArray2.length; i++) {
			System.out.print(differenceToArray2[i] + ", ");
		}
		System.out.println("\n\ngetCurrentSize - should be 5: " + differenceSet2.getCurrentSize());
	}
}
