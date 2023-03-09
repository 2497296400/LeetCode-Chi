package 周赛.三百一十九场.温度转换;

public class Solution {
    public double[] convertTemperature(double celsius) {
        double [] ans =new double[2];
        double f= celsius+273.15;
        double s = celsius*1.80+32.00;
        ans[0]=f;
        ans[1]=s;
        return ans;
    }
}
