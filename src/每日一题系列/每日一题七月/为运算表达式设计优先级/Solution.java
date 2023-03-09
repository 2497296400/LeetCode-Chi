package 每日一题系列.每日一题七月.为运算表达式设计优先级;

import java.util.*;

public class Solution {
    static HashMap<String, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        String s = "20-1-1";
        System.out.println(diffWaysToCompute(s));
        System.out.println(map.values());
    }
    public static List<Integer> diffWaysToCompute(String expression) {
        if (map.containsKey(expression)) {
            return map.get(expression);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1, expression.length()));
                for (Integer l : left) {
                    for (Integer r : right) {
                        if (c == '+') {
                            list.add(l + r);

                        }
                        if (c == '-') {
                            list.add(l - r);
                        }
                        if (c == '*') {
                            list.add(l * r);
                        }
                    }
                }
            }
        }
        if (list.size() == 0) {
            list.add(Integer.valueOf(expression));
        }
        map.put(expression, list);
        return list;
    }
}

