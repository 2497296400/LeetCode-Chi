package 每日一题系列.每日一题四月.驼峰式匹配;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        char[] charArray = pattern.toCharArray();
        for (String query : queries) {
            int paLen = 0;
            char[] chars = query.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (!Character.isLowerCase(chars[i])) {
                    if (paLen<charArray.length&&charArray[paLen] != chars[i]) {
                        break;
                    }
                    paLen++;
                }
                if (paLen<charArray.length&&chars[i] == charArray[paLen]) {
                    paLen++;
                }
            }
            ans.add(paLen==charArray.length);
            
        }
        return ans;
    }
}