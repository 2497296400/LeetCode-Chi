package 每日一题系列.每日一题九月.相似度为K的字符串;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        BFS bfs = new BFS();
        String s1 = "abcdeabcdeabcdeabcde";
        String s2 = "aaaabbbbccccddddeeee";
        System.out.println(bfs.kSimilarity(s1, s2));
    }

    public int kSimilarity(String s1, String s2) {
        int ans = 0;
        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s1);
        set.add(s1);
        while (true) {
            int size = queue.size();
            while (size > 0) {
                size--;
                String curS = queue.poll();
                if (curS.equals(s2)) {
                    return ans;
                }
                for (String s : nextLevel(curS, s2)) {
                    if (!set.contains(s)) {
                        set.add(s);
                        queue.add(s);
                    }
                }
            }
            ans++;
        }
    }

    private List<String> nextLevel(String curS, String s2) {
        char[] first = curS.toCharArray();
        char[] second = s2.toCharArray();
        int start = 0;
        while (first[start] == second[start]) {
            start++;
        }
        List<String> cur = new LinkedList<>();
        for (int i = start + 1; i < first.length; i++) {
            if (first[start] == second[i]) {
                swap(first, i, start);
                cur.add(new String(first));
                swap(first, i, start);
            }
        }
        return cur;
    }

    private void swap(char[] c1, int i, int j) {
        char temp = c1[i];
        c1[i] = c1[j];
        c1[j] = temp;

    }
}
