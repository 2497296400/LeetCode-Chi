package 每日一题系列.每日一题十月.重新格式化电话号码;


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "123 4-567";
        System.out.println(solution.reformatNumber(s));
    }

    public String reformatNumber(String number) {
        String replaceAll = number.replaceAll(" ", "");
        String cur = replaceAll.replaceAll("-", "");
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = cur.toCharArray();
        if (chars.length % 3 == 1) {
            for (int i = 0; i < chars.length - 4; i++) {
                stringBuilder.append(chars[i]);
                if ((i + 1) % 3 == 0) {
                    stringBuilder.append("-");
                }
            }
            int curlen = 0;
            for (int i = cur.length() - 4; i < chars.length; i++) {
                stringBuilder.append(chars[i]);
                if ((++curlen) % 2 == 0 && i != chars.length - 1) {
                    stringBuilder.append("-");
                }
            }
        } else {
            for (int i = 0; i < chars.length; i++) {
                stringBuilder.append(chars[i]);
                if ((i + 1) % 3 == 0 && i != chars.length - 1) {
                    stringBuilder.append("-");
                }
            }
        }
        return String.valueOf(stringBuilder);
    }
}
