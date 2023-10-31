package EricShinozaki_p1;
public class LinkedSetTest {

	public static void main(String[] args) {
		SetInterface<String> testSet = new LinkedSet<String>();
		SetInterface<String> testSet2 = new LinkedSet<String>();
		
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
		System.out.println("add the following string to Set 1 - Yes, No, Hi, there, hello");
		System.out.println("Expect all true");
		System.out.println(testSet.add("Yes"));
		System.out.println(testSet.add("No"));
		System.out.println(testSet.add("Hi"));
		System.out.println(testSet.add("there"));
		System.out.println(testSet.add("hello"));
		
		System.out.println("");
		System.out.println("\ntry to add Yes, No, Hi, there, Hello to set 1 again");
		System.out.println("Expect all false");
		System.out.println(testSet.add("Yes"));
		System.out.println(testSet.add("No"));
		System.out.println(testSet.add("Hi"));
		System.out.println(testSet.add("there"));
		System.out.println(testSet.add("hello"));
		
		System.out.println("\n");
		
		System.out.println("add the following string to Set 2 - Bob, Tim, Timmy, Tooth, paste, Yes, No, Hi, there, hello");
		System.out.println("Expect all true");
		System.out.println(testSet2.add("Bob"));
		System.out.println(testSet2.add("Tim"));
		System.out.println(testSet2.add("Timmy"));
		System.out.println(testSet2.add("Toothe"));
		System.out.println(testSet2.add("paste"));
		System.out.println(testSet2.add("Yes"));
		System.out.println(testSet2.add("No"));
		System.out.println(testSet2.add("Hi"));
		System.out.println(testSet2.add("there"));
		System.out.println(testSet2.add("hello"));
		
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
		
		System.out.println("call remove 2 times: ");
		for(int i = 0; i < 2; i++) {
			System.out.println(testSet.remove());
		}
		System.out.println("\n" + "call remove 3 times: ");
		for(int i = 0; i < 3; i++) {
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
		System.out.println("\ntest remove specific items from set 2 \n");
		System.out.println("remove Bob, should return true: " + testSet2.remove("Bob"));
		System.out.println("remove paste, should return true: " + testSet2.remove("paste"));
		System.out.println("remove Yellow, should return false: " + testSet2.remove("Yellow"));
		
		
		System.out.println("\ntoArray on testSet2");
		set2ToArray = testSet2.toArray();
		for(int i = 0; i < set2ToArray.length; i++) {
			System.out.print(set2ToArray[i] + ", ");
		}
		System.out.println("\ngetCurrentSize: " + testSet2.getCurrentSize() + "\n");
		
		// Method #7 contains - 
		
		System.out.println("contains: Orange and Yes");
		System.out.println(testSet2.contains("Orange") + " should be false");
		System.out.println(testSet2.contains("Yes")+ " should be true");
		System.out.println("");
		
		//re-test methods after clearing set
		
		System.out.println("Clear the set");
		testSet2.clear();
		System.out.println("getCurrentSize: " + testSet2.getCurrentSize());
		System.out.println("isEmpty: " + testSet2.isEmpty());
		System.out.println("remove: " + testSet2.remove());
		System.out.println("remove Yes: " + testSet2.remove("Yes"));
		System.out.println("contains Yes: " + testSet2.contains("Yes"));
		set2ToArray = testSet2.toArray();
		System.out.println("print the array - should print nothing");
		for(int i = 0; i < set2ToArray.length; i++) {
			System.out.print(set2ToArray[i] + ", ");
		}
		
		//test union, intersection, and difference
		
		System.out.println("\nTest union, intersection, and difference");
		System.out.println("Set 1 contains Yes, No, Hi, there, hello");
		System.out.println("Set 2 contains Bob, Tim, Timmy, Toothe, paste, Yes, No, Hi, there, hello");
		
		SetInterface<String> testSet3 = new LinkedSet<String>();
		SetInterface<String> testSet4 = new LinkedSet<String>();
		
		testSet3.add("Yes");
		testSet3.add("No");
		testSet3.add("Hi");
		testSet3.add("there");
		testSet3.add("hello");
		
		testSet4.add("Bob");
		testSet4.add("Tim");
		testSet4.add("Timmy");
		testSet4.add("Toothe");
		testSet4.add("paste");
		testSet4.add("Yes");
		testSet4.add("No");
		testSet4.add("Hi");
		testSet4.add("there");
		testSet4.add("hello");
		
		System.out.println("\nTest union");
		System.out.println("Print out all values in the union Set of set 1 and set 2 - Expect following strings: "
				+ "hello, there, Hi, No, Yes, paste, Toothe, Timmy, Tim, Bob, \r\n"
				+ "");
		SetInterface<String> unionSet = new LinkedSet<String>();
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
		System.out.println("Print out all values in the intersection Set of set 1 and 2- Expect: hello, there, Hi, No, Yes,");
		SetInterface<String> intersectionSet = new LinkedSet<String>();
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
		SetInterface<String> differenceSet = new LinkedSet<String>();
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
		
		System.out.println("\n\nSet 2 - Set 1 - expect set containing: Bob, Tim, Timmy, Toothe, paste");
		SetInterface<String> differenceSet2 = new LinkedSet<String>();
		differenceSet2 = testSet4.difference(testSet3);
		Object[] differenceToArray2 = differenceSet2.toArray();
		for(int i = 0; i < differenceToArray2.length; i++) {
			System.out.print(differenceToArray2[i] + ", ");
		}
		System.out.println("\n\ngetCurrentSize - should be 5: " + differenceSet2.getCurrentSize());
	}
}
