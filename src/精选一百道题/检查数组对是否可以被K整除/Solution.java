package 精选一百道题.检查数组对是否可以被K整除;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, -3, 3, -4};
        System.out.println(canArrange(nums, 3));
        System.out.println(-2 % 3);
    }

    public static boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int temp : arr) {
            hashMap.put((temp % k + k) % k, hashMap.getOrDefault((temp % k + k) % k, 0) + 1);
        }
        System.out.println(hashMap);
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (key > 0 && hashMap.getOrDefault(k - key, 0) != value) {
                return false;
            }
        }
        return hashMap.getOrDefault(0, 0) % 2 == 0;
    }

    public static boolean canArrange2(int[] arr, int k) {
        int len = arr.length;
        if (len <= 1) {
            return false;
        }
        int[] num = new int[k];
        for (int i : arr) {
            num[(i % k + k) % k]++;
        }
        for (int i = 1; i <= k / 2; i++) {
            if (num[i] != num[k - i]) {
                return false;
            }
        }
        return num[0] % 2 == 0;
    }
}
