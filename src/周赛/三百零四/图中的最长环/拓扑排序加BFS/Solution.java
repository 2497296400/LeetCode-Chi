package 周赛.三百零四.图中的最长环.拓扑排序加BFS;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,4,0,2,-1,2};
        int []nums1={2,-1,3,1};

        System.out.println(solution.longestCycle(nums));
    }

    public int longestCycle(int[] edges) {
        Graph graph = new Graph();

        for (int i = 0; i < edges.length; i++) {
            if (!graph.node.containsKey(i)) {
                graph.node.put(i, new Node(i));

            }
            if (!graph.node.containsKey(edges[i]) && edges[i] >= 0) {
                graph.node.put(edges[i], new Node(edges[i]));
            }
            if (edges[i] >= 0) {
                Node first = graph.node.get(i);
                Node second = graph.node.get(edges[i]);
                first.nexts.add(second);
                second.in++;
            }
        }
        return fun(graph);

    }

    private int fun(Graph graph) {
        Queue<Node> zeroQ = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        for (Node value : graph.node.values()) {
            if (value.in == 0) {
                zeroQ.add(value);
                set.add(value);
            }
        }
        if (zeroQ.isEmpty()) {
            return toGet(graph);
        }
        while (!zeroQ.isEmpty()) {
            Node node = zeroQ.poll();
            for (Node next : node.nexts) {
                next.in--;
                if (next.in == 0) {
                    zeroQ.add(next);
                    set.add(next);
                }
            }
        }
        for (Node node : set) {
            graph.node.remove(node.value);
            node.nexts = null;
        }
        return toGet(graph);
    }
    private int toGet(Graph graph) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        int max=-1;
        for (Node value : graph.node.values()) {
            int curMax = 1;
            if (!set.contains(value)) {
                queue.add(value);
            }
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                set.add(node);
                for (Node next : node.nexts) {
                    if(!set.contains(next)) {
                        queue.add(next);
                        set.add(next);
                        curMax++;
                    }
                }
            }
            max=Math.max(curMax,max);
        }
        return max;
    }
}

class Node {
    int value;
    ArrayList<Node> nexts;
    int in;

    public Node(int value) {
        this.value = value;
        nexts = new ArrayList<>();
        in = 0;
    }
}

class Graph {
    HashMap<Integer, Node> node;

    public Graph() {
        node = new HashMap<>();
    }
}