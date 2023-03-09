package 每日一题系列.每日一题七月.TreeMap一系列应用.我的日程安排表I;

import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(47, 50));
        System.out.println(myCalendar.book(33, 41));
        System.out.println(myCalendar.book(39, 45));
        System.out.println(myCalendar.book(33, 42));
        System.out.println(myCalendar.book(25, 32));
        System.out.println(myCalendar.book(26, 35));
        System.out.println(myCalendar.book(19, 25));
        System.out.println(myCalendar.book(3, 8));
        System.out.println(myCalendar.book(8, 13));
        System.out.println(myCalendar.book(18, 27));
    }
}

class MyCalendar {
    private TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
        map.put(-1 , -1);
        map.put(Integer.MAX_VALUE,Integer.MAX_VALUE);

    }

    public boolean book(int start, int end) {
         Integer maxData = map.ceilingKey(start);
         Integer minData = map.floorKey(start);
         if(start<map.get(minData)||end>maxData){
             return false;
         }
         map.put(start,end);
         return true;
    }
}
