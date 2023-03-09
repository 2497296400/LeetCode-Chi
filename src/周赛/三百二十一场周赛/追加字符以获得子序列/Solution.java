package 周赛.三百二十一场周赛.追加字符以获得子序列;

public class Solution {
    public int appendCharacters(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int l = 0;
        for (int i = 0; i < sc.length; i++) {
            if (l<tc.length&&sc[i] == tc[l]) {
                l++;
            }
        }
        return tc.length - l;
    }
}
