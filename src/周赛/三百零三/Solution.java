package 周赛.三百零三;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public char repeatedCharacter(String s) {
        Set<Character>set=new HashSet<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if(!set.add(aChar)){
                return aChar;
            }
        }
        return chars[0];

    }
}
