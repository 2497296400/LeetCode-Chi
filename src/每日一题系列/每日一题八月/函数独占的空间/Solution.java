package 每日一题系列.每日一题八月.函数独占的空间;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = Arrays.asList("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7");
        System.out.println(Arrays.toString(solution.exclusiveTime(2, list)));
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        int []ans=new int[n];
        Stack<Data> stack = new Stack<>();
        String s = logs.get(0);
        String[] strings = s.split(":");
        Data pre=new Data(Integer.parseInt(strings[0]),strings[1],Integer.parseInt(strings[0]));
        stack.push(pre);
        for(int i=1;i<logs.size();i++){
            String log=logs.get(i);
            String[] split = log.split(":");
            Data cur=new Data(Integer.parseInt(split[0]),split[1],Integer.parseInt(split[2]));
            if("end".equals(cur.state)){
                Data data = stack.pop();
                ans[cur.curData]+=cur.curIndex-data.curIndex+1;
                if(!stack.isEmpty()){
                    Data peek = stack.pop();
                    peek.curIndex=cur.curIndex+1;
                    stack.push(peek);
                }
                continue;
            }
            if(!stack.isEmpty()&&stack.peek().state.equals(cur.state)){
                ans[stack.peek().curData]+=cur.curIndex- stack.peek().curIndex;
                Data peek = stack.pop();
                peek.curIndex=cur.curIndex+1;
                stack.push(peek);
            }
            stack.push(cur);
        }
        return ans;
    }
}
class Data {
    int curData;

    String state;
    int curIndex;

    public Data(int curData, String state, int curIndex) {
        this.curData = curData;
        this.state = state;
        this.curIndex = curIndex;
    }
}
