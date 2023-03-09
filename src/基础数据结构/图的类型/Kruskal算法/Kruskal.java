package 基础数据结构.图的类型.Kruskal算法;

import java.util.*;

public class Kruskal {
    public Set<Edge> kru() {
        PriorityQueue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        Graph graph = new Graph();
        UnionFind unionFind = new UnionFind(graph.node.values());
        for (Edge edge : graph.edges) {
            queue.add(edge);
        }
        Set<Edge> res = new HashSet<>();
        while (!queue.isEmpty()) {
            Edge curNode = queue.poll();
            Node from = curNode.from;
            Node to = curNode.to;
            if (!unionFind.isUnion(from, to)) {
                res.add(curNode);
                unionFind.union(from, to);
            }
        }
        return res;
    }
}

class UnionFind {
    HashMap<Node, Node> father;
    HashMap<Node, Integer> size;

    public UnionFind(Collection<Node> values) {
        father = new HashMap<>();
        size = new HashMap<>();
        for (Node value : values) {
            father.put(value, value);
            size.put(value, 1);
        }
    }

    public void union(Node first, Node second) {
        first = getFather(first);
        second = getFather(second);
        if (second != first) {
            Integer fs = size.get(first);
            Integer ss = size.get(second);
            int big = Math.max(fs, ss);
            Node bigNode = fs == big ? first : second;
            Node smallNode = bigNode == first ? second : first;
            father.put(smallNode, bigNode);
            size.put(bigNode, fs + ss);
            size.remove(smallNode);
        }
    }

    private Node getFather(Node first) {
        if (father.get(first) != first) {
            father.put(first, getFather(father.get(first)));
        }
        return first;
    }

    public boolean isUnion(Node first, Node second) {
        return getFather(first) == getFather(second);
    }
}

class Graph {
    HashMap<Integer, Node> node;
    Set<Edge> edges;

    public Graph() {
        node = new HashMap<>();
        edges = new HashSet<>();
    }
}

class Node {
    int val;
    ArrayList<Node> nexts;
    ArrayList<Edge> egdes;

    public Node(int val) {
        this.val = val;
        nexts = new ArrayList<>();
        egdes = new ArrayList<>();
    }
}

class Edge {
    int weight;
    Node from;
    Node to;

    public Edge(int weight) {
        this.weight = weight;
    }
}
