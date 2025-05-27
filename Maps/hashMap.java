import java.util.*;


public class hashMap {
    public static void main(String[] args) {
        // Unordered
        // Allows null keys and values
        // Fast 
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Mango");
        map.put(4, "Apple");
        map.put(null,"cherry"); 

        System.out.println(map);

        System.out.println("Get value for key 2: "+ map.get(2));
        System.out.println("Contains key 3? "+ map.containsKey(3));
        System.out.println("Contains value 'Mango' "+ map.containsValue("Mango"));

        map.remove(1);
        System.out.println("After removel "+map);
        System.out.println("keySet() returns a set of all keys "+ map.keySet());
        System.out.println("return collection of all values" + map.values());
        System.out.println("returns a set of key-value pairs "+ map.entrySet());
        
    }
}