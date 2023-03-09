package 每日一题系列.每日一题十月.三等分;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        System.out.println(Arrays.toString(solution.threeEqualParts(arr)));
    }

    public int[] threeEqualParts(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            if (i == 1) {
                sum++;
            }
        }
        int[] ans = new int[2];
        if (sum % 3 != 0) {
            return new int[]{-1, -1};
        }
        if (sum == 0) {
            return new int[]{0, arr.length - 1};
        }
        int curSum = sum / 3;
        ArrayList<Integer> f = new ArrayList<>();
        ArrayList<Integer> s = new ArrayList<>();
        ArrayList<Integer> e = new ArrayList<>();
        int strat = 0;
        int end = 0;
        Stack<Integer> endS = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1 && f.isEmpty()) {
                int cur = 0;
                while (cur < curSum) {
                    if (arr[i] == 1) {
                        cur++;
                    }
                    f.add(arr[i++] == 1 ? 1 : 0);
                }
                strat = i;
            } else if (!f.isEmpty()) {
                break;
            }
        }
        for (int i = arr.length - 1; i > 0; i--) {
            if (endS.isEmpty()) {
                int cur = 0;
                while (cur < curSum) {
                    if (arr[i] == 1) {
                        cur++;
                    }
                    endS.add(arr[i--] == 1 ? 1 : 0);
                }
            } else {
                break;
            }
        }
        if (f.size() < endS.size()) {
            int cursum=endS.size() - f.size();
            for (int i = 0; i < cursum; i++) {
                if (arr[strat++] == 1) {
                    return new int[]{-1, -1};
                } else {
                    f.add(0);
                }
            }
        }
        int curS = strat;
        for (int i = 0; i < f.size(); i++) {
            if (!f.get(i).equals(endS.pop())) {
                return new int[]{-1, -1};
            }
        }
        for (int i = curS; i < arr.length && s.isEmpty(); i++) {
            if (arr[i] == 1) {
                int cur = 0;
                while (cur < curSum) {
                    if (arr[i] == 1) {
                        cur++;
                    }
                    s.add(arr[i++] == 1 ? 1 : 0);
                }
                end = i;
            }
        }
        if (s.size() < f.size()) {
            int cursum= f.size() - s.size();
            for (int i = 0; i < cursum; i++) {
                if (arr[end++] == 1) {
                    return new int[]{-1, -1};
                } else {
                    s.add(0);
                }
            }
        }
        if (f.equals(s)) {
            return new int[]{strat - 1, end};
        }
        return new int[]{-1, -1};
    }
}
