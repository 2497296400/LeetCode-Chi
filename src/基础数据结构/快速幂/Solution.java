package 基础数据结构.快速幂;

import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Random random = new Random();
        for(int i = 0;i< 100;i++){
            int f = random.nextInt(100);
            int s = random.nextInt(10);
            System.out.println(Math.pow(f,s));
            System.out.println(solution.qpow(f,s));
            System.out.println(solution.qpowTow(f, s));
        }
    }
    public  int qpowTow(int n,int p){
        int  ans = 1;
        int t = n;
        while (p!=0){
            if((p&1)==1){
                ans*=t;
            }
            t*=t;
            p>>=1;
        }
        return ans;
    }
    public int qpow(int data, int n) {
        if (n == 0) {
            return 1;
        } else {
            if (n % 2 != 0) {
                return qpow(data, n - 1) * data;
            } else {
                int temp = qpow(data, n / 2);
                return temp * temp;
            }
        }
    }
}
