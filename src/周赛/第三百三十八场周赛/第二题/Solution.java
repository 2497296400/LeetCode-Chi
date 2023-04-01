package 周赛.第三百三十八场周赛.第二题;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.primeSubOperation(new int[]{11,2,10,15,19}));
    }

    int N = 1001;

    public boolean primeSubOperation(int[] nums) {
        int[] arr = extracted();
        int preLast = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= preLast) {
                preLast = toCheck(nums[i], preLast, arr);
                if (preLast <=0) {
                    return false;
                }
            }
            preLast= nums[i];
            
        }
        return true;
    }

    private int toCheck(int num, int preLast, int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (num - arr[i] < preLast) {
                return num - arr[i];
            }
        }
        return -1;
    }

    private int[] extracted() {
        boolean[] vis = new boolean[N];
        int[] arr = new int[N];
        int count = 0;
        for (int i = 2; i < N; i++) {
            if (!vis[i]) {
                arr[++count] = i;
            }
            for (int j = 1; j <= count && arr[j] * i < N; j++) {
                vis[arr[j] * i] = true;
                if (i % arr[j] == 0) {
                    break;
                }
            }
        }
        return arr;
    }
}
