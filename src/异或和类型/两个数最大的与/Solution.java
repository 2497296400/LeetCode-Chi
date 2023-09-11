package 异或和类型.两个数最大的与;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {10, 1, 2, 4, 8, 4, 13,19};
        System.out.println(solution.andMax(arr));
    }


    public int andMax(int[] arr) {
        AndTree andTree = new AndTree();
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            andTree.add(arr[i - 1]);
            res = Math.max(res, andTree.gerMaxAnd(arr[i]));
        }
        return res;
    }
}

class AndTree {
    AndTree[] next;

    public AndTree() {
        next = new AndTree[2];
    }

    public void add(int cur) {
        AndTree curTree = this;
        for (int i = 31; i >= 0; i--) {
            int path = (cur >> i) & 1;
            if (curTree.next[path] == null) {
                curTree.next[path] = new AndTree();
            }
            curTree = curTree.next[path];
        }
    }

    public int gerMaxAnd(int cur) {
        AndTree curTree = this;
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int path = (cur >> i) & 1;
            if (curTree.next[path] != null) {
                res = res | (path << i);
            }
            curTree = curTree.next[path] == null ? curTree.next[path ^ 1] : curTree.next[path];
        }
        return res;
    }
}
