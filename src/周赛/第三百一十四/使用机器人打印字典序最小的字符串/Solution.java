package 周赛.第三百一十四.使用机器人打印字典序最小的字符串;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //"bdevfziy"
        String s = "bydizfve";
        System.out.println(solution.robotWithString(s));
    }

    public String robotWithString(String s) {
        char[] tmep = new char[s.length()+1];
        Arrays.fill(tmep, (char) ('z' + 1));
        char[] chars = s.toCharArray();
        tmep[s.length() - 1] = chars[chars.length - 1];
        for (int i = s.length() - 1; i > 0; i--) {
            tmep[i - 1] = (char) Math.min(tmep[i], chars[i - 1]);
        }
        Stack<Character> ans = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            ans.push(chars[i]);
            while (!ans.isEmpty()&&ans.peek()<=tmep[i+1]){
                stringBuilder.append(ans.pop());
            }
        }while (!ans.isEmpty()){
            stringBuilder.append(ans.pop());
        }
        return String.valueOf(stringBuilder);
    }
}
