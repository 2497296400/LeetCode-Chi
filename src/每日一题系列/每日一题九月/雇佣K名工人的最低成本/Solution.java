package 每日一题系列.每日一题九月.雇佣K名工人的最低成本;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] qua = {3, 1, 10, 10, 1};
        int[] wag = {4, 8, 2, 2, 7};
        System.out.println(solution.mincostToHireWorkers(qua, wag, 3));
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        ArrayList<Data> arrayList = new ArrayList<>();
        for (int i = 0; i < quality.length; i++) {
            arrayList.add(new Data(quality[i], (double)wage[i] / quality[i]));
        }
        arrayList.sort(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return Double.compare(o1.value, o2.value);
            }
        });
        double qsum = 0;
        double res = Double.MAX_VALUE;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (Data data : arrayList) {
            qsum += data.curIndex;
            pq.add((double) -data.curIndex);
            if (pq.size() > k) {
                qsum += pq.poll();
            }
            if (pq.size() == k) {
                res = Math.min(res, qsum * data.value);
            }
        }
        return res;
    }
}

class Data {
    int curIndex;
    double value;

    public Data(int curIndex, double value) {
        this.curIndex = curIndex;
        this.value = value;
    }
}
