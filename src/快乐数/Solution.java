package 快乐数;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isHappy(3));
    }
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        int temp = n;
        set.add(temp);
        while (true) {
            if (temp == 1) {
                System.out.println(set);
                return true;
            }
            temp = findPow(temp);
            if (set.contains(temp)) {
                return false;
            }
            set.add(temp);
        }
    }

    private static int findPow(int temp) {
        int sum = 0;
        while (temp != 0) {
            int a=temp%10;
            sum+=a*a;
            temp /= 10;
        }
        System.out.println(sum);
        return sum;
    }
}
