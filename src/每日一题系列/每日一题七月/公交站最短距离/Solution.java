package 每日一题系列.每日一题七月.公交站最短距离;

public class Solution {
    public static void main(String[] args) {
        int []ints={1,2,3,4};
        Solution solution = new Solution();
        System.out.println(solution.distanceBetweenBusStops(ints,0,1));
    }
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int stratSum = 0;
        int endSum = 0;
        if(start>destination){
            int temp=start;
            start=destination;
            destination=temp;
        }
        for (int i = start; i <= destination; i++) {
            stratSum += distance[i];
        }
        while (start != destination) {
            if (start == 0) {
                start = distance.length;
            }
            endSum += distance[--start];
        }
        System.out.println(endSum);
        return Math.min(stratSum,endSum);
    }
}
