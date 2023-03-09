package 每日一题系列.每日一题十一月.最大频率栈;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }
}
class FreqStack {
        private int index;
        private Map<Integer,Integer> map;
        private PriorityQueue<int[]> queue;

        public FreqStack() {
            queue=new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1]==o2[1])
                    {
                        return o2[2]-o1[2];
                    }
                    return o2[1]-o1[1];
                }
            });
            map=new HashMap<>();
            index=0;
        }

        public void push(int x) {
            int cnt=map.getOrDefault(x,0)+1;
            map.put(x,cnt);
            queue.add(new int[]{x,cnt,index++});
        }

        public int pop() {
            int[] poll = queue.poll();
            map.put(poll[0],poll[1]-1);
            return poll[0];
        }
}
