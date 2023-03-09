package 精选一百道题.LRU缓存;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        System.out.println(cache.get(1));
    }

    static class LRUCache {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        private int size = 0;
        public int count = 0;
        private LinkedList<Integer> list;

        public LRUCache(int capacity) {
            count = capacity;
            list = new LinkedList<>();
        }

        public int get(int key) {
            if (hashMap.containsKey(key)) {
                list.remove((Integer) key);
                list.addLast(key);
                return hashMap.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            if (hashMap.containsKey(key)) {
                size--;
                list.remove((Integer) key);
            }
            hashMap.put(key, value);
            list.addLast(key);
            size++;
            if (size > count) {
                int tempKey = list.getFirst();
                list.removeFirst();
                size--;
                hashMap.remove(tempKey);
            }
        }
    }
}