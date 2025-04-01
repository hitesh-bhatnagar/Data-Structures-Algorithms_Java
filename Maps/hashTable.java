import java.util.*;
public class hashTable {
    public static void main(String[] args) {
        // Thread-safe (synchronized)
        // Fast in multi-threaded env
        // does not allows null keys or values
        // slower than hashmap
        Map<Integer,String> map = new Hashtable<>();

        map.put(1,"A");
        map.put(2,"B");
        System.out.println(map);
    }
    
}
