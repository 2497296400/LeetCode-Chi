package 基础数据结构.单调栈.最大矩形;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        //   [["1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","0"],["1","1","1","1","1","1","1","0"],["1","1","1","1","1","0","0","0"],["0","1","1","1","1","0","0","0"]]
        char[][] matirx1 = {{'1', '1', '1', '1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '1', '0', '0', '0'}, {'0', '1', '1', '1', '1', '0', '0', '0'}};
        //System.out.println(maximalRectangle1(matirx1));
        ArrayList<Integer>arrayList=new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
       while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            if("".equals(s)){
                break;
            }
            int x = s.charAt(0) - '0';
            int y = s.charAt(2) - '0';
            char[][] maxtirx = new char[x][y];
            for (int i = 0; i < x; i++) {
                String s1 = scanner.nextLine();
                s1.replaceAll(" ", "");
                for (int j = 0; j < y; j++) {
                    maxtirx[i][j] = s1.charAt(j);
                }
            }
            arrayList.add(maximalRectangle1(maxtirx));

        }
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
    }

    //暴力解法
    public static int maximalRectangle(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    max = Math.max(max, findRectangle(matrix, i, j));
                }
            }
        }
        return max;
    }

    private static int findRectangle(char[][] matrix, int x, int y) {
        int max = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = x; i < matrix.length && matrix[i][y] == '1'; i++) {
            queue.add(findwithd(matrix, i, y));
            max = Math.max(max, queue.peek() * queue.size());
        }
        return max;
    }

    private static Integer findwithd(char[][] matrix, int x, int y) {
        int i = y;
        for (; i < matrix[0].length && matrix[x][i] == '1'; i++) {
        }
        return i - y;

    }

    //单调栈
    public static int maximalRectangle1(char[][] matrix) {
        int max = 0;
        int[][] nums = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] != '1') {
                    sum = 0;
                } else if (matrix[i][j] == '1') {
                    nums[i][j] = ++sum;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, tangle(nums[i]));
        }
        return max;
    }
        private static int tangle(int[] num) {
            int ans = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < num.length; i++) {
                while (!stack.isEmpty() && num[stack.peek()] >= num[i]) {
                    int tal = num[stack.pop()];
                    int wight;
                    if (stack.isEmpty()) {
                        wight = i;
                    } else {
                        wight = i - stack.peek() - 1;
                    }
                    ans = Math.max(ans, tal * wight);
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                int tal = num[stack.pop()];
                int wight;
                if (stack.isEmpty()) {
                    wight = num.length;
                } else {
                    wight = num.length - stack.peek() - 1;
                }
                ans = Math.max(ans, tal * wight);
            }
            return ans;
        }
}
