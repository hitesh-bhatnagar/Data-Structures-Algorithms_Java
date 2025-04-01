import java.util.*;

public class Map_Functions {
    public static void main(String[] args) {
        // 1. Create a HashMap and add key-value pairs.
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");
        map.put(0, "Mango");    // Using 0 instead of null

        // 2. Use putIfAbsent
        map.putIfAbsent(2, "Blueberry");    // Won't override since key 2 exists.
        map.putIfAbsent(4, "Date");            // Inserts key 4.

        // 3. get() and getOrDefault()
        System.out.println("Key 1: " + map.get(1));    // Apple
        System.out.println("Key 10 (default): " + map.getOrDefault(10, "Not Found"));

        // 4. Remove operations
        String removedValue = map.remove(3);
        System.out.println("Removed value for key 3: " + removedValue);

        // 5. Replacement and replaceAll
        map.replace(1, "Apricot");
        map.replace(4, "Date", "Dragonfruit");
        map.replaceAll((k, v) -> v.toUpperCase());
        System.out.println("After replaceAll: " + map);

        // 6. Compute methods
        map.compute(2, (k, v) -> v + " (Ripe)");
        map.computeIfAbsent(5, k -> "Elderberry");
        map.computeIfPresent(1, (k, v) -> v + " (Fresh)");
        System.out.println("After compute methods: " + map);

        // 7. Merge method
        map.merge(2, " & YELLOW", (oldVal, newVal) -> oldVal + newVal);
        System.out.println("After merge: " + map);

        // 8. Querying methods
        System.out.println("Contains key 1? " + map.containsKey(1));
        System.out.println("Contains value 'DRAGONFRUIT'? " + map.containsValue("DRAGONFRUIT"));

        // 9. Bulk operations: keySet, values, entrySet
        Set<Integer> keys = map.keySet();
        Collection<String> values = map.values();
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        System.out.println("Keys: " + keys);
        System.out.println("Values: " + values);
        System.out.println("Entries: " + entries);

        // 10. Iterating using forEach and streams
        map.forEach((k, v) -> System.out.println("Key " + k + " maps to " + v));

        // Sorting Map entries by key (using streams)
        System.out.println("Sorted by keys:");
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()) // No null handling needed now
                .forEach(System.out::println);

        // Sorting Map entries by value (using streams)
        System.out.println("Sorted by values:");
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

        // 11. Clear the map
        map.clear();
        System.out.println("Map after clear: " + map);

 //    ----------------------------------------------------------------------

         // Important to understand functions 
        
         Map<Integer, String> maping = new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");

        Set<Map.Entry<Integer,String>> entries = map.entrySet();
        for(Map.Entry<Integer,String> entry : entries) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key "+ key + " value "+ value);
        }

        // using forEach
        mapping .entrySet().forEach(entry -> System.out.println("Key "+ entry.getKey()+" value "+ entry.getValue()));

        // Using forEach 
        mapping.entrySet().forEach(System.out:: println);       // this relies on Map.Entry's toString() method

    }
}