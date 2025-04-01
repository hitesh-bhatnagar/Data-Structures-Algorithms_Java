import java.util.*;

public class linkedhashMap {
    public static void main(String[] args) {
        // similar to HashMap but it maintains the insertion order
        // Allows null keys and values
        // fast but slower than hashMap
        Map<Integer,String> map = new LinkedHashMap<>();
        map.put(10,"A");
        map.put(20,"B");
        map.put(34,"x");
        System.out.println(map);
    }
}
