package 周赛.三百三十四场.第一题;

public class Solution {
    public static void main(String[] args) {
        
        Solution solution = new Solution();
        int[] ar = {10,2,2,3};
        int[] sr = {3,8,4,5};
        System.out.println(solution.isWinner(ar, sr));
    }

    public int isWinner(int[] player1, int[] player2) {
        int f = 0;
        for (int i = 0; i < player1.length; i++) {
            if (i < 2) {
                if (i == 0) {
                    f += player1[i];
                } else if (i == 1) {
                    if (player1[0] == 10) {
                        f += 2 * player1[i];
                    } else {
                        f += player1[i];
                    }
                }
            } else {
                if (player1[i - 2] == 10 || player1[i - 1] == 10) {
                    f += 2 * player1[i];
                } else {
                    f += player1[i];
                }
            }
        }
        int s = 0;
        for (int i = 0; i < player2.length; i++) {
            if (i < 2) {
                if (i == 0) {
                    s += player2[i];
                } else if (i == 1) {
                    if (player2[0] == 10) {
                        s += 2 * player2[i];
                    } else {
                        s+= player2[i];
                    }
                }
            } else {
                if (player2[i - 2] == 10 || player2[i - 1] == 10) {
                    s += 2 * player2[i];
                } else {
                    s += player2[i];
                }
            }
        }
        System.out.println(f + " ---" + s);
        if (f == s) {
            return 0;
        }
        return f > s ? 1 : 2;
    }
}
