package 基础数据结构.并查集.可能的二分法种类并查集;

public class Solution {
    private int[] fa = new int[4010];

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(solution.possibleBipartition(3, arr));
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        for (int i = 0; i <= 2 * n; i++) {
            fa[i] = i;
        }
        for (int[] dislike : dislikes) {
            int f = find(dislike[0]);
            int s = find(dislike[1]);
            if (f == s) {
                return false;
            }
            merge(f + n, s);
            merge(s + n, f);
        }
        return true;
    }

    private int find(int i) {
        if (i != fa[i]) {
            fa[i] = find(fa[i]);
        }
        return fa[i];
    }

    private void merge(int f, int s) {
        fa[find(f)] = s;
    }
}

