# 🌳 Types of Trees 🌳

### Requirements

- **🔍 `get(key)`**: Returns the value if the key exists in the cache, otherwise returns `-1`.
- **💾 `put(key, value)`**: Inserts the key-value pair into the cache. If the cache reaches capacity, it should evict the least recently used entry.
- **⏱️ Performance**: Both operations should run in **O(1)** time.

### Why LinkedHashMap?

- **🔗 Maintains Order**: LinkedHashMap keeps insertion order or access order (if configured).
- **🗂️ Access-Order Mode**: In access-order mode, the most-recently accessed entries are at one end, and the least recently used are at the other.
- **🗑️ Convenient Removal**: LinkedHashMap provides a handy method called `removeEldestEntry()`. By overriding this, we can automatically remove the least recently used entry when a new entry is added.

```java
LinkedHashMap<Integer, String> lruCache = new LinkedHashMap<Integer, String>(16, 0.75f, true) {
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
        return size() > capacity;
    }
};
```

