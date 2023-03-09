package 每日一题系列.每日一题九月.文件夹操作日志搜集器;

import java.util.Stack;

public class Solution {
    public int minOperations(String[] logs) {
        Stack<String>stack=new Stack<>();
        for (String log : logs) {
            if(!stack.isEmpty()&&("../").equals(log)){
                stack.pop();
            }else if(!("./").equals(log)&&!("../").equals(log)){
                stack.add(log);
            }
        }
        return stack.size();
    }
}
