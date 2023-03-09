package 深度广度遍历问题.字母大小排序;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCasePermutation(String s) {
        int len=s.length();
        List<String> str=new ArrayList<>();
        boolean []usd=new boolean[len];
        StringBuilder sb=new StringBuilder();
        DFS(s,0,str,sb,len);
        return str;
    }
    private void DFS(String s, int idx, List<String> str, StringBuilder sb, int len) {
        if(idx==s.length()){
            str.add(sb.toString());
            return;
        }
        char ch=s.charAt(idx);
        sb.append(ch);
        DFS(s,idx+1,str,sb,len);
        sb.deleteCharAt(sb.length()-1);
        if(Character.isLetter(ch)){
            ch= (char) (ch-'a'>=0?ch-32:ch+32);
            sb.append(ch);
            DFS(s,idx+1,str,sb,len);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
