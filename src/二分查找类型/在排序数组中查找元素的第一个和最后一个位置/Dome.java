package 二分查找类型.在排序数组中查找元素的第一个和最后一个位置;

import java.util.Arrays;

public class Dome {
    public static void main(String[] args) {
        Solution s=new Solution();
        int [] num={5,7,7,8,8,10};
        System.out.println(Arrays.toString(s.searchRange(num, 8)));
    }
}
