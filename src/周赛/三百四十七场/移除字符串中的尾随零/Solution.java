package 周赛.三百四十七场.移除字符串中的尾随零;

public class Solution {
    public String removeTrailingZeros(String num) {
        int end = num.length()-1;
        while(end>0&&num.charAt(end)=='0') end--;
        return num.substring(0,end+1);
    }
}
