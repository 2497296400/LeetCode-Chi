package 周赛.三百一十九场.逐层排序二叉树所需的最少操作数目;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;
import 力扣工具类.树的节点.TreeNode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer[] arr = {1, 4, 3, 7, 6, 8, 5, null, null, null, null, 9, null, 10};
        TreeNode treeNode = LeetCodeUtils.GetTreeNode(arr);
        System.out.println(solution.minimumOperations(treeNode));

    }

    public int minimumOperations(TreeNode root) {
        List<List<Integer>> list = getC(root);
        int sum = 0;
        for (int i = 1; i < list.size(); i++) {
            sum += toFun(list.get(i));
        }
        return sum;
    }

    private int toFun(List<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] temp = new int[list.size()];
        int len = 0;
        for (Integer integer : list) {
            temp[len++] = integer;
        }
        return toGetSum(temp);
    }

    private int toGetSum(int[] temp) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : temp) {
            set.add(i);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int curlen = 0;
        for (Integer integer : set) {
            map.put(integer, curlen++);
        }
        int[] cur = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            cur[i] = map.get(temp[i]);
        }
        int sum = cur.length;
        boolean[] vis = new boolean[cur.length];
        for (int i = 0; i < cur.length; i++) {
            if (vis[i]) continue;
            while (!vis[i]) {
                vis[i] = true;
                i = cur[i];
            }
            sum--;
        }
        return sum;
    }

    private void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }

    public List<List<Integer>> getC(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> deep = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                deep.add(curNode.val);
                if (curNode.left != null) {

                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);

                }
            }
            list.add(deep);
        }
        return list;
    }
}