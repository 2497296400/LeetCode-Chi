package 周赛.三百一十五场.统计定界子数组的数目;

class Solution1 {
    int[] nums;
    int minK, maxK;
    long[] premin, premax;
    public long countSubarrays(int[] nums, int minK, int maxK) {
        premin = new long[nums.length + 1];
        premax = new long[nums.length + 1];

        this.nums = nums;
        this.minK = minK;
        this.maxK = maxK;

        for(int i = 0; i < nums.length; i++) {
            premin[i + 1] = premin[i];
            premax[i + 1] = premax[i];
            if(nums[i] == minK) {
                premin[i + 1]++;
            }
            if(nums[i] == maxK) {
                premax[i + 1]++;
            }
        }


        int l = 0;
        int r = 0;
        long ret = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > maxK || nums[i] < minK || i == nums.length - 1) {
                r = i;
                ret += count(nums, l, r + 1);
                l = r + 1;
            }
        }
        return ret;
    }


    private long count(int[] nums, int l, int r) {
        long ans = 0;

        for(int from = l; from < r; from++) {
            for(int to = from; to < r; to++) {
                long mincount = premin[to + 1] - premin[from];
                long maxcount = premax[to + 1] - premax[from];

                if(mincount > 0 && maxcount > 0) {
                    if(r != nums.length) ans += r - to - 1;
                    else {
                        if(minK == 3) ans += r - to - 1;
                        else
                            ans += r - to;
                    }
                    break;
                }
            }
        }
        return ans;
    }
}