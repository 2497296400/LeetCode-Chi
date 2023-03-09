package 每日一题系列.每日一题七月.魔法字典;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    class MagicDictionary {
        Map<String,Integer> set ;
        public MagicDictionary() {
       set=new HashMap<>();
        }

        public void buildDict(String[] dictionary) {
            for (String s : dictionary) {
                set.put(s,s.length());
            }
        }
        public boolean search(String searchWord) {
         if(!set.containsValue(searchWord.length())){
             return false;
         }
            for (Map.Entry<String, Integer> entry : set.entrySet()) {
                if(entry.getValue()==searchWord.length()){
                    String key = entry.getKey();
                    int sum=0;
                    char[] chars = key.toCharArray();
                    char[] array = searchWord.toCharArray();
                    for(int i=0;i<chars.length;i++){
                        if(chars[i]!=array[i]){
                            sum++;
                        }
                    }
                    if(sum==1){
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
