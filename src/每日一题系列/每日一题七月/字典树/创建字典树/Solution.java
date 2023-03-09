package 每日一题系列.每日一题七月.字典树.创建字典树;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static class Tire {
        public int pass;
        public int end;
        Tire[] nexts;
        public Tire() {
            pass = 0;
            end = 0;
            nexts = new Tire[26];
        }
        private void insert(Tire tire, String word) {
            if (word == null) {
                return;
            }
            char[] chars = word.toCharArray();
            Tire root = tire;
            root.pass++;
            int index = 0;
            for (char aChar : chars) {
                index = aChar - 'a';
                if (root.nexts[index] == null) {
                    root.nexts[index] = new Tire();
                }
                root = root.nexts[index];
                root.pass++;
            }
            root.end++;
        }

        public int search(String word, Tire tire) {
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            Tire node = tire;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] != null && node.nexts[index].end != 0) {
                    return i;
                }
                if (node.nexts[index] == null) {
                    return -1;
                }
                node = node.nexts[index];
            }
            return -1;
        }
    }

    public static String replaceWords(List<String> dictionary, String sentence) {

        String[] strings = sentence.split(" ");
        Tire tire = new Tire();
        for (String s : dictionary) {
            tire.insert(tire, s);
        }
        for (int i = 0; i < strings.length; i++) {
            strings[i] = findRoot(tire, strings[i]);
        }

        return String.join(" ", strings);

    }

    private static String findRoot(Tire tire, String string) {
        Tire root = tire;
        StringBuilder sb = new StringBuilder();
        int temp = tire.search(string, tire);
        sb.append(string, 0, temp == -1 ? string.length() : temp+1);
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        String s = "the cattle was rattled by the battery";
        List<String> strings = new ArrayList<>();
        String s1 = "cat";
        String s2 = "bat";
        String s3 = "rat";
        strings.add(s1);
        strings.add(s2);
        strings.add(s3);
        System.out.println(replaceWords(strings, s));
    }
}