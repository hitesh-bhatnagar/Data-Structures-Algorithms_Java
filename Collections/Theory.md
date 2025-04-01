4️⃣ When to Use Which Collection?

✅ Use List when:
You need ordered elements (ArrayList, LinkedList).
You allow duplicates.
Frequent access is needed (ArrayList is faster than LinkedList for access).

✅ Use Set when:
You need unique elements.
You don’t care about insertion order (HashSet is best for fast lookup).
You want sorted elements (TreeSet maintains order).

✅ Use Queue when:
You need FIFO (First-In-First-Out) operations (e.g., task scheduling).
PriorityQueue if you need priority-based sorting.

✅ Use Map when:
You need key-value storage.
HashMap for fast lookup.
TreeMap for sorted keys.



###             How to declare them

List<Integer> list = new ArrayList<>();         // Dynamic List
Set<String> set = new HashSet<>();              // Unique values
Queue<Double> queue = new LinkedList();        // FIFO 
Map<String, Integer> map = new HashMap<>();     // Key-value pairs


###             To Add elements manually

List<Integer> list = list.of(1,2,3);                    // Immutable List
Set<String> set = Set.of("A","B","c");                  // Immutable Set
Map< String, Integer > map = Map.of("A",1,"B",2);       // Immutable Map 


2️⃣ List Common Methods
Method	Description
add(E e)	Adds an element to the list
add(int index, E e)	Inserts element at the given index
remove(int index)	Removes element at the index
remove(Object o)	Removes the first occurrence of an element
set(int index, E e)	Replaces an element at index
get(int index)	Returns the element at index
size()	Returns the size of the list
contains(E e)	Checks if the element exists
indexOf(E e)	Returns the index of the first occurrence
clear()	Removes all elements
isEmpty()	Checks if list is empty

