package 基础数据结构.字典树.实现前缀树;

public class Solution {
    public static void main(String[] args) {
        Trie trie=new Trie();

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

    public boolean search(String word) {
        Trie root = this;
        char[] chars = word.toCharArray();
        int len = 0;
        for (char aChar : chars) {
            if (len < chars.length) {
                if (root.nexts[aChar - 'a'] == null) {
                    return false;
                }
                len++;
            }
            root = root.nexts[aChar - 'a'];
        }
        return root.end != 0;
    }

    public boolean startsWith(String prefix) {
        Trie root = this;
        char[] chars = prefix.toCharArray();
        int len = 0;
        for (char aChar : chars) {
            if (len < chars.length) {
                if (root.nexts[aChar - 'a'] == null) {
                    return false;
                }
                len++;
            }
            root = root.nexts[aChar - 'a'];
        }
        return true;
    }
}