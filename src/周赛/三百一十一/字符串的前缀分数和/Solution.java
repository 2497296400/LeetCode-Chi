package 周赛.三百一十一.字符串的前缀分数和;



import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String []strings={"abc","ab","bc","b"};
        System.out.println(Arrays.toString(solution.sumPrefixScores(strings)));
    }
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int[] ans = new int[words.length];
        int len = 0;
        for (String word : words) {
                ans[len++]= trie.search(word);
        }
        return ans;
    }
}

class Trie {
    Trie[] nexts;
    int pass;
    int end;

    public Trie() {
        nexts = new Trie[26];
        pass = 0;
        end = 0;
    }
    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] chars = word.toCharArray();
        Trie root = this;
        root.pass++;
        for (char aChar : chars) {
            if (root.nexts[aChar - 'a'] == null) {
                root.nexts[aChar - 'a'] = new Trie();
            }
            root.nexts[aChar - 'a'].pass++;
            root = root.nexts[aChar - 'a'];
        }
        root.end++;
    }

    public int search(String word) {
        Trie root = this;
        char[] chars = word.toCharArray();
        int len = 0;
        int curMax= 0;
        for (char aChar : chars) {
            if (len < chars.length) {
                if (root.nexts[aChar - 'a'] == null) {
                    break;
                }
                len++;
            }
            root = root.nexts[aChar - 'a'];
            curMax+=root.pass;
        }
        return curMax;
    }
}
