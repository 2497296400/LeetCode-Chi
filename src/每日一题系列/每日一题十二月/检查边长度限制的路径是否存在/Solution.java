package 每日一题系列.每日一题十二月.检查边长度限制的路径是否存在;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ed = {{0, 1, 2}, {1, 2, 4}, {2, 0, 8}, {1, 0, 16}};
        int[][] qe = {{0, 1, 2}, {0, 2, 5}};
        System.out.println(Arrays.toString(solution.distanceLimitedPathsExist(3, ed, qe)));
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Union union = new Union(n);
        Arrays.sort(edgeList, ((o1, o2) -> o1[2] - o2[2]));
        Integer[] index = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, ((o1, o2) -> queries[o1][2] - queries[o2][2]));
        boolean[] ans = new boolean[queries.length];
        int len = 0;
        for (Integer integer : index) {
            while (len < edgeList.length && edgeList[len][2] < queries[integer][2]) {
                union.union(edgeList[len][0], edgeList[len][1]);
                len++;
            }
            ans[integer] = union.find(queries[integer][1]) == union.find(queries[integer][0]);
        }
        return ans;
    }
}

class Union {
    int[] father;
    int[] size;


    public Union(int n) {
        father = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            father[i] = i;
            size[i] = 1;
        }
    }

    public void union(int f, int s) {
        f = find(f);
        s = find(s);
        if (f != s) {
            if (size[f] >= size[s]) {
                father[s] = f;
                size[f] += size[s];
            } else {
                father[f] = s;
                size[s] += size[f];
            }
        }
    }

    public int find(int c) {
        if (father[c] != c) {
            father[c] = find(father[c]);
        }
        return father[c];
    }
}