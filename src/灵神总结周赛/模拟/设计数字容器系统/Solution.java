package 灵神总结周赛.模拟.设计数字容器系统;

import java.util.HashMap;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        NumberContainers numberContainers = new NumberContainers();
        numberContainers.change(2, 10);
        numberContainers.change(1, 10);
        numberContainers.change(3, 10);
        System.out.println(numberContainers.find(10));
        numberContainers.change(1, 20);
        System.out.println(numberContainers.find(10));
    }
}

class NumberContainers {
    HashMap<Integer, TreeSet<Integer>> treeMap;
    HashMap<Integer, Integer> indexMap;

    public NumberContainers() {
        treeMap = new HashMap<>();
        indexMap = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexMap.containsKey(index)) {
            Integer integer = indexMap.get(index);
            if (treeMap.containsKey(integer)) {
                treeMap.get(integer).remove(index);
                if(treeMap.get(integer).size()==0){
                    treeMap.remove(integer);
                }
            }
            if (treeMap.containsKey(number)) {
                treeMap.get(number).add(index);
            } else {
                TreeSet<Integer> temp = new TreeSet<>();
                temp.add(index);
                treeMap.put(number, temp);
            }
            indexMap.put(index, number);
        } else {
            indexMap.put(index, number);
            if (!treeMap.containsKey(number)) {
                TreeSet<Integer> temp = new TreeSet<>();
                temp.add(index);
                treeMap.put(number, temp);
            } else {
                treeMap.get(number).add(index);
            }
        }
    }

    public int find(int number) {
        if (treeMap.containsKey(number)) {
            return treeMap.get(number).first();
        }
        return -1;
    }
}