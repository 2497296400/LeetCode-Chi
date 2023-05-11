package 回文字符串系列.判断当前区间是否回文;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        boolean[][] booleans = test.intervalPalindrome("abaccba");
        for (boolean[] aBoolean : booleans) {
            System.out.println(Arrays.toString(aBoolean));
        }
    }

    public boolean[][] intervalPalindrome(String s) {
        char[] array = s.toCharArray();
        boolean[][] mp = new boolean[array.length][array.length];
        for (int i = 0; i < mp.length - 1; i++) {
            mp[i][i] = true;
            mp[i][i + 1] = array[i] == array[i + 1];
        }
        int length = array.length;
        mp[length - 1][length - 1] = true;
        for (int i = mp.length - 3; i >= 0; i--) {
            for (int j = i + 2; j < mp.length; j++) {
                mp[i][j] = array[i] == array[j] && mp[i + 1][j - 1];
            }
        }
        return mp;
    }
}
