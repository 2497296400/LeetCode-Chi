package 每日一题系列.每日一题七月.质数排列;

public class Solution {
    public static void main(String[] args) {
        int n=5;
        System.out.println(numPrimeArrangements(5));

    }
    public static int numPrimeArrangements(int n) {
        int sum=isFind(n);
        int noNum=n-sum;
        return (int) (factorial(sum)*factorial(noNum)%1000000007);
    }

    public static long factorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            res %= 1000000007;
        }
        return res;
    }


    private  static int isFind(int n) {
        int sum=0;
        for(int i=2;i<=n;i++){
            if(isTure(i)){
                sum++;
            }
        }
        return sum;
    }

    private static boolean isTure(int n) {
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
