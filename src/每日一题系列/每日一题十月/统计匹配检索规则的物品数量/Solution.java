package 每日一题系列.每日一题十月.统计匹配检索规则的物品数量;

import java.util.List;

public class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int flag = 0;
        if (ruleKey.equals("type")) {
            flag = 1;
        } else if (ruleKey.equals("color")) {
            flag = 2;
        } else {
            flag = 3;
        }
        int sum = 0;
        for (List<String> item : items) {
            if (flag == 1) {
                sum += item.get(0).equals(ruleValue) ? 1 : 0;
            } else if (flag == 2) {
                sum += item.get(1).equals(ruleValue) ? 1 : 0;
            } else {
                sum += item.get(2).equals(ruleValue) ? 1 : 0;
            }
        }
        return sum;
    }
}
