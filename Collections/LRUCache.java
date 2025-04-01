import java.util.*;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private final int capacity;

    // Constructor: initial capacity, load factor, and accessOrder true
    public LRUCache(int capacity){
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    // This method is called after each put or putAll . Return true to remove the eldest entry.
    @Override 
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > capacity;
    }

    // get() and put() methods are inherited and they update the order automatically'
    public V getValue(K key){
        return super.getOrDefault(key, null);
    }
    
    public void putValue(K key , V value){
        super.put(key, value);
    }

    // for debugging shoe current state of the cache
    public String toString() {
        return super.toString();
    }


    public static void main(String args[]){
        // create an LRUCache with capacity 3
        LRUCache<Integer,String> cache = new LRUCache<>(3);

        // populate the cache
        cache.putValue(1,"One");
        cache.putValue(2,"Two");
        cache.putValue(3,"Three");
        System.out.println("Cache : "+ cache);      // {1 = One, 2 = Two, 3 = Three}

        // Access key 1 (Updates order, making key 1 the most recently used)
        System.out.println("Get key 1 : "+ cache.getValue(1));
        System.out.println("Cache after accessing key 1 : "+ cache);
        // Now order becomes {2 = Two, 3 = Three, 1 = One}

        // Add a new entry; this should evict key 2, the least recently used 
        cache.putValue(4, "Four");
        System.out.println("Cache after adding key 4: "+ cache);
        // expected output: {3 = Three, 1 = One, 4 = Four}  (key 2 evicted)

        // Access key 3 to update order
        cache.getValue(3);
        System.out.println("Cache after accessing key 3 : "+ cache);

        // Add another entry; should evict the least recently used entry now 
        cache.putValue(5,"Five");
        System.out.println("Cache after adding key 5: "+ cache);
        // Expected output: {1 = One, 3 = Three, 5 = Five}
    }
}