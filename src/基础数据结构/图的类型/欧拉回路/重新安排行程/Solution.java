package 基础数据结构.图的类型.欧拉回路.重新安排行程;

import java.util.*;

public class Solution {
    Set<String> vis = new HashSet<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] strings = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        List<String[]> list = Arrays.stream(strings).toList();
        List<List<String>> cur = new ArrayList<>();
        for (String[] strings1 : list) {
            List<String> list1 = new ArrayList<>(Arrays.asList(strings1));
            cur.add(list1);
        }
        System.out.println(solution.findItinerary(cur));
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Grap grap = new Grap();
        for (List<String> ticket : tickets) {
            String f = ticket.get(0);
            String s = ticket.get(1);
            Node from = new Node(f);
            Node to = new Node(s);
            if (grap.map.containsKey(f)) {
                from = grap.map.get(f);
            }
            if (grap.map.containsKey(s)) {
                to = grap.map.get(s);
            }
            from.nexts.add(to);
            grap.map.put(f, from);
            grap.map.put(s, to);
        }
        String strat = "JFK";
        Node curNode = grap.map.get(strat);
        List<String> ans = new ArrayList<>();
        Deque<String> queue = new LinkedList<>();
        dfsc(curNode,queue);
      //  dfs("JFK", grap, queue);
        queue.addFirst(curNode.curNode);
        return (List<String>) queue;
    }

    private void dfsc(Node curNode, Deque<String> queue) {
        while (!curNode.nexts.isEmpty()){
            Node nextNode = curNode.nexts.poll();
            dfsc(nextNode, queue);
            queue.add(nextNode.curNode);
        }
    }

    private void dfs(String cur, Grap grap, Deque<String> queue) {
        while (grap.map.containsKey(cur) && grap.map.get(cur).nexts.size() > 0) {
            String cN = grap.map.get(cur).nexts.poll().curNode;
            dfs(cN, grap, queue);
        }
        queue.addFirst(cur);
    }
}

class Grap {
    HashMap<String, Node> map;

    public Grap() {
        map = new HashMap<>();
    }
}

class Node {
    String curNode;
    PriorityQueue<Node> nexts = new PriorityQueue<>((o1, o2) -> {
        return o1.curNode.compareTo(o2.curNode);
    });

    public Node(String curNode) {
        this.curNode = curNode;
    }

}
