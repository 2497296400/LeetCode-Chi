package Top集合.单词搜索II;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] b = {{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'}};
        String[] strings = {"oath", "pea", "eat", "rain"};
//        char [][] b = {{'a','a'}};
//        String [] st={"aaa"};
        System.out.println(solution.findWords(b, strings));


    }

    public List<String> findWords(char[][] board, String[] words) {
        Tire tire = new Tire();
        for (String word : words) {
            tire.insert(word);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            boolean[][] vis = new boolean[board.length][board[i].length];
            for (int j = 0; j < board[i].length; j++) {
                fun(res, board, i, j, tire, vis);
            }
        }
        return res;
    }

    private void fun(List<String> res, char[][] board, int x, int y, Tire tire, boolean[][] vis) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length || vis[x][y]) {
            return;
        }
        int curInde = board[x][y] - 'a';
        if (tire.next[curInde] == null) {
            return;
        } else {
            tire = tire.next[curInde];
        }
        if (tire.isEnd) {
            tire.isEnd = false;
            res.add(tire.end);
        }
        vis[x][y] = true;
        fun(res, board, x, y + 1, tire, vis);
        fun(res, board, x, y - 1, tire, vis);
        fun(res, board, x + 1, y, tire, vis);
        fun(res, board, x - 1, y, tire, vis);
        vis[x][y] = false;
    }
}

class Tire {
    String end;
    boolean isEnd;
    Tire[] next;

    public Tire() {
        next = new Tire[26];
    }

    public void insert(String s) {
        char[] chars = s.toCharArray();
        Tire root = this;
        for (char aChar : chars) {
            int curChar = aChar - 'a';
            if (root.next[curChar] == null) {
                root.next[curChar] = new Tire();
            }
            root = root.next[curChar];
        }
        root.end = s;
        root.isEnd = true;
    }
}
