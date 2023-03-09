package 每日一题系列.每日一题十月.无法吃午餐的学生数量;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 1, 1, 0, 0, 1};
        int[] ints = {1, 0, 0, 0, 1, 1};
        System.out.println(solution.countStudents(arr, ints));
    }

    public int countStudents(int[] students, int[] sandwiches) {
        int[] ans = new int[2];
        for (int student : students) {
            ans[student]++;
        }
        for (int sandwich : sandwiches) {
            if (ans[sandwich] > 0) {
                ans[sandwich]--;
            } else {
                break;
            }
        }
        return ans[0] + ans[1];
    }
}