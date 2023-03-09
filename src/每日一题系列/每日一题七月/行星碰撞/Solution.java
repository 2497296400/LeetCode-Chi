package 每日一题系列.每日一题七月.行星碰撞;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {5,10,-5};
        System.out.println(Arrays.toString(asteroidCollision(nums)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        fun(asteroids, 0, asteroids.length - 1);
        int len = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int asteroid : asteroids) {
            if (asteroid != 0) {
                arrayList.add(asteroid);
            }
        }
        len = arrayList.size();
        int[] ints = new int[len];
        len = 0;
        for (Integer integer : arrayList) {
            ints[len++] = integer;
        }
        return ints;
    }

    private static void fun(int[] asteroids, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            fun(asteroids, left, mid);
            fun(asteroids, mid + 1, right);
            process(asteroids, left, mid, right);
        }
    }

    private static void process(int[] asteroids, int left, int mid, int right) {
        int i = mid;
        int j = mid + 1;
        while (i >= left && j <= right) {
            if (asteroids[j] < 0 && asteroids[i] > 0) {
                if (asteroids[i] + asteroids[j] > 0) {
                    asteroids[j++] = 0;
                } else if (asteroids[i] + asteroids[j] < 0) {
                    asteroids[i--] = 0;
                } else {
                    asteroids[i--] = 0;
                    asteroids[j++] = 0;
                }
            }else if(asteroids[j]>=0) {
                j++;
            }else if(asteroids[i]<=0){
                i--;
            }
        }
    }
}
