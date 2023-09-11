package 灵神总结周赛.模拟.数字转汉字;

public class Solution {
    public static void main(String[] args) {
        String[] f = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String[] f2 = {"十", "百", "千", "万", "十", "百", "千", "亿", "十", "亿", "千"};
        StringBuilder sb = new StringBuilder();
        String ss = "5000051";
        int len = ss.length();
        for (int i = 0; i < len; i++) {
            int cur = ss.charAt(i) - '0';
            if (cur != 0 && i != len - 1) {
                sb.append(f[cur]).append(f2[len - i - 2]);
            } else {
                if (sb.charAt(sb.length() - 1) != '零' || cur != 0) {
                    sb.append(f[cur]);
                }
                if (sb.charAt(sb.length() - 1) == '零' && (len - 2 - i < 0 || f2[len - i - 2].equals("万") || f2[len - i - 2].equals("亿"))) {
                    sb.deleteCharAt(sb.length() - 1);
                    if (len - 2 - i >= 0) {
                        sb.append(f2[len - i - 2]);
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
