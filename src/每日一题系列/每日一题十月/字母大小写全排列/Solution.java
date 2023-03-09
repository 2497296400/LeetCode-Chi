package 每日一题系列.每日一题十月.字母大小写全排列;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toCharArray();
        List<String> asn = new ArrayList<>();
        fun(chars, 0, asn);
        return asn;
    }

    private void fun(char[] chars, int cur, List<String> asn) {
        if (cur == chars.length) {
            asn.add(String.valueOf(chars));
            return;
        }
        if (!Character.isDigit(chars[cur])) {
            tocheck(chars, cur);
            fun(chars, cur + 1, asn);
            tocheck(chars, cur);
            fun(chars, cur + 1, asn);
        } else {
            fun(chars, cur + 1, asn);
        }
    }

    private void tocheck(char[] chars, int cur) {
        if (chars[cur] >= 'a' && chars[cur] <= 'z') {
            int i = chars[cur] - 'a';
            char temp = (char) (i + 'A');
            chars[cur] = temp;
        } else {
            int i = chars[cur] - 'A';
            char temp = (char) (i + 'a');
            chars[cur] = temp;
        }
    }
}
