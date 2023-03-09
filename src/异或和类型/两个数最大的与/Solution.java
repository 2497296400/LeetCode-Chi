package 异或和类型.两个数最大的与;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] arr={15,1,1,2,6,1,1};
        System.out.println(solution.andMax(arr));
    }
    public int andMax(int[] arr) {
        int ans = 0;
        int M = arr.length;
        //从三十位 依次判断当前是否为一 ，然后交换
        for (int bit = 30; bit >= 0; bit--) {
            int cur = 0;
            int tep = M;
            while (cur < M) {
                if ((arr[cur] & (1 << bit)) == 0) {
                    swap(arr, cur, --M);
                } else {
                    cur++;
                }
            }
            if (M == 2) {
                return arr[0] & arr[1];
            }
            if (M < 2) {
                M = tep;
            } else {
                ans |= (1 << bit);
            }
        }
        return ans;

    }

    private void swap(int[] arr, int cur, int i) {
        int temp = arr[cur];
        arr[cur] = arr[i];
        arr[i] = temp;
    }
}
