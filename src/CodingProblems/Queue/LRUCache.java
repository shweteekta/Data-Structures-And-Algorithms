package Queue;

import java.util.*;
import java.util.Queue;

//        LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
//        int get(int key) Return the value of the key if the key exists, otherwise return -1.
//        void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
//                If the number of keys exceeds the capacity from this operation, evict the least recently used key.
public class LRUCache {
    int capacity = 0;
    Map<Integer, Integer> cache = new HashMap<>();
    Queue<Integer> lru = new ArrayDeque<>();

    public LRUCache(int capacity){
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        lru.remove(key);
        lru.offer(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            lru.remove(key);
        } else if (capacity == 0) {
            int removedKey = lru.poll();
            cache.remove(removedKey);
        } else {
            capacity--;
        }
        cache.put(key, value);
        lru.offer(key);
    }

    public void display(){
        System.out.println(cache);
        System.out.println(lru);
    }

    public static void main(String[] args){
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.display();
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        lruCache.get(3);
        lruCache.display();
    }
}
