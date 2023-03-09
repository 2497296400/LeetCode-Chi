package 每日一题系列.每日一题八月.商品折扣后的最终价格;

public class Solution {
    public int[] finalPrices(int[] prices) {
        int []ans=new int[prices.length];
        for(int i=0;i< prices.length;i++){
            ans[i]=prices[i];
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]<ans[i]){
                    ans[i]=ans[i]-prices[j];
                    break;
                }
            }
        }
        return ans;
    }
}
