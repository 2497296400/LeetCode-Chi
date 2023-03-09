package 周赛.三百二十七.第三题;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isItPossible("ab", "abcc"));
    }

    public boolean isItPossible(String word1, String word2) {
        int[] f = new int[26];
        int[] s = new int[26];
        for (char c : word1.toCharArray()) {
            f[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            s[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (f[i] > 0) {
                for (int j = 0; j < 26; j++) {
                    if (s[j]>0&&toCheck(f, s, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean toCheck(int[] fs, int[] ss, int i, int j) {
        int[] fc = fs.clone();
        int[] sc = ss.clone();
        fc[i]--;
        fc[j]++;
        sc[i]++;
        sc[j]--;
        int fsc = 0;
        int ssc = 0;
        for (int c = 0; c < 26; c++) {
            if (fc[c] > 0) {
                fsc++;
            }
            if (sc[c] > 0) {
                ssc++;
            }
        }
        return fsc == ssc;
    }
}
