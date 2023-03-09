package 括号问题.生成所有有效的括号;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        generateParenthesis(5);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> strings = new ArrayList<>();
        String str = "";
        //DFS(strings, str, n, n);
        DFS2(strings, str, 0, 0, n);
        System.out.println(strings);
        return strings;
    }

    private static void DFS2(List<String> strings, String str, int left, int right, int n) {
        if (left == n && right == n) {
            strings.add(str);
            return;
        }
        if(left<right||right>n||left>n){
            return;
        }
        DFS2(strings,str+'(',left+1,right,n);
        DFS2(strings,str+')',left,right+1,n);
    }
    private static void DFS(List<String> strings, String stringBuilder, int left, int rigtt) {
        if (left == 0 && rigtt == 0) {
            strings.add(stringBuilder);
            return;
        }
        if (left == rigtt) {
            DFS(strings, stringBuilder + '(', left - 1, rigtt);
        } else if (left < rigtt) {
            if (left > 0) {
                DFS(strings, stringBuilder + '(', left - 1, rigtt);
                DFS(strings, stringBuilder + ')', left, rigtt - 1);
            }
        }
    }
}