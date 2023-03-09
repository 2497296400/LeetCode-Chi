package 异或和类型.统计异或值在范围内的数对有多少;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 4, 2, 7};
        System.out.println(solution.countPairs(arr, 2, 6));
    }

    public int countPairs(int[] nums, int low, int high) {
        TireNode cur = new TireNode();
        int ans = 0;
        for(int i = 0;i< nums.length;i++){
            ans+=cur.getMaxXor(nums[i],high)-cur.getMaxXor(nums[i],low-1);
            cur.add(nums[i]);
        }
        return ans;
    }
}

class TireNode {
    TireNode[] next;
    int curSum;

    public TireNode() {
        next = new TireNode[2];
        curSum = 0;
    }

    public int getMaxXor(int num, int target) {
        TireNode root = this;
        int curSum = 0;
        for (int i = 30; i >= 0; i--) {
            int nk = (num >> i) & 1;
            int tk = (target >> i) & 1;
            if (tk == 1) {
                if (root.next[nk] != null) {
                    curSum += root.next[nk].curSum;
                }
                if(root.next[nk^1]==null){
                    return curSum;
                }
                root= root.next[nk^1];
            }else {
                if(root.next[nk]==null){
                    return curSum;
                }
                root= root.next[nk];
            }
        }
        curSum+=root.curSum;
        return curSum;
    }

    public void add(int num) {
        TireNode root = this;
        for (int i = 30; i >= 0; i--) {
            int curIndex = (num >> i) & 1;
            if (root.next[curIndex] == null) {
                root.next[curIndex] = new TireNode();
            }
            root = root.next[curIndex];
            root.curSum++;
        }
    }
}
