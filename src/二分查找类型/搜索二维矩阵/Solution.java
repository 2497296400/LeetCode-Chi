package 二分查找类型.搜索二维矩阵;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix[0].length - 1;
        int flag = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (target == matrix[i][matrix[0].length - 1]) {
                return true;
            }
            if (target < matrix[i][right]) {
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (matrix[i][mid] == target) {
                        return true;
                    } else if (target < matrix[i][mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                break;
            }
        }
        return false;
    }
}