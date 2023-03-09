package 每日一题系列.每日一题九月.能否连接形成数组;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] p = {{78},{4,64},{91}};
        int[] arr = {91,4,64,78};
        System.out.println(solution.canFormArray(arr, p));
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        for (int[] piece : pieces) {
            if (!isfun(piece, arr)) {
                return false;
            }
        }
        return true;
    }

    private boolean isfun(int[] piece, int[] arr) {
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == piece[len]) {
                while (len < piece.length && arr[i] == piece[len]) {
                    i++;
                    len++;
                }
                return len == piece.length;

            }
        }
        return false;
    }
}
