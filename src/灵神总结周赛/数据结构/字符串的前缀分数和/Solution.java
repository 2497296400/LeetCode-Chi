package 灵神总结周赛.数据结构.字符串的前缀分数和;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String [] rr ={"abc","ab","bc","b"};
        System.out.println(Arrays.toString(solution.sumPrefixScores(rr)));
    }
    public int[] sumPrefixScores(String[] words) {
        Tire tire = new Tire();
        for (String word : words) {
            tire.add(word);
        }
        int[] ans = new int[words.length];
        int len = 0;
        for (String word : words) {
            ans[len++] = tire.query(word);
        }
        return ans;
    }

    class Tire {
        Tire[] next;
        int sum;

        public Tire() {
            next = new Tire[26];
            sum = 0;
        }

        public void add(String s) {
            char[] chars = s.toCharArray();
            Tire root = this;
            for (char aChar : chars) {
                int index = aChar - 'a';
                if (root.next[index] == null) {
                    root.next[index] = new Tire();
                }
                root = root.next[index];
                root.sum++;
            }
        }

        public int query(String s) {
            char[] chars = s.toCharArray();
            int asn = 0;
            Tire root = this;
            for (char aChar : chars) {
                int index = aChar - 'a';
                asn += root.next[index].sum;
                root = root.next[index];
            }
            return asn;
        }
    }
}
