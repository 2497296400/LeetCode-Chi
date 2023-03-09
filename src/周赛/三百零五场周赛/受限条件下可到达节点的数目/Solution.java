package 周赛.三百零五场周赛.受限条件下可到达节点的数目;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        int[][] edges = { {1, 0}};
        int[] res = {1};
        Solution solution = new Solution();
        System.out.println(solution.reachableNodes(2, edges, res));
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : restricted) {
            map.put(i, 0);
        }
        Graph graph = new Graph();
        for (int[] edge : edges) {
            int first = edge[0];
            int second = edge[1];
            if (!graph.node.containsKey(first)) {
                graph.node.put(first, new Node(first));
            }
            if (!graph.node.containsKey(second)) {
                graph.node.put(second, new Node(second));
            }
            Node firstNode = graph.node.get(first);
            Node secondNode = graph.node.get(second);
            firstNode.nexts.add(secondNode);
            secondNode.nexts.add(firstNode);
        }
        Node curZero = graph.node.get(0);
//        int sum = 1;
//        for (Node next : curZero.nexts) {
//            sum += fun(next, map, graph);
//        }
        dfs(curZero, map);
        System.out.println(curSum);
        return curSum==0?1:curSum;
    }
    public int curSum = 0;
    private void dfs(Node curZero, HashMap<Integer, Integer> map) {
        for (Node next : curZero.nexts) {
            if (!map.containsKey(next.var)) {
                curSum++;
                map.put(next.var, 0);
                dfs(next, map);
            }
        }
    }

    private int fun(Node next, HashMap<Integer, Integer> map, Graph graph) {
        Set<Node> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(next);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (!map.containsKey(node.var)) {
                set.add(node);
                for (Node curNext : node.nexts) {
                    if (!map.containsKey(curNext.var) && !set.contains(curNext) && curNext.var != 0) {
                        set.add(curNext);
                        queue.add(curNext);
                    }
                }
            }
        }
        return set.size();
    }
}

class Node {
    int var;
    ArrayList<Node> nexts;

    public Node(int var) {
        this.var = var;
        nexts = new ArrayList<>();
    }
}

class Graph {
    HashMap<Integer, Node> node;

    public Graph() {
        node = new HashMap<>();
    }
}