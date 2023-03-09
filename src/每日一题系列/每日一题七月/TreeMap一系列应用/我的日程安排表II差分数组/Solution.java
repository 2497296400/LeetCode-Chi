package 每日一题系列.每日一题七月.TreeMap一系列应用.我的日程安排表II差分数组;

import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        MyCalendarTwo myCalendar = new MyCalendarTwo();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(50, 60));
        System.out.println(myCalendar.book(10, 40));
        System.out.println(myCalendar.book(5, 15));
        System.out.println(myCalendar.book(5, 10));
        System.out.println(myCalendar.book(25, 55));
//        System.out.println( myCalendar.book(19,25));
//        System.out.println( myCalendar.book(3,8));
//        System.out.println( myCalendar.book(8,13));
//        System.out.println( myCalendar.book(18,27));
    }
}

class MyCalendarTwo {
    TreeMap<Integer, Integer> map;

    public MyCalendarTwo() {

        map = new TreeMap<>();
    }
    public boolean book(int start, int end) {
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);
        int time=0;
        for (Integer value : map.values()) {
            time+=value;
            if(time>=3){
                map.put(start,map.get(start)-1);
                map.put(end,map.get(end)+1);
                return false;
            }
        }
        return true;
    }
}