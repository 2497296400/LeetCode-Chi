package 每日一题系列.每日一题十二月.构成特定和需要添加的最少元素;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        Arrays.fill(arr, 1);
        List<Integer> arrayList = Arrays.asList(arr);
        Map<Integer, Integer> collect = Arrays.stream(arr).
                filter((num) -> num == 1).
                map((num) -> {
                    return num + 10;
                }).collect(Collectors.toMap((num) -> num+1, (num) -> num,(num1,num2)->num1));

        for (Map.Entry<Integer, Integer> entry : collect.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        arrayList.forEach(System.out::println);
    }

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum != goal) {
            long abs = Math.abs(goal - sum);
            if (abs % limit != 0) {
                return (int) (abs / limit + 1);
            } else {
                return (int) (abs / limit);
            }
        }
        return 0;
    }
}
