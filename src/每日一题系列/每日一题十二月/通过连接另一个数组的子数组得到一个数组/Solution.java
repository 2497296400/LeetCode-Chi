package 每日一题系列.每日一题十二月.通过连接另一个数组的子数组得到一个数组;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] g = {{21, 22, 21, 22, 21, 30}};
        int[] ints = {21, 22, 21, 22, 21, 22, 21, 30};

        System.out.println(solution.canChoose(g, ints));
    }

    public boolean canChoose(int[][] groups, int[] nums) {
        int k = 0;
        for (int i = 0; i < groups.length; i++) {
            k = find(nums, groups[i], k);
            if (k == -1) {
                return false;
            }
            k += groups[i].length;
        }
        return true;
    }

    private int find(int[] nums, int[] group, int curIndex) {
        if (curIndex + group.length > nums.length) {
            return -1;
        }
        int[] next = new int[group.length];
        next[0] = -1;
        int cur = 2;
        int count = 0;
        while (cur < group.length) {
            if (group[cur - 1] == group[count]) {
                next[cur++] = ++count;
            } else if (count !=0) {
                count = next[count];
            } else {
                next[cur++] = 0;
            }
        }
        int gl = 0;
        while (curIndex < nums.length && gl < group.length) {
            if (nums[curIndex] == group[gl]) {
                curIndex++;
                gl++;
            } else if (next[gl] == -1) {
                curIndex++;
            } else {
                gl = next[gl];
            }
        }
        return gl == group.length ? curIndex - gl : -1;
    }
}
