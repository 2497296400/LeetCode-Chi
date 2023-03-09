package 基础数据结构.LFU;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUcode {
    HashMap<Integer, Integer> keyToVal;
    HashMap<Integer, Integer> fredToKey;
    HashMap<Integer, LinkedHashSet<Integer>> keysToFred;
    int minFred;
    int capacity;

    public LFUcode(int capacity) {
        keyToVal = new HashMap<>();
        fredToKey = new HashMap<>();
        keysToFred = new HashMap<>();
        minFred = Integer.MAX_VALUE;
        this.capacity = capacity;
    }

    public int getKey(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        increaseFred(key);
        return keyToVal.get(key);
    }

    private void increaseFred(int key) {
        Integer fred = fredToKey.get(key);
        fredToKey.put(key, fred + 1);
        keysToFred.get(fred).remove(key);
        keysToFred.putIfAbsent(fred + 1, new LinkedHashSet<>());
        keysToFred.get(fred + 1).add(key);
        if(keysToFred.get(fred).isEmpty()){
            keysToFred.remove(fred);
            if(fred==this.minFred){
                this.minFred++;
            }
        }
    }
    public void push(int key, int val) {
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, val);
            increaseFred(val);
            return;
        }
        if (keyToVal.size() == capacity) {
            removeMinFred();
        }
        keyToVal.put(key, val);
        fredToKey.put(key, 1);
        keysToFred.putIfAbsent(1, new LinkedHashSet<>());
        keysToFred.get(1).add(key);
        this.minFred = 1;

    }

    private void removeMinFred() {
        LinkedHashSet<Integer> minFredKeys = keysToFred.get(this.minFred);
        Integer next = minFredKeys.iterator().next();
        minFredKeys.remove(next);
        if (minFredKeys.isEmpty()) {
            keysToFred.remove(this.minFred);
        }
        keyToVal.remove(next);
        fredToKey.remove(next);
    }
}
