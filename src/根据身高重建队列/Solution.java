package 根据身高重建队列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] pe = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.reconstructQueue1(pe)));
    }

    public int[][] reconstructQueue(int[][] people) {
        int[][] ans = new int[people.length][2];
        int[][] temp = Arrays.copyOf(people, people.length);
        for (int i = 0; i < ans.length; i++) {
            ans[i][0] = -1;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0] == 0 ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        for (int i = 0; i < people.length; i++) {
            int h = people[i][0];
            int c = people[i][1];
            fun(h, c, ans);
        }
        return ans;
    }
    private void fun(int h, int c, int[][] ans) {
        int curlen = 0;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i][0] == -1) {
                curlen++;
            }
            if (curlen == c+1) {
                ans[i][0] = h;
                ans[i][1] = c;
                break;
            }
        }
    }
        public int[][] reconstructQueue1(int[][] people) {
            Arrays.sort(people, new Comparator<int[]>() {
                public int compare(int[] person1, int[] person2) {
                    if (person1[0] != person2[0]) {
                        return person2[0] - person1[0];
                    } else {
                        return person1[1] - person2[1];
                    }
                }
            });
            List<int[]> ans = new ArrayList<int[]>();
            for (int[] person : people) {
                ans.add(person[1], person);
            }
            return ans.toArray(new int[ans.size()][]);
        }
    }