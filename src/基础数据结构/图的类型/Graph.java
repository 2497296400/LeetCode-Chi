package 基础数据结构.图的类型;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Graph {
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;
    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
class Node {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;
    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
    class Edge {
        public int weight;
        public Node from;
        public Node to;
        public Edge(int weight, Node from, Node to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
}
