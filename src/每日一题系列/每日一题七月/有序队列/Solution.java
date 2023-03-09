package 每日一题系列.每日一题七月.有序队列;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    StringBuilder stringBuilder;
    ArrayList<StringBuilder>arrayList=new ArrayList<>();
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.orderlyQueue("cba", 1));
    }
    public String orderlyQueue(String s, int k) {
        stringBuilder =new StringBuilder(s);
        if(k==1){
            int len=0;
           while (len<s.length()){
               fun(k);
               len++;
           }

            String string = s;
            for (StringBuilder builder : arrayList) {
                String toString = builder.toString();
                string=toString.compareTo(string)>0?string:toString;
            }
            return string;
        }else {
            String string = stringBuilder.toString();
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            stringBuilder = new StringBuilder(String.valueOf(chars));
        }
        return String.valueOf(stringBuilder);

    }

    private void fun(int k) {
            char curChar = stringBuilder.charAt(0);
            stringBuilder.deleteCharAt(0);
            stringBuilder.append(curChar);
            arrayList.add(new StringBuilder(stringBuilder));}
}