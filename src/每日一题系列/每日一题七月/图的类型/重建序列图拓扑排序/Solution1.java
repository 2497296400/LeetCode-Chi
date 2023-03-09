package 每日一题系列.每日一题七月.图的类型.重建序列图拓扑排序;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        int []nums={4,1,5,2,6,3};
        int [][]se={{4,1,5,2},{4,5,2,6,3}};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.sequenceReconstruction(nums,se));
    }
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        if (sequences.length == 1 && sequences[0].length == 1 && nums.length == 1 && sequences[0][0] == nums[0]) {
            return true;
        }
        Grah grah = new Grah();
        for (int[] sequence : sequences) {
            for (int i = 0; i < sequence.length - 1; i++) {
                int from = sequence[i];
                int to = sequence[i + 1];
                if (!grah.node.containsKey(from)) {
                    grah.node.put(from, new Node(from));
                }
                if (!grah.node.containsKey(to)) {
                    grah.node.put(to, new Node(to));
                }
                Node fromNode = grah.node.get(from);
                Node toNode = grah.node.get(to);
                toNode.in++;
                fromNode.nexts.add(toNode);
            }
        }
        Queue<Node> zeroQ = new LinkedList<>();
        HashMap<Node, Integer> hashMap = new HashMap<>();
        for (Node curNode : grah.node.values()) {
            hashMap.put(curNode, curNode.in);
            if (curNode.in == 0) {
                zeroQ.add(curNode);
            }
            if (zeroQ.size() > 1) {
                return false;
            }
        }
        int pre = 0;
        while (!zeroQ.isEmpty()) {
            Node node = zeroQ.poll();
            if (nums[pre++] != node.value) {
                return false;
            }
            for (Node next : node.nexts) {
                System.out.println(next.value);
                if (--next.in == 0) {
                    zeroQ.add(next);
                }
                if (zeroQ.size() > 1) {
                    return false;
                }
            }
        }
        return pre == nums.length;
    }
}

class Grah {
    HashMap<Integer, Node> node;

    public Grah() {
        node = new HashMap<>();
    }
}

class Node {
    int value;
    int in;
    ArrayList<Node> nexts;

    public Node(int value) {
        this.value = value;
        in = 0;
        nexts = new ArrayList<>();

    }
}