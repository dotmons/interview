package leetcode;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;

public class LRUCache {

    int capacity;
    int counter = 0;
    HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
    PriorityQueue<TimestampPriorityQueue> priorityQueue = new PriorityQueue<>((a, b) -> a.timestamp.compareTo(b.timestamp));


    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) throws InterruptedException {
        if (hashMap.isEmpty()) {
            return -1;
        } else if (hashMap.containsKey(key)) {
            addKeyTimeStamp(key);
            return hashMap.get(key);
        }
        return -1;
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "capacity=" + capacity +
                ", counter=" + counter +
                ", hashMap=" + hashMap +
                '}';
    }

    public void put(int key, int value) throws InterruptedException {
        if (!(hashMap.containsKey(key)) && (counter < capacity)) {
            addKeyTimeStamp(key);
            hashMap.put(key, value);
            counter++;
        } else if (!(hashMap.containsKey(key)) && (counter == capacity)) {
            addKeyTimeStamp(key);
            hashMap.remove(counter);
            hashMap.put(key, value);
        }
    }

    private void addKeyTimeStamp(int key) throws InterruptedException {
        if (!hashMap.containsKey(key) && (counter < capacity)) {
            priorityQueue.add(new TimestampPriorityQueue(key));
           for (TimestampPriorityQueue q : priorityQueue) {
               System.out.println("Key: " + q.key + " timestamp: " + q.timestamp );
           }
        } else if (hashMap.containsKey(key) && (counter == capacity)) {
            PriorityQueue<TimestampPriorityQueue> pq = new PriorityQueue<>((a,b) -> b.timestamp.compareTo(a.timestamp));

            while (!priorityQueue.isEmpty()) {
                TimestampPriorityQueue q = priorityQueue.poll();
                if (q.key != key) {
                    pq.add(q);
                }
            }
            priorityQueue.add(new TimestampPriorityQueue(key));
            priorityQueue.addAll(pq);

            for (TimestampPriorityQueue q : priorityQueue) {
                System.out.println("updated Key: " + q.key + " timestamp: " + q.timestamp );
            }
        }
        Thread.sleep(100);
    }

    public static void main(String[] args) throws InterruptedException {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        System.out.println(lruCache);
        lruCache.put(2, 2);
        System.out.println(lruCache);
        System.out.println("lruCache.get(1): " + lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println("lruCache.get(2): " + lruCache.get(2));
        System.out.println(lruCache);
        lruCache.put(4, 4);
        System.out.println("lruCache.get(1): " + lruCache.get(1));
        System.out.println("lruCache.get(3): " + lruCache.get(3));
        System.out.println("lruCache.get(4): " + lruCache.get(4));
    }

    static class TimestampPriorityQueue {
        int key;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        public TimestampPriorityQueue(int key) {
            this.key = key;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */