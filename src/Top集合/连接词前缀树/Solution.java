package Top集合.连接词前缀树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        System.out.println(solution.findAllConcatenatedWordsInADict(strings));
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(words, (str1, str2) -> str1.length() - str2.length());
        Tire tire = new Tire();
        for (String word : words) {
            char[] chars = word.toCharArray();
            if (find(tire, 0, chars)) {
                ans.add(word);
            } else {
                tire.insert(chars);
            }
        }
        return ans;
    }

    private boolean find(Tire tire, int i, char[] chars) {
        boolean ans = false;
        if (i == chars.length) {
           return true;
        }
            Tire node = tire;
            for (int end = i; end < chars.length; end++) {
                int index = chars[end] - 'a';
                if (node.next[index] == null) {
                    break;
                }
                node = node.next[index];
                if (node.isEnd && find(tire, end + 1, chars)) {
                    return true;
                }
            }
        return false;
    }
}

class Tire {
    boolean isEnd;
    Tire[] next;

    public Tire() {
        next = new Tire[26];
        isEnd = false;
    }

    public void insert(char[] str) {
        Tire root = this;
        for (int i = 0; i < str.length; i++) {
            int index = str[i] - 'a';
            if (root.next[index] == null) {
                root.next[index] = new Tire();
            }
            root = root.next[index];
        }
        root.isEnd = true;
    }

}
