package 每日一题系列.每日一题七月.最低加油次数;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
//优先队列
public class Solution {
    public static void main(String[] args) {
        int[][] stations = {{25, 27}, {36, 187}, {140, 186}, {378, 6}, {492, 202}, {517, 89}, {579, 234}, {673, 86}, {808, 53}, {954, 49}};
        int[][] s = {{25, 25}, {50, 50}};
        System.out.println(minRefuelStops(1000, 83, stations));
    }

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int s = startFuel;
        int curSum = startFuel;
        int index = 0;
        int sum = 0;
        int Temp = target;
        while (index < stations.length) {
            while (index < stations.length && curSum >= stations[index][0]) {
                integerPriorityQueue.add(stations[index++][1]);
            }
            if (integerPriorityQueue.size() == 0 && startFuel < target) {
                return -1;
            }
            if (startFuel >= target) {
                return sum;
            } else {
                target -= startFuel;
                startFuel = 0;
                while (!integerPriorityQueue.isEmpty()) {
                    int cur = integerPriorityQueue.poll();
                    startFuel += cur;
                    sum++;
                    curSum += cur;
                    if (curSum >= Temp || startFuel >= target) {
                        return sum;
                    } else if (index < stations.length - 1 && curSum >= stations[index][0]) {
                        break;
                    }
                }
            }
        }
        return curSum >= Temp ? sum : -1;
    }

    public int minRefuelStops1(int target, int startFuel, int[][] stations) {
        int fuel = startFuel, dist = 0, times = 0, i = 0, len = stations.length;
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (; ; ) {
            dist += fuel;// 直接清空油箱，冲到底
            if (dist >= target) return times;// 到终点了
            while (i < len && stations[i][0] <= dist) {// 把路过的加油包收集起来
                queue.offer(stations[i++][1]);
            }
            if (queue.isEmpty()) return -1;// 没加油包了
            fuel = queue.poll();// 取最大的一个加油包加上
            ++times;
        }
    }
}
