package Top集合.单词方块生成前缀字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[]strings = {"area","lead","wall","lady","ball"};
        System.out.println(solution.WordBox(strings));
    }
    public List<List<String>> WordBox(String[] list) {
        HashMap<String, List<String>> map = new HashMap<>();
        int n = 0;
        for (String s : list) {
            n = s.length();
            for (int i = 0; i < s.length(); i++) {
                String prefix = s.substring(0, i);
                map.putIfAbsent(prefix, new ArrayList<>());
                map.get(prefix).add(s);
            }
        }
        List<String> path = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        process(0, n, map, path, ans);
        return ans;
    }

    private void process(int curIndex, int n, HashMap<String, List<String>> map, List<String> path, List<List<String>> ans) {
        if (curIndex == n) {
            ans.add(new ArrayList<>(path));
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : path) {
                stringBuilder.append(s.charAt(curIndex));
            }
            List<String> list = map.get(stringBuilder.toString());
            if (list != null) {
                for (String s : list) {
                    path.add(s);
                    process(curIndex + 1, n, map, path, ans);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}