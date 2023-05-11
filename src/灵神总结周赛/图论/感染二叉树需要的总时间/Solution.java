package 灵神总结周赛.图论.感染二叉树需要的总时间;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;
import 力扣工具类.树的节点.TreeNode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = LeetCodeUtils.GetTreeNode(new Integer[]{1});
        Solution solution = new Solution();
        System.out.println(solution.amountOfTime(treeNode, 1));
    }

    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer, ArrayList<Integer>> g = new HashMap<>();
        dfs(root, g, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        Set<Integer> vis = new HashSet<>();
        if (g.size() == 0) {
            return 0;
        }
        vis.add(start);
        int ans = -1;
        while (!queue.isEmpty()) {
            ans++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Integer curNode = queue.poll();
                for (Integer next : g.get(curNode)) {
                    if (!vis.contains(next)) {
                        vis.add(next);
                        queue.add(next);
                    }
                }
            }
        }
        return ans;
    }

    private void dfs(TreeNode root, HashMap<Integer, ArrayList<Integer>> g, int parent) {
        if (root == null) {
            return;
        }
        if (parent != -1) {
            if (g.containsKey(parent)) {
                g.get(parent).add(root.val);
            } else {
                ArrayList<Integer> c = new ArrayList<>();
                c.add(root.val);
                g.put(parent, c);
            }
            if (g.containsKey(root.val)) {
                g.get(root.val).add(parent);
            } else {
                ArrayList<Integer> c = new ArrayList<>();
                c.add(parent);
                g.put(root.val, c);
            }
        }
        dfs(root.left, g, root.val);
        dfs(root.right, g, root.val);
    }
}
