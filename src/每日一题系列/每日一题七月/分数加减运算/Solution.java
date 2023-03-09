package 每日一题系列.每日一题七月.分数加减运算;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        String s = "1/2";
        Solution solution = new Solution();
        System.out.println(solution.fractionAddition(s));
    }

    public String fractionAddition(String expression) {
        char[] chars = expression.toCharArray();
        Queue<String> queue = new LinkedList<>();
        String s = "";
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 && chars[i] >= '0' && chars[i] <= '9') {
                s += "+";
            } else if (i == 0 && chars[i] == '-') {
                s += chars[i];
                continue;
            }
            if (chars[i] >= '0' && chars[i] <= '9' || chars[i] == '/') {
                s += chars[i];
            } else if (chars[i] == '+' || chars[i] == '-') {
                queue.add(s);
                s = "";
                s += chars[i];
            }
            if (i == chars.length - 1) {
                queue.add(s);
            }
        }
        while (queue.size() > 1) {
            String first = queue.poll();
            String second = queue.poll();
            queue.add(fun(first, second));
        }
        String peek = queue.peek();
        String substring=peek;
        if(peek.startsWith("+")){
             substring = peek.substring(1);
        }
        return substring;
    }

    private String fun(String first, String second) {
        String[] firsts = first.split("/");
        String[] seconds = second.split("/");
        int firstMolecular=Integer.parseInt(firsts[0]);
        int firstDenominator=Integer.parseInt(firsts[1]);
        int secondMolecular=Integer.parseInt(seconds[0]);
        int secondDenominator=Integer.parseInt(seconds[1]);
        int toGetMin=Math.abs(getMin(firstDenominator,secondDenominator));
        int toGetMax=(firstDenominator*secondDenominator)/toGetMin;
        firstMolecular*= toGetMax/firstDenominator;
        secondMolecular*=toGetMax/secondDenominator;
        int ans=firstMolecular+secondMolecular;
        int toGetMinAns=Math.abs(getMin(ans,toGetMax));
        ans/=toGetMinAns;
        toGetMax/=toGetMinAns;
        String f = String.valueOf(ans);
        String s = String.valueOf(toGetMax);
        return f+"/"+s;
    }
    int getMin(int first, int end) {
        return first % end != 0 ? getMin(end, first % end) : end;
    }
}
