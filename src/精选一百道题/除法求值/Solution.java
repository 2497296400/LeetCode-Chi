package 精选一百道题.除法求值;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> e = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("x1");
        list1.add("x2");
        List<String> list2 = new ArrayList<>();
        list2.add("x2");
        list2.add("x3");
        List<String> list3 = new ArrayList<>();
        list3.add("x3");
        list3.add("x4");
        List<String> list4 = new ArrayList<>();
        list4.add("x4");
        list4.add("x5");
        double[] doubles = {3.0, 4.0, 5.0,6.0};
        Collections.addAll(e, list1, list2,list3, list4);
        List<List<String>> f = new ArrayList<>();
        List<String> list5 = new ArrayList<>();
        list5.add("x2");
        list5.add("x4");
        f.add(list5);
        System.out.println(Arrays.toString(solution.calcEquation(e, doubles, f)));
    }
    int len = 0;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        Grap grap = new Grap();
        for (int i = 0; i < values.length; i++) {
            List<String> list = equations.get(i);
            String first = list.get(0);
            String second = list.get(1);
            double value = values[i];
            if (!grap.node.containsKey(first)) {
                grap.node.put(first, new Node(first));
            }
            if (!grap.node.containsKey(second)) {
                grap.node.put(second, new Node(second));
            }
            Node firstNode = grap.node.get(first);
            Node secondNode = grap.node.get(second);
            firstNode.nexts.add(secondNode);
            secondNode.nexts.add(firstNode);
            Edge edgeFirst = new Edge(firstNode, secondNode, value);
            Edge edgeSecond = new Edge(secondNode, firstNode, 1.0 / value);
            firstNode.edges.add(edgeFirst);
            secondNode.edges.add(edgeSecond);
            grap.edges.add(edgeFirst);
            grap.edges.add(edgeSecond);

        }
        for (List<String> list : queries) {
            String first = list.get(0);
            String second = list.get(1);
            if (!grap.node.containsKey(first) || !grap.node.containsKey(second)) {
                ans[len++] = -1;
            } else {double f=fun(grap, first, second, ans, len);
                ans[len++]=f==0?-1:f;
            }
        }
        return ans;
    }

    private double fun(Grap grap, String first, String second, double[] ans, int len) {
        Node firstNode = grap.node.get(first);
        Node soncdNode = grap.node.get(second);
        HashSet<Node> set = new HashSet<>();
        set.add(firstNode);
        return DFS(firstNode, soncdNode, grap, set, null);
    }
    private double DFS(Node firstNode, Node soncdNode, Grap grap, HashSet<Node> set, Node pre) {
        double ans = 1.0d;
        for (Node next : firstNode.nexts) {
            if (set.contains(soncdNode)) {
                break;
            }
            if (!set.contains(next)) {
                set.add(next);
                ans = DFS(next, soncdNode, grap, set, firstNode);
            }
        }
        if(!set.contains(soncdNode)){
            return 0;
        }
        for (Edge edge : grap.edges) {
            if (edge.from == pre && edge.to == firstNode) {
                ans *= edge.weight;
                break;
            }
        }
        return ans;
    }
}

class Grap {
    HashMap<String, Node> node;
    HashSet<Edge> edges;

    public Grap() {
        node = new HashMap<>();
        edges = new HashSet<>();

    }
}

class Node {
    String var;
    ArrayList<Node> nexts;
    ArrayList<Edge> edges;

    public Node(String var) {
        this.var = var;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}

class Edge {
    Node from;
    Node to;
    double weight;

    public Edge(Node from, Node to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}