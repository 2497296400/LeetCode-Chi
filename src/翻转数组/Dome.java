package 翻转数组;

import java.util.Arrays;

public class Dome
{
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] num={1,2,3,4,5,6,7};
        int k=3;
        s.rotate(num,k);
        System.out.println(Arrays.toString(num));
    }
}
    