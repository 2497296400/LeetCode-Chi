package 周赛.三百一十七.美丽整数的最小增量;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long l=6068060761L;
        System.out.println(solution.makeIntegerBeautiful(l,
               3 ));
    }
    public long makeIntegerBeautiful(long n, int target) {
        int[] arr = new int[13];
        int len = 0;
        while (n != 0) {
            int l = (int) (n % 10);
            n /= 10;
            arr[len++] = l;
        }
        long curSUm = 0;
        for (int i : arr) {
            curSUm += i;
        }
        if (curSUm <= target) {
            return 0;
        }
        long cucuc=1;
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans+= (10 - arr[i])*cucuc;
            cucuc*=10;
            arr[i]=0;
            curSUm = fun(arr, i+1);
            if(curSUm<=target){
                return ans;
            }
        }
        return 0;
    }

    private int fun(int[] arr, int i) {
        for (int cur = i; cur < arr.length; cur++) {
            if (arr[cur]+1==10){
                arr[cur]=0;
            }else {
                arr[cur]++;
                break;
            }
        }
        int sum =0;
        for (int i1 : arr) {
            sum+=i1;
        }
        return sum;
    }
}
