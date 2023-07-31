package 周赛.三百五十六场.第三题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumString("abc", "bca", "aaa"));
    }

    public String minimumString(String a, String b, String c) {
        List<String> list = Arrays.asList(a, b, c);
        list = getFun(list);
        list.sort((o1, o2) -> {
            if (o1.length() == o2.length()) return o1.compareTo(o2);
            return o1.length() - o2.length();
        });
        return list.get(0);
    }

    private List<String> getFun(List<String> list) {
        String cur = list.get(0);
        String f = list.get(1);
        String s = list.get(2);
        String next = fun(cur, f);
        String nextNext = fun(next, s);
        String preNext = fun(cur, s);
        String preNextNext = fun(preNext, f);
        List<String> asn = new ArrayList<>();
        asn.add(nextNext.length() > preNextNext.length() ? preNextNext : nextNext);
        cur = list.get(1);
        f = list.get(2);
        s = list.get(0);
        next = fun(cur, f);
        nextNext = fun(next, s);
        preNext = fun(cur, s);
        preNextNext = fun(preNext, f);
        asn.add(nextNext.length() > preNextNext.length() ? preNextNext : nextNext);
        cur = list.get(2);
        f = list.get(0);
        s = list.get(1);
        next = fun(cur, f);
        nextNext = fun(next, s);
        preNext = fun(cur, s);
        preNextNext = fun(preNext, f);
        asn.add(nextNext.length() > preNextNext.length() ? preNextNext : nextNext);
        return asn;
    }

    private String fun(String cur, String f) {
        if (cur.length() < f.length()) {
            String t = cur;
            cur = f;
            f = t;
        }
        if (cur.contains(f)) {
            return cur;
        }
        int preLen = f.length() - 1;
        int fPreLen = f.length() - 1;
        int lastLen = cur.length() - f.length();
        String ff = f + cur;
        String ss = cur + f;
        int preIndex = -1;
        for (int i = preLen; i >= 0; i--) {
            if (f.charAt(fPreLen) == cur.charAt(i)) {
                preIndex = i;
                String substring = cur.substring(0, preIndex + 1);
                if (f.endsWith(substring)) {
                    ff = f.substring(0, f.length()-substring.length()) + cur;
                    break;
                }
            }
        }
        int sufIndex = -1;
        for (int i = lastLen; i < cur.length(); i++) {
            if (f.charAt(0) == cur.charAt(i)) {
                sufIndex = i;
                String substring = cur.substring(sufIndex);
                if (f.startsWith(substring)) {
                    ss = cur + f.substring(substring.length());
                    break;
                }
            }
        }
        if (ff.length() == ss.length()) {
            return ff.compareTo(ss) < 0 ? ff : ss;
        }
        return ff.length() > ss.length() ? ss : ff;
    }
}