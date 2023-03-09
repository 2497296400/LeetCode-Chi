package 每日一题系列.每日一题八月.求解方程组;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "2x+3x-6x=x+2";
        System.out.println(solution.solveEquation(s));
    }
    public String solveEquation(String equation) {
        int curX = 0;
        int curSum = 0;
        char[] array = equation.toCharArray();
        int flag = 1;
        int index = 0;
        int dataFlag = 1;
        int cur = 0;
        int len = array.length;
        while (index < len) {
            if (array[index] == '=') {
                flag = -1;
                index++;
                dataFlag=1;

                continue;
            }
            if (array[index] == '-') {
                dataFlag = -1;
                index++;
            }else if(array[index]=='+'){
                dataFlag = 1;
                index++;
            }
            int base = 0;
            boolean isf = false;
            while (index < len && Character.isDigit(array[index])) {
                base = base * 10 + array[index] - '0';
                isf = true;
                index++;
            }
            if (index<len&&array[index] == 'x') {
                if (isf) {
                    curX += base*flag*dataFlag;
                }else {
                    curX += flag*dataFlag;
                }
                index++;
            }else {
                curSum+=base*dataFlag*flag;
            }
        }
        if(curX==0){
            return curSum==0?"Infinite solutions":"No solution";
        }
        return "x=" + (-(curSum / curX));
    }
}

