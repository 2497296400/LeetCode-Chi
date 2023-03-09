package 每日一题系列.每日一题八月.重新格式化字符串;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public String reformat(String s) {
        Deque<Character> data = new LinkedList<>();
        Deque<Character> curChar = new LinkedList<>();
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                data.add(c);
            } else {
                curChar.add(c);
            }
        }
        if (Math.abs(data.size() - curChar.size()) > 1) {
            return "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            while (!data.isEmpty() && !curChar.isEmpty()) {
                if(data.size()>curChar.size()){
                    stringBuilder.append(data.pop()).append(curChar.pop());
                }else if(data.size()<curChar.size()){
                    stringBuilder.append(curChar.pop()).append(data.pop());
                }else {
                    stringBuilder.append(data.pop()).append(curChar.pop());
                }
            }
            if (!data.isEmpty() || !curChar.isEmpty()) {
                stringBuilder.append(data.isEmpty() ? curChar.pop() : data.pop());
            }
            return String.valueOf(stringBuilder);

        }
    }
}
