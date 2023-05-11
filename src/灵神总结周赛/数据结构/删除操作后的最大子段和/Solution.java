package 灵神总结周赛.数据结构.删除操作后的最大子段和;

public class Solution {
    /*
    * 并查集*/
    
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;
        fa = new int[n];
        for (int i = 0; i <= n; i++) {
            fa[i] = i;
        }
        long[] sum = new long[n + 1];
        long[] asn = new long[n];
        for (int i = n - 1; i > 0; i--) {
            int f = removeQueries[i];
            int to = find(f + 1);
            fa[f] = to;
            sum[to] += sum[f] + nums[f];
            asn[i - 1] = Math.max(asn[i], sum[to]);
        }
        return asn;
    }

    int[] fa;

    public int find(int x) {
        if (fa[x] != x) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }
}
