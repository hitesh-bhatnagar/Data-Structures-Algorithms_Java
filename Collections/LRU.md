# Designing an LRU Cache

Least Recently Used cache evicts the leaast recently used item when it reaches it capacity. 
Convinient to implement an LRU using Cache using LinkedHashMap

## Requirements:

* get(key): Return the value if the key exists in the cache, otherwise return -1.
* put(key, value): Insert the key-value pair into the cache. If the cache reaches capacity, it should evict the least recently used entry.
* Both operations should run in O(1) time.

## Why LinkedHashMap?

* LinkedHashMap maintains insertion order (or access order if configured).
* By setting it in access-order mode, we can have the most-recently accessed entries at one end and the least recently used at the other.
* It provides a convenient method called removeEldestEntry() which we can override to automatically remove the least recently used entry when a new entry is added.
