package 周赛.三百二十四场.添加边使所有节点度数都为偶数;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] e = {{1, 2}, {2, 3}, {3, 4}, {4, 2}, {1, 4}, {2, 5}};
        List<List<Integer>> list = new ArrayList<>();
        for (int[] integers : e) {
            List<Integer> list1 = new ArrayList<>();
            list1.add(integers[0]);
            list1.add(integers[1]);
            list.add(list1);
        }
        System.out.println(solution.isPossible(5, list));

    }

    public boolean isPossible(int n, List<List<Integer>> edges) {
        Set[] sets = new Set[n];

        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet();
        }
        for (List<Integer> edge : edges) {
            int f = edge.get(0) - 1;
            int s = edge.get(1) - 1;
            sets[f].add(s);
            sets[s].add(f);
        }
        int[] cur = new int[n];
        for (int i = 0; i < n; i++) {
            cur[i] = sets[i].size();
        }
        int curSum = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cur[i] % 2 != 0) {
                arrayList.add(i);
            }
        }
        if (arrayList.size() == 0) {
            return true;
        }
        if (arrayList.size() > 4 || (arrayList.size() & 1) == 1) {
            return false;
        }
        if (arrayList.size() == 2) {
            Integer f = arrayList.get(0);
            Integer s = arrayList.get(1);
            if (!sets[f].contains(s)) {
                return true;
            }
            for (int i = 0; i < n; i++) {
                if (i != f && i != s&&!sets[i].contains(f)&&!sets[i].contains(s)){
                    if (sets[i].size() % 2 == 0) {
                        return true;
                    }
                }
            }
        } else if (arrayList.size() == 4) {
            int[] arr = new int[4];
            int len = 0;
            for (Integer integer : arrayList) {
                arr[len++] = integer;
            }
            return toCheck(arr, sets);
        }
        return false;
    }

    private boolean toCheck(int[] arr, Set<Integer>[] sets) {
        if (!sets[arr[0]].contains(arr[1]) && !sets[arr[2]].contains(arr[3])) {
            return true;
        }
        if (!sets[arr[0]].contains(arr[2]) && !sets[arr[1]].contains(arr[3])) {
            return true;
        }
        if (!sets[arr[0]].contains(arr[3]) && !sets[arr[1]].contains(arr[2])) {
            return true;
        }
        return false;
    }
}
