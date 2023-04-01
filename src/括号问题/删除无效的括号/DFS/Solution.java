package 括号问题.删除无效的括号.DFS;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s="()())()";
        System.out.println(solution.removeInvalidParentheses(s));
    }
    List<String> ans = new LinkedList<>();

    public List<String> removeInvalidParentheses(String s) {
        int lr = 0;
        int rr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lr++;
            }
            if (s.charAt(i) == ')' ) {
                if (lr > 0) {
                    lr--;
                }else {
                rr++;
                }
            }
        }
        getAns(ans, lr, rr, s, 0);

        return ans;
    }

    private void getAns(List<String> ans, int lr, int rr, String s, int start) {
        if (lr == rr && lr == 0 && toGerRight(s)) {
            ans.add(s);
        }
        for(int i=start; i<s.length();i++){
            if(i>start&&s.charAt(i)==s.charAt(i-1)) {
                continue;
            }
            if(lr>0&&s.charAt(i)=='('){
                getAns(ans,lr-1,rr,s.substring(0,i)+s.substring(i+1),i);
            }
            if(rr>0&&s.charAt(i)==')'){
                getAns(ans,lr,rr-1,s.substring(0,i)+s.substring(i+1),i);
            }
        }
    }

    public boolean toGerRight(String s) {
        int curSum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                curSum++;
            } else if (s.charAt(i) == ')') {
                curSum--;
            }
            if (curSum < 0) {
                return false;
            }
        }
        return curSum == 0;
    }
}