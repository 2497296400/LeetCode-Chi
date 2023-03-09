package 每日一题系列.每日一题一月.句子相似性III;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "A B C D B B";

        String s2 = "A B B";
        System.out.println(solution.areSentencesSimilar(s1, s2));
    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] f = sentence1.split(" ");
        String[] s = sentence2.split(" ");
        String[] cur;
        if(f.length==s.length){
            return Arrays.equals(f, s);
        }
        if (f.length < s.length) {
            cur = f.clone();
            f = s.clone();
            s = cur;
        }
        int fs = 0;
        int ss = 0;
            while (fs<f.length&&ss<s.length&&f[fs].equals(s[ss])){
                fs++;
                ss++;}
        fs = f.length-(s.length-ss);
        while (fs<f.length&&ss<s.length&&f[fs].equals(s[ss])){
            fs++;
            ss++;
        }
        return  fs==f.length&&ss==s.length;
    }
}
