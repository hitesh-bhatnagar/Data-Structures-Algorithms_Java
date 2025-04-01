import java.util.*;
public class treeMap {
    public static void main(String[] args) {
        // Sorted in acending order
        // implements SortedMap & NavigableMap
        // O(logn)
        Map<Integer,String> map = new TreeMap<>();
        map.put(45,"X");
        map.put(23,"A");
        map.put(21,"Y");
        System.out.println(map);
    }
}
