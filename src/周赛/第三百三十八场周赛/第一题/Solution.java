package 周赛.第三百三十八场周赛.第一题;


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) {
            return k;
        }
        k = k - numOnes;
        if (k < numZeros) {
            return numOnes;
        }
        return numOnes - k;
    }
}
