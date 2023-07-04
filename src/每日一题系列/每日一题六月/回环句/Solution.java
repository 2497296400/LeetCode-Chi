package 每日一题系列.每日一题六月.回环句;

public class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) != words[i].charAt(words[i].length() - 1)) {
                return false;
            }
        }
        System.out.println(words[0].charAt(0));
        System.out.println(words[words.length - 1].charAt(words[words.length - 1].length() - 1));
        
        return words[0].charAt(0) == words[words.length - 1].charAt(words[words.length - 1].length() - 1);
    }
}
