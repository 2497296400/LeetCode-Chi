package 每日一题系列.每日一题九月.灯泡开关Ⅱ;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    HashSet<boolean[]> set = new HashSet<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i < 12; i++) {
            for (int j = 1; j < 12; j++) {
                System.out.println(i + " " + j + " " + solution.flipLights(i, j));
                System.out.println("******************");
            }
        }
    }

    public int flipLights(int n, int presses) {

//        if (presses == 0) {
//            return 1;
//        }
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 2;
//        }
//        if (n == 2) {
//            return presses == 1 ? 3 : 4;
//        }
//        if (presses == 1) {
//            return 4;
//        }
//        if (presses == 2) {
//            return 7;
//        }
//        return 8;

        HashSet<String> set = new HashSet<>();
        int[] flag = new int[n];
        Arrays.fill(flag, 1);
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        HashSet<String> strings = new HashSet<>();
        fun(presses, 0, set, flag);
         fun2(presses, 0, strings, cur);
        System.out.println(set);
        System.out.println("------------");
        System.out.println(strings);
        return set.size();
    }

    private void fun(int presses, int index, HashSet<String> set, int[] flag) {
        if (presses == 0) {
            String code = getCode(flag);
            if (!set.contains(code)) {
                set.add((code));
            }
            return;
        }
        fun(presses - 1, index + 1, set, getCode1(flag));
        fun(presses - 1, index + 1, set, getCode2(flag));
        fun(presses - 1, index + 1, set, getCode3(flag));
        fun(presses - 1, index + 1, set, getCode4(flag));

    }

    private void fun2(int presses, int index, HashSet<String> set, int[] flag) {
        if (presses == 0) {
            String code = getCode(flag);
            if (!set.contains(code)) {
                set.add((code));
            }
            return;
        }
        fun2(presses - 1, index + 1, set, get1(flag));
        fun2(presses - 1, index + 1, set, get2(flag));
        fun2(presses - 1, index + 1, set, get3(flag));
        fun2(presses - 1, index + 1, set, get4(flag));
    }

    private int[] getCode4(int[] flag) {
        int[] ans = new int[flag.length];
        for (int i = 0; i < flag.length; i++) {
            if (i % 3 == 0)
                ans[i] = flag[i] ^ 1;
            else
                ans[i] = flag[i];
        }
        return ans;
    }

    private int[] getCode3(int[] flag) {
        int[] ans = new int[flag.length];
        for (int i = 0; i < flag.length; i++) {
            if (i % 2 == 0)
                ans[i] = flag[i] ^ 1;
            else
                ans[i] = flag[i];

        }
        return ans;
    }

    private int[] getCode2(int[] flag) {
        int[] ans = new int[flag.length];
        for (int i = 0; i < flag.length; i++) {
            if (i % 2 != 0)
                ans[i] = flag[i] ^ 1;
            else
                ans[i] = flag[i];
        }
        return ans;
    }

    private int[] getCode1(int[] flag) {
        int[] ans = new int[flag.length];
        for (int i = 0; i < flag.length; i++) {
            ans[i] = flag[i] ^ 1;
        }
        return ans;
    }

    private String getCode(int[] flag) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int b : flag) {
            String s;
            if (b == 1) {
                s = "1";
            } else {
                s = "0";
            }
            stringBuilder.append(s).append(" ");
        }
        return String.valueOf(stringBuilder);

    }

    private int[] get1(int[] flag) {
        int[] clone = flag.clone();
        for (int i = 0; i < clone.length; i++) {
            clone[i] = clone[i] ^ 1;
        }
        return clone;
    }

    private int[] get2(int[] flag) {
        int[] clone = flag.clone();
        for (int i = 0; i < clone.length; i += 2) {
            clone[i] = clone[i] ^ 1;
        }
        return clone;
    }

    private int[] get3(int[] flag) {
        int[] clone = flag.clone();
        for (int i = 1; i < clone.length; i += 2) {
            clone[i] = clone[i] ^ 1;
        }
        return clone;
    }

    private int[] get4(int[] flag) {
        int[] clone = flag.clone();
        for (int i = 0; i < clone.length; i *= 3) {
            clone[i] = clone[i] ^ 1;
            if (i == 0) {
                i = 1;
            }
        }
        return clone;
    }
}

