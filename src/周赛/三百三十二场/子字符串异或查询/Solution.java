package 周赛.三百三十二场.子字符串异或查询;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "111010110";
        int[][] q = {{4, 2}, {3, 3}};
        System.out.println(Arrays.deepToString(solution.substringXorQueries(s, q)));
    }

    public int[][] substringXorQueries(String s, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = queries[i][0] ^ queries[i][1];
        }
        char[] chars = s.toCharArray();
        HashMap<Integer, int[]> map = new HashMap<>();
        map.put(0, new int[]{s.indexOf("0"), s.indexOf("0")});
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                int curMax = Math.min(chars.length, i + 31), curData = 0;
                for (int j = i; j < curMax; j++) {
                    curData = (curData << 1 )+ (chars[j] - '0');
                    map.putIfAbsent(curData, new int[]{i, j});
                }
            }
        }

        int[][] curAns = new int[queries.length][2];
        for (int i = 0; i < ans.length; i++) {
            curAns[i] = map.getOrDefault(ans[i], new int[]{-1, -1});
        }
        return curAns;
    }
}
