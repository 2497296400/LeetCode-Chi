package 每日一题系列.每日一题一月.替换字符串中的括号内容;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = knowledge.stream().map(o1 -> {
            String key = o1.get(0);
            String value = o1.get(1);
            return new String[]{key, value};
        }).collect(Collectors.toMap(o1 -> o1[0], o1 -> o1[1]));
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                StringBuilder cur = new StringBuilder();
                while (chars[++i] != ')') {
                    cur.append(chars[i]);
                }
                stringBuilder.append(map.getOrDefault(cur.toString(), "?"));
            }
            else  {
                stringBuilder.append(chars[i]);
            }
        }
        return String.valueOf(stringBuilder);
    }
}

