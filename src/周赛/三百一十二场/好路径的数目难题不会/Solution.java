package 周赛.三百一十二场.好路径的数目难题不会;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,4,3,1,5};
        int[][] ed = {{0, 1}, {0, 2}, {0, 3}, {2, 4}};
        System.out.println(solution.numberOfGoodPaths(arr, ed));
    }
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < vals.length; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
        int[] fa = new int[vals.length];
        int[] size = new int[vals.length];
        Arrays.fill(size, 1);
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        int ans = vals.length;
        int len = 0;
        ArrayList<Data> arrayList = new ArrayList<>();
        for (int val : vals) {
            arrayList.add(new Data(val, len++));
        }
        arrayList.sort(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.val - o2.val;
            }
        });
        for (Data data : arrayList) {
            int val = data.val;
            int index = data.index;
            int fx = find(index, fa);
            for (Integer integer : g.get(index)) {
                int fy = find(integer, fa);
                if (fy == fx || vals[fy] > val) {
                    continue;
                }
                if (vals[fy] == val) {
                    ans += size[fy] * size[fx];
                    size[fx] += size[fy];
                }
                fa[fy] = fx;
            }
        }
        return ans;
    }

    public int find(int x, int[] fa) {
        if (x != fa[x]) {
            fa[x] = find(fa[x], fa);
        }
        return fa[x];
    }
}

class Data {
    int val;
    int index;

    public Data(int val, int index) {
        this.val = val;
        this.index = index;
    }
}
