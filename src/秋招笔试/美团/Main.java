package 秋招笔试.美团;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            treeMap.put(arr[i], i);
        }
        int falg = 0;

        while (!treeMap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = treeMap.lastEntry();
            Integer key = entry.getKey();
            Integer index = entry.getValue();
            int left = index - 1;
            int right = index + 1;
            int leftSum = m;
            int rightSum = m;
            ans[index] = falg == 1 ? 'B' : 'A';
            arr[index] = -1;
            treeMap.remove(key);
            while (left >= 0 && leftSum > 0) {
                if (arr[left] != -1) {
                    ans[left] = falg == 1 ? 'B' : 'A';
                    treeMap.remove(arr[left]);
                    arr[left] = -1;
                    leftSum--;
                }
                left--;
            }
            while (right < n && rightSum > 0) {
                if (arr[right] != -1) {
                    ans[right] = falg == 1 ? 'B' : 'A';
                    treeMap.remove(arr[right]);
                    arr[right] = -1;
                    rightSum--;
                }
                right++;
            }
            falg = falg == 1 ? 0 : 1;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i]);
        }

    }
}