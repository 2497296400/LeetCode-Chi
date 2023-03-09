package 周赛.第306场周赛.边积分最高的节点;

import java.nio.file.Path;
import java.util.*;
//注意数组越界

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] edg = {1, 0};
        System.out.println(solution.edgeScore(edg));
    }

    public int edgeScore(int[] edges) {
        Grap grap = new Grap();
//     for(int i=0;i<edges.length;i++){
//         if(!grap.node.containsKey(i)){
//             grap.node.put(i, new Node(i));
//         }
//         if(!grap.node.containsKey(edges[i])){
//             grap.node.put(edges[i],new Node(edges[i]));
//         }
//         Node first = grap.node.get(i);
//         Node second = grap.node.get(edges[i]);
//        second.nexts.add(first);
//     }
        TreeMap<Integer, Long> treeMap = new TreeMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (!treeMap.containsKey(edges[i])) {
                treeMap.put(edges[i], (long) i);
            } else {
                treeMap.put(edges[i], treeMap.get(edges[i]) + i);
            }
        }
        int curIndex = 0;
        Long curMax = 0L;
        for (Map.Entry<Integer, Long> entry : treeMap.entrySet()) {
            if (entry.getValue() > curMax) {
                curIndex = entry.getKey();
                curMax = entry.getValue();
            }
        }
     return curIndex;
}

    private int getMax(Grap grap) {
        ArrayList<MaxNode> arrayList = new ArrayList<>();
        for (Integer integer : grap.node.keySet()) {
            int curMax = 0;
            Node curNode = grap.node.get(integer);
            for (Node next : curNode.nexts) {
                curMax += next.var;
            }
            arrayList.add(new MaxNode(curNode, curMax));
        }
        arrayList.sort(new Comparator<MaxNode>() {
            @Override
            public int compare(MaxNode o1, MaxNode o2) {
                return o2.max - o1.max == 0 ? o1.node.var - o2.node.var : o2.max - o1.max;
            }
        });
        return arrayList.get(0).node.var;
    }
}

class MaxNode {
    Node node;
    int max;

    public MaxNode(Node node, int max) {
        this.node = node;
        this.max = max;
    }
}

class Grap {
    HashMap<Integer, Node> node;

    public Grap() {
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
