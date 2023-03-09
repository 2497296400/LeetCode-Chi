package 每日一题系列.每日一题八月.特殊的二进制序列没有看;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public String makeLargestSpecial(String s) {
        int count = 0, pre = 0, n = s.length();
        if (n == 0) {
            return "";
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '1') {
                count++;
            } else {
                count--;
                if (count == 0) {
                    list.add("1" + makeLargestSpecial(s.substring(pre + 1, i)) + "0");
                    pre = i + 1;
                }
            }
        }
        Collections.sort(list);
        String ans = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            ans += list.get(i);
        }
        return ans;
    }
}
