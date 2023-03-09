package Top集合.整数反转;

public class Solution {
    public int reverse(int x) {
        long ans;
        ans = 0;
        if (x == 0 ) {
            return 0;
        }
        int falg = x > 0 ? 1 : -1;
        int base = 1;
        x = Math.abs(x);
        while (x != 0) {
            int cur = x % 10;
            x /= 10;
            ans = ans * 10 + cur;
        }
        if(ans>Integer.MAX_VALUE||ans<Integer.MIN_VALUE){
            return 0;
        }
        return (int) (ans * falg);
    }
}
