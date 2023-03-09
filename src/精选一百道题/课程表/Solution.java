package 精选一百道题.课程表;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] ints = {{0, 1}, {1, 2},{2,1}};

        boolean finish = new Solution().canFinish(2, ints);
        System.out.println(finish);

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph();
        for (int[] prerequisite : prerequisites) {
            int fromNode = prerequisite[0];
            int toNode = prerequisite[1];
            if (!graph.nodes.containsKey(fromNode)) {
                graph.nodes.put(fromNode, new Node(fromNode));
            }
            if (!graph.nodes.containsKey(toNode)) {
                graph.nodes.put(toNode, new Node(toNode));
            }
            Node from = graph.nodes.get(fromNode);
            from.to++;
            Node to = graph.nodes.get(toNode);
            to.in++;
            from.nexts.add(to);
        }
        if(numCourses<=1||prerequisites.length<1){
            return true;
        }
        return check(graph);
    }

    private boolean check(Graph graph) {
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroQueue = new LinkedList<>();
        int sum = 0;
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroQueue.add(node);
                sum++;

            }
        }
        if (zeroQueue.isEmpty()) {
            return false;
        }
        while (!zeroQueue.isEmpty()) {
            Node cur = zeroQueue.poll();
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroQueue.add(next);
                    sum++;
                }
            }
        }
        return sum == graph.nodes.size();
    }

    class Graph {
        HashMap<Integer, Node> nodes;

        public Graph() {
            nodes = new HashMap<>();
        }
    }

    class Node {
        int in;
        int to;
        int value;
        ArrayList<Node> nexts;

        public Node(int value) {
            in = 0;
            to = 0;
            nexts = new ArrayList<>();
            this.value = value;
        }
    }
}