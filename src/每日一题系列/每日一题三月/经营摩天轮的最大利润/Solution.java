package 每日一题系列.每日一题三月.经营摩天轮的最大利润;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int []arr={8,3};
        System.out.println(solution.minOperationsMaxProfit(arr, 5, 6));
    }
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int curCost = 0;
        int numberOfTurns = 0;
        int waitPeo = 0;
        int maxMnonny=0;
        for (int i = 0; i < customers.length; i++) {
            waitPeo += customers[i];
            if(waitPeo>4){
                curCost+=4*boardingCost-runningCost;
                waitPeo-=4;
            }else {
                curCost+=waitPeo*boardingCost-runningCost;
                waitPeo=0;
            }
            maxMnonny=Math.max(maxMnonny,curCost);
        }
        while (waitPeo>0){
            if(waitPeo>4){
                curCost+=4*boardingCost-runningCost;
                waitPeo-=4;
            }else {
                curCost+=waitPeo*boardingCost-runningCost;
                waitPeo=0;
            }
            maxMnonny=Math.max(maxMnonny,curCost);
        }
        if(maxMnonny<0){
            return -1;
        }
         waitPeo = 0;
        curCost = 0;
        for (int i = 0; i < customers.length; i++) {
            waitPeo += customers[i];
            if(waitPeo>4){
                curCost+=4*boardingCost-runningCost;
                waitPeo-=4;
            }else {
                curCost+=waitPeo*boardingCost-runningCost;
                waitPeo=0;
            }
            numberOfTurns++;
            if(curCost==maxMnonny){
                return numberOfTurns;
            }
        }
        while (waitPeo>0){
            if(waitPeo>4){
                curCost+=4*boardingCost-runningCost;
                waitPeo-=4;
            }else {
                curCost+=waitPeo*boardingCost-runningCost;
                waitPeo=0;
            }
            numberOfTurns++;
            if(curCost==maxMnonny){
                return numberOfTurns;
            }
        }
        return curCost>0?curCost:-1;
    }
}
