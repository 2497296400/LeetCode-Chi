package 周赛.七十三周.映射排序;

import java.util.Arrays;

public class Dome {
    public static void main(String[] args) {
        Solution s=new Solution();
        int []mapping={8,9,4,0,2,1,3,5,7,6};
        int []nums={991,338,38};
        System.out.println(Arrays.toString(s.sortJumbled(mapping, nums)));
    }
}
