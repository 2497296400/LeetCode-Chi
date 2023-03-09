package 每日一题系列.每日一题九月.重新排列单词间的空格;


import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s ="   hello";
        System.out.println(solution.reorderSpaces(s));
    }

    public String reorderSpaces(String text) {
        char[] chars = text.toCharArray();
        Queue<StringBuilder> stringBuilders = new LinkedList<>();
        int len = 0;
        int index = 0;
        while (index < text.length()) {
            if (chars[index] == ' ') {
                len++;
                index++;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                while (index < text.length() && chars[index] != ' ') {
                    stringBuilder.append(chars[index++]);
                }
                stringBuilders.add(stringBuilder);
            }
        }
        int lastLen = stringBuilders.size();
        StringBuilder stringBuilder = new StringBuilder();
        int curLen = 0;
        if (stringBuilders.size() > 1) {
            curLen = len / (stringBuilders.size() - 1);
        }
        StringBuilder repeat = new StringBuilder();
        repeat.append(" ".repeat(Math.max(0, curLen)));
        while (!stringBuilders.isEmpty()) {
            stringBuilder.append(stringBuilders.poll());
            if (stringBuilders.size() >= 1) {
                stringBuilder.append(repeat);
            }
        }

        int curLast=0;
        if (lastLen == 1) {
             curLast =len ;
        }else if(lastLen>1){
            curLast=len%(lastLen-1);

        }
        StringBuilder repeat1 = new StringBuilder();
        repeat1.append(" ".repeat(Math.max(curLast, 0)));


        stringBuilder.append(repeat1);
        return String.valueOf(stringBuilder);

    }
}
