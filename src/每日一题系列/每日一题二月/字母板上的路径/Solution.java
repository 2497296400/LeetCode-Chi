package 每日一题系列.每日一题二月.字母板上的路径;

public class Solution {
    int curMin = Integer.MAX_VALUE;
    String ans;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.alphabetBoardPath("leet"));
    }

    public String alphabetBoardPath(String target) {
        int curX = 0;
        int curY = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : target.toCharArray()) {
            int rx = (c - 'a') / 5;
            int ry = (c - 'a') % 5;
            if (ry < curY) {
                stringBuffer.append("L".repeat(curY - ry));
            }
            if (rx < curX) {
                stringBuffer.append("U".repeat(curX - rx));
            }
            if (ry > curY) {
                stringBuffer.append("R".repeat(ry - curY));
            }
            if (rx > curX) {
                stringBuffer.append("D".repeat(rx - curX));
            }
            curX=rx;
            curY=ry;
            stringBuffer.append("!");
        }
        return stringBuffer.toString();
    }
}
