package 动态规划问题.三角形最小路径和;


import java.util.ArrayList;
import java.util.List;

public class Dome {
    public static void main(String[] args) {
        Solution s = new Solution();
        Solution01 s01=new Solution01();

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        List<Integer> l4 = new ArrayList<>();
        l1.add(2);
        l2.add(3);
        l2.add(4);
        l3.add(6);
        l3.add(5);
        l3.add(7);
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        lists.add(l4);
        System.out.println(s.minimumTotal(lists));
        System.out.println(s01.minimumTotal(lists));


    }
}
