package 精选一百道题.每日温度;

import java.util.Stack;

public class dailyTemperaturesTest {
    public int[] dailyTemperatures(int[] temperatures) {
        int []ans=new int[temperatures.length];
        findAns(temperatures,ans);
        return ans;

    }

    private void findAns(int[] temperatures, int[] ans) {
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                int index = stack.pop();
                ans[index] = i-index;
            }
            stack.push(i);
        }
        int len=temperatures.length;
        while (!stack.isEmpty()){
            ans[stack.pop()]=0;
        }
    }
}
