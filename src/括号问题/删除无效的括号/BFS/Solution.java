package 括号问题.删除无效的括号.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s="()())()(())))))((((())()()()";
        System.out.println(solution.removeInvalidParentheses(s));
    }
    public List<String> removeInvalidParentheses(String s) {
        Set<String> cur =new HashSet<>();
        cur.add(s);
        List<String>list=new LinkedList<>();
        while (list.isEmpty()){
            for (String s1 : cur) {
                if(toGerRight(s1)){
                    list.add(s1);
                }
            }
            Set<String>next = new HashSet<>();
            for (String s1 : cur) {
                for(int i=0;i<s1.length();i++){
                    if(s1.charAt(i)=='('||s1.charAt(i)==')'){
                        next.add(s1.substring(0,i)+s1.substring(i+1));
                    }
                }
            }
            cur=next;
        }
        return list;

    }
   public boolean toGerRight(String s){
        int curSum=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                curSum++;
            }else if(s.charAt(i)==')'){
                curSum--;
            }
            if(curSum<0){
                return false;
            }
        }
        return curSum==0;
    }
}
