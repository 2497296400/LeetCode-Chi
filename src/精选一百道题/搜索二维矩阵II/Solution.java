package 精选一百道题.搜索二维矩阵II;

public class Solution {
    public static void main(String[] args) {
        int[][] nums = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(nums, 5));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int cow=matrix.length;
        int line=matrix[0].length;
        int i=0;
        int j=line-1;
        while (i<cow&&j>=0){
            if(matrix[i][j]>target){
                j--;
            }else if(matrix[i][j]<target){
                i++;
            }else {
                return true;
            }
        }
        return false;
    }
}
