package 基础数据结构.字典树.单词替换;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
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

    //    public static String replaceWords(List<String> dictionary, String sentence) {
//        String[] strings = sentence.split(" ");
//        String str="";
//        dictionary.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length()-o2.length();
//            }
//        });
//        for (String string : strings) {
//            String strTemp=string+" ";
//            for (String s : dictionary) {
//                if(string.startsWith(s)){
//                    strTemp=s+" ";
//                    break;
//                }
//            }
//            str+=strTemp;
//        }
//        String trim = str.trim();
//
//        return trim;
//    }
    //字典树
    public static String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            Trie cur = trie;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                cur.children.putIfAbsent(c, new Trie());
                cur = cur.children.get(c);
            }
            cur.children.put('#', new Trie());
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = findRoot(words[i], trie);
        }
        return String.join(" ", words);
    }
    public static String findRoot(String word, Trie trie) {
        StringBuffer root = new StringBuffer();
        Trie cur = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children.containsKey('#')) {
                return root.toString();
            }
            if (!cur.children.containsKey(c)) {
                return word;
            }
            root.append(c);
            cur = cur.children.get(c);
        }
        return root.toString();
    }
    static class Trie {
        Map<Character, Trie> children;
        public Trie() {
            children = new HashMap<Character, Trie>();
        }
    }
}
