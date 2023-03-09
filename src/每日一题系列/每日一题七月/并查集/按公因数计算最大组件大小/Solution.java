package 每日一题系列.每日一题七月.并查集.按公因数计算最大组件大小;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, 6, 7, 4, 12, 21, 39};
        int[] nums2 = {4, 6, 15, 35};

        System.out.println(solution.largestComponentSize(nums));
    }

    public int largestComponentSize(int[] nums) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int num : nums) {
            fun(num, map);
        }
        Graph graph = new Graph();
        for (Integer first : map.keySet()) {
            for (Integer second : map.keySet()) {
                if (!first.equals(second)) {
                    if (!graph.node.containsKey(first)) {
                        graph.node.put(first, new Node(first));
                    }
                    if (!graph.node.containsKey(second)) {
                        graph.node.put(second, new Node(second));
                    }
                    Node firstNode = graph.node.get(first);
                    Node secondNode = graph.node.get(second);
                    if (isChecek(first, second, map)) {
                        firstNode.nexts.add(secondNode);
                    }
                }
            }
        }
        return findMax(graph);
    }

    private void fun(int num, HashMap<Integer, Set<Integer>> map) {
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                set.add(i);
            }
        }
        set.add(num);
        map.put(num, set);
    }

    private int findMax(Graph graph) {
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        int max = 0;
        for (Node value : graph.node.values()) {
            int curMax = 0;
            if (!set.contains(value)) {
                set.add(value);
                queue.add(value);
                while (!queue.isEmpty()) {
                    Node next = queue.poll();
                    curMax++;
                    set.add(next);
                    for (Node node : next.nexts) {
                        if (!set.contains(node)) {
                            set.add(node);
                            queue.add(node);
                        }
                    }
                }
                max = Math.max(max, curMax);
                if (max == graph.node.size()) {
                    return max;

                }
            }
        }
        return max;
    }

    private boolean isChecek(Integer first, Integer second, HashMap<Integer, Set<Integer>> map) {
        Set<Integer> firstList = map.get(first);
        Set<Integer> secondList = map.get(second);
        for (Integer integer : firstList) {
            if (secondList.contains(integer)) {
                return true;
            }
        }
        ;
        return false;
    }
}

class Node {
    ArrayList<Node> nexts;
    int val;

    public Node(int val) {
        this.val = val;
        nexts = new ArrayList<>();
    }
}

class Graph {
    Map<Integer, Node> node;

    public Graph() {
        node = new HashMap<>();
    }
}
