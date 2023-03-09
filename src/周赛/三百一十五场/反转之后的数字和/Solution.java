package 周赛.三百一十五场.反转之后的数字和;

public class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        if (num == 0) {
            return true;
        }
        for (int i = 1; i <= num; i++) {
            if (i + fun(i) == num) {
                return true;
            }
        }
        return false;
    }

    private Integer fun(int num) {
        int base = 0;
        while (num != 0) {
            base = base * 10 + num % 10;
            num /= 10;
        }
        return base;
    }
}

