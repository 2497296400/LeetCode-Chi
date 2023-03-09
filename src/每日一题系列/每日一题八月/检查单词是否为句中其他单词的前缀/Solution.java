package 每日一题系列.每日一题八月.检查单词是否为句中其他单词的前缀;

public class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strings = sentence.split(" ");
        for(int i=0;i<strings.length;i++){
            if(strings[i].startsWith(searchWord)){
                return i+1;
            }
        }
        return -1;
    }
}
