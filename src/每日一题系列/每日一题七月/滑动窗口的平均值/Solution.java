package 每日一题系列.每日一题七月.滑动窗口的平均值;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

}
class MovingAverage {

        Deque<Integer>deque;
        int curSUm;
        int size;

    public MovingAverage(int size) {
        this.size=size;
        curSUm=0;
        deque=new LinkedList<>();
    }

    public double next(int val) {
        if(deque.size()<size){
            deque.add(val);
            curSUm+=val;
            return (double)curSUm/deque.size();
        }else {
            Integer oldFirst = deque.pollFirst();
            deque.add(val);
            curSUm-=oldFirst;
            curSUm+=val;
            return (double) curSUm/size;
        }
    }
}