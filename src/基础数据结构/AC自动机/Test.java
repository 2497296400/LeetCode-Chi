package 基础数据结构.AC自动机;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        ACAutomain acAutomain = new ACAutomain();
        acAutomain.insert("abc");
        acAutomain.insert("bc");
        acAutomain.insert("e");
        acAutomain.insert("bbbb");
        acAutomain.insert("sdas");
        acAutomain.build();
        System.out.println(acAutomain.contains("abcabcefgsadasdcasdasc"));
    }

    public static class Node {
        Node fail;
        Node[] nexts;
        String end;
        boolean endUse;

        public Node() {
            fail = null;
            nexts = new Node[26];
            end = null;
            endUse = false;
        }
    }

    public static class ACAutomain {
        private Node root;

        public ACAutomain() {
            root = new Node();
        }

        public void insert(String s) {
            char[] chars = s.toCharArray();
            Node cur = root;
            for (char aChar : chars) {
                int index = aChar - 'a';
                if (cur.nexts[index] == null) {
                    cur.nexts[index] = new Node();
                }
                cur = cur.nexts[index];
            }
            cur.end = s;
        }

        public void build() {
            Node cur;
            Node cfail;
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                cur = queue.poll();
                for (int i = 0; i < 26; i++) {
                    if (cur.nexts[i] != null) {
                        cur.nexts[i].fail = root;
                        cfail = cur.fail;
                        while (cfail != null) {
                            if (cfail.nexts[i] != null) {
                                cur.nexts[i].fail = cfail.nexts[i];
                                break;
                            }
                            cfail = cfail.fail;
                        }
                        queue.add(cur.nexts[i]);
                    }
                }
            }
        }

        public List<String> contains(String s) {
            char[] chars = s.toCharArray();
            Node cur = root;
            Node find;
            List<String> ans = new LinkedList<>();
            for (char aChar : chars) {
                int index = aChar - 'a';
                while (cur != root && cur.nexts[index] == null) {
                    cur = cur.fail;
                }
                cur = cur.nexts[index] == null ? root : cur.nexts[index];
                find = cur;
                while (find != null) {
                    if (find.endUse) {
                        break;
                    } else if (find.end != null) {
                        ans.add(find.end);
                        find.endUse = true;

                    }
                    find = find.fail;
                }
            }
            return ans;

        }
    }
}
