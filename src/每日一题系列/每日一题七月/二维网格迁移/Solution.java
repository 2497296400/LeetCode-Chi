package 每日一题系列.每日一题七月.二维网格迁移;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>>lists=new ArrayList<>();
        LinkedList<Integer>list=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                list.add(anInt);
            }
        }
        while (k>0){
            Integer integer = list.removeLast();
            list.addFirst(integer);
            k--;
        }
        Iterator<Integer> iterator = list.iterator();
        for(int i=0;i<m;i++){
            List<Integer>integerList=new LinkedList<>();
            for(int j=0;j<n;j++){
                integerList.add(list.removeFirst());
            }
            lists.add(list);
        }
        return lists;
    }
}
