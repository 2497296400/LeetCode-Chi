package 灵神总结周赛.动态规划.不重叠回文子字符串的最大数目;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        中心扩散法 中心扩散法 = new 中心扩散法();
        System.out.println(中心扩散法.maxPalindromes("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"
                , 2));

    }

    public int maxPalindromes(String s, int k) {
        char[] chars = s.toCharArray();
        boolean[][] isP = new boolean[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length() - 1; i++) {
            isP[i][i] = true;
            isP[i][i + 1] = chars[i] == chars[i + 1];
        }
        isP[chars.length - 1][chars.length - 1] = true;
        for (int i = chars.length - 3; i >= 0; i--) {
            for (int j = i + 2; j < chars.length; j++) {
                isP[i][j] = chars[i] == chars[j] && isP[i + 1][j - 1];
            }
        }
        List<Data> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + k - 1; j < chars.length; j++) {
             /*   if (i == 1998 && j == 1999) {
                    System.out.println(isD[i][j]);
                }*/
                if (isP[i][j]) {
                    list.add(new Data(i, j));
                    break;
                }
            }
        }
        list.sort(Comparator.comparingInt(o -> o.nextIndex));
        int sum = 0;
        int curIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).preIndex >= curIndex) {
                sum++;
                //System.out.println(list.get(i).preIndex + " " + list.get(i).nextIndex);
                curIndex = list.get(i).nextIndex + 1;
            }
        }
        return sum;
    }

    class Data {
        int preIndex;
        int nextIndex;

        public Data(int preIndex, int nextIndex) {
            this.preIndex = preIndex;
            this.nextIndex = nextIndex;
        }
    }
}