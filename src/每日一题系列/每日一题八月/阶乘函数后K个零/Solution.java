package 每日一题系列.每日一题八月.阶乘函数后K个零;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.preimageSizeFZF(2));
    }
    public int preimageSizeFZF(int k) {
        return  (int ) help(k+1)-help(k);

    }

    private int help(int k) {
        long l=0;
        long r=5L*k;
        while(l<=r){
            long mid=l+(r-l)/2;
            if(zeta(mid)<k){
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return (int) (r+1);
    }

    private long zeta(long mid) {
        int sum=0;
        while (mid>=5){
            sum+=mid/5;
            mid/=5;
        }
        return sum;
    }
}
