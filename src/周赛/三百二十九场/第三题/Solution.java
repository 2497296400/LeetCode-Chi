package 周赛.三百二十九场.第三题;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "11";
        String string = "00";
        System.out.println(solution.makeStringsEqual(s, string));
    }

    public boolean makeStringsEqual(String s, String target) {
        char[] tc = target.toCharArray();
        char[] sc = s.toCharArray();
        int tpreOne = Integer.MAX_VALUE;
        for (int i = 0; i < tc.length; i++) {
            if (tc[i] == '1') {
                tpreOne = i;
                break;
            }
        }
        int tlasOne = -1;
        for (int i = target.length() - 1; i >= 0; i--) {
            if(tc[i]=='1'){
                tlasOne=i;
                break;
            }
        }
        int lasOne = -1;
        for (int i = target.length() - 1; i >= 0; i--) {
            if (sc[i] == '1') {
                lasOne = i;

                break;
            }

        }
        int sum = 0;
        for (int i = 0; i < tc.length; i++) {
            char a = sc[i];
            char b = tc[i];
            if (a == b) {
                continue;
            } else {
                if (i < lasOne || i > tpreOne) {
                    continue;
                }
            }
         sum++;
        }
        return sum%2==0;
    }
}
