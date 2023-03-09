package 每日一题系列.每日一题七月.奇数值单元格的数目;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {{0, 1}, {1, 1}};
        System.out.println(solution.oddCells(2, 3, nums));
    }

    public int oddCells(int m, int n, int[][] indices) {
        HashMap<Integer, Integer> line = new HashMap<>();
        HashMap<Integer, Integer> row = new HashMap<>();
        for (int i = 0; i < m; i++) {
            row.put(i, 0);
        }
        for (int i = 0; i < n; i++) {
            line.put(i, 0);
        }
        for (int[] index : indices) {
            row.put(index[0], row.get(index[0]) + 1);
            line.put(index[1], line.get(index[1]) + 1);
        }
        int sum = 0;
        for (Integer value : row.values()) {
            if(value%2==0){
                for (Integer integer : line.values()) {
                    if(integer%2!=0){
                        sum+=1;
                    }
                }
            }else {
                int temp=n;
                for (Integer integer : line.values()) {
                    if(integer%2!=0){
                        temp--;
                    }
                }
                sum+=temp;
            }
        }
        return sum;
    }
}
