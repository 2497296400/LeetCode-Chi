package 每日一题系列.每日一题九月.判定是否互为字符重排;

public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();
        int [] arr=new int[26];
        for (char aChar : chars) {
            arr[aChar-'a']++;
        }
        for (char c : chars1) {
            arr[c-'a']--;
            if(arr[c-'a']<0){
                return false;
            }
        }
        return true;
    }
}
