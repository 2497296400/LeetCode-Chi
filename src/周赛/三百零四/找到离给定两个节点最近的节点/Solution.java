package 周赛.三百零四.找到离给定两个节点最近的节点;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,2,3,-1};
        Solution solution = new Solution();
        System.out.println(solution.closestMeetingNode(nums, 0, 2));
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Graph graph = new Graph();
        for (int i = 0; i < edges.length; i++) {
            if (!graph.node.containsKey(i)) {
                graph.node.put(i, new Node(i));
            }
            if (edges[i] >= 0) {
                if (!graph.node.containsKey(edges[i])) {
                    graph.node.put(edges[i], new Node(edges[i]));
                }
                Node first = graph.node.get(i);
                Node second = graph.node.get(edges[i]);
                first.nexts.add(second);
            }
        }
        return fun(graph, node1, node2);
    }

    private int fun(Graph graph, int node1, int node2) {
        Node first = graph.node.get(node1);
        Node second = graph.node.get(node2);
        HashMap<Node, Integer> firstMap = new HashMap<>();
        HashMap<Node, Integer> secondMap = new HashMap<>();
        //toCheck(first, firstMap);
        //toCheck(second, secondMap);
        int []f=new int[graph.node.size()];
        int []s=new int[graph.node.size()];
        firstMap.put(first,0);
        secondMap.put(second,0);
        dfs(first,firstMap,graph,0);
        System.out.println("-----------");
        dfs(second,secondMap,graph,0);
        TreeSet<Data> data = new TreeSet<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.curMax - o2.curMax==0?o1.node.var-o2.node.var:o1.curMax-o2.curMax;
            }
        });
        for (Map.Entry<Node, Integer> firstEntry : firstMap.entrySet()) {
            if (secondMap.containsKey(firstEntry.getKey())) {
                data.add(new Data(firstEntry.getKey(), Math.max
                        (firstEntry.getValue()
                                , secondMap.get(firstEntry.getKey()))));
            }
        }
        System.out.println("--------------");
        return data.isEmpty() ? -1 : data.first().node.var;
    }

    private void dfs(Node first, HashMap<Node, Integer> firstMap, Graph graph, int curDepth) {
        for (Node next :first.nexts) {
            if(!firstMap.containsKey(next)){
                firstMap.put(next,curDepth);
                System.out.println(next.var);
                dfs(next,firstMap,graph,curDepth+1);
            }
        }
    }
    private void toCheck(Node node, HashMap<Node, Integer> map) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.add(node);
        int len = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curNode = queue.poll();
                map.put(curNode, len);
                set.add(curNode);
                for (Node next : curNode.nexts) {
                    if (!set.contains(next)) {
                        set.add(next);
                        queue.add(next);
                    }
                }
            }
            len++;
        }
    }
}

class Data {
    Node node;
    int curMax;

    public Data(Node node, int curMax) {
        this.node = node;
        this.curMax = curMax;
    }
}

class Graph {
    HashMap<Integer, Node> node;

    public Graph() {
        node = new HashMap<>();
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