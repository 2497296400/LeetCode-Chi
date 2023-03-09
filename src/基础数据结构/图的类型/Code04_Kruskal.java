package 基础数据结构.图的类型;

//import java.util.*;
//
////undirected graph only
//public class Code04_Kruskal {
//
//    // Union-Find Set
//    public static class UnionFind {
//        private HashMap<Node, Node> fatherMap;
//        private HashMap<Node, Integer> rankMap;
//
//        public UnionFind() {
//            fatherMap = new HashMap<Node, Node>();
//            rankMap = new HashMap<Node, Integer>();
//        }
//
//        private Node findFather(Node n) {
//            Node father = fatherMap.get(n);
//            if (father != n) {
//                father = findFather(father);
//            }
//            fatherMap.put(n, father);
//            return father;
//        }
//
//        public void makeSets(Collection<Node> nodes) {
//            fatherMap.clear();
//            rankMap.clear();
//            for (Node node : nodes) {
//                fatherMap.put(node, node);
//                rankMap.put(node, 1);
//            }
//        }
//
//        public boolean isSameSet(Node a, Node b) {
//            return findFather(a) == findFather(b);
//        }
//
//        public void union(Node a, Node b) {
//            if (a == null || b == null) {
//                return;
//            }
//            Node aFather = findFather(a);
//            Node bFather = findFather(b);
//            if (aFather != bFather) {
//                int aFrank = rankMap.get(aFather);
//                int bFrank = rankMap.get(bFather);
//                if (aFrank <= bFrank) {
//                    fatherMap.put(aFather, bFather);
//                    rankMap.put(bFather, aFrank + bFrank);
//                } else {
//                    fatherMap.put(bFather, aFather);
//                    rankMap.put(aFather, aFrank + bFrank);
//                }
//            }
//        }
//    }
//    public static class EdgeComparator implements Comparator<Edge> {
//
//        @Override
//        public int compare(Edge o1, Edge o2) {
//            return o1.weight - o2.weight;
//        }
//
//    }
//    public static class GraphMap {
//        public HashMap<Node, List<Node>> SetMap;
//
//        public GraphMap(ArrayList<Node> nodes) {
//            for (Node node : nodes) {
//                ArrayList<Node> cur = new ArrayList<>();
//                cur.add(node);
//                SetMap.put(node, cur);
//            }
//        }
//        public boolean isSameSet(Node fromNode, Node toNode) {
//            List<Node> from = SetMap.get(fromNode);
//            List<Node>  to = SetMap.get(toNode);
//            return from==to;
//        }
//        public  void Union(Node fromNode,Node toNode){
//            List<Node> to = SetMap.get(toNode);
//            List<Node> from = SetMap.get(fromNode);
//            for (Node cur : to) {
//                from.add(cur);
//                SetMap.put(cur,from);
//            }
//        }
//    }
//
//    public static Set<Edge> kruskalMST(Graph graph) {
//        UnionFind unionFind = new UnionFind();
//        unionFind.makeSets(graph.nodes.values());
//        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
//        for (Edge edge : graph.edges) {
//            priorityQueue.add(edge);
//        }
//        Set<Edge> result = new HashSet<>();
//        while (!priorityQueue.isEmpty()) {
//            Edge edge = priorityQueue.poll();
//            if (!unionFind.isSameSet(edge.from, edge.to)) {
//                result.add(edge);
//                unionFind.union(edge.from, edge.to);
//            }
//        }
//        return result;
//    }
//    public static Set<Edge>kruskalTest(Graph graph){
//        GraphMap graphMap=new GraphMap((ArrayList<Node>) graph.nodes.values());
//        PriorityQueue<Edge>priorityQueue=new PriorityQueue<>((o1, o2) -> o1.weight-o2.weight);
//        for (Edge edge : graph.) {
//            priorityQueue.add(edge);
//        }
//        Set<Edge>result=new HashSet<>();
//        while (!priorityQueue.isEmpty()){
//            Edge edge = priorityQueue.poll();
//            if(!graphMap.isSameSet(edge.from,edge.to)){
//                result.add(edge);
//                graphMap.Union(edge.from,edge.to);
//            }
//        }
//        return result;
//    }
//}
