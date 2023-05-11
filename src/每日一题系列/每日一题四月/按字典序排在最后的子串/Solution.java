package 每日一题系列.每日一题四月.按字典序排在最后的子串;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastSubstring("xxbbxxbx"));
    }

    public String lastSubstring(String s) {
        char[] chars = s.toCharArray();
        char cur = 'a';
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > cur) {
                cur = chars[i];
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < chars.length; ) {
            if (chars[i] == cur) {
                int start = i;
                while (i<chars.length&&chars[start] == chars[i++]) {

                }
                arrayList.add(start);
            }else {
                i++;
                
            }
        }
        if (arrayList.size() == 1) {
            return s.substring(arrayList.get(0));
        }
        Tree tree = new Tree();
        arrayList.add(s.length());
        for (int i = 1; i < arrayList.size(); i++) {
            String pre = s.substring(arrayList.get(i - 1), Math.min(arrayList.get(i)+1,s.length()));
            tree.add(pre, arrayList.get(i - 1));
        }
        return s.substring(tree.query());
    }

    class Tree {
        int curIndex;
        Tree next[];

        public Tree() {
            this.next = new Tree[26];
        }

        public void add(String s, int index) {
            char[] chars = s.toCharArray();
            Tree tree = this;
            for (int i = 0; i < chars.length; i++) {
                int c = chars[i] - 'a';
                if (tree.next[c] == null) {
                    tree.next[c] = new Tree();
                    tree.next[c].curIndex = index;
                }
                tree = tree.next[c];
            }
        }

        public int query() {
            Tree tree = this;
            int ans = Integer.MAX_VALUE;
            boolean isF = true;
            
            while (true) {
                boolean isa = false;
                for (int i = 25; i >= 0; i--) {
                    if (tree.next[i] != null) {
                        ans = tree.next[i].curIndex;
                        tree = tree.next[i];
                        isa = true;
                        break;
                    }
                }
                if (!isa) {
                    break;
                }
            }
            return ans;
        }
    }
}
