package 每日一题系列.每日一题二月.得分最高的单词集合;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] w = {"dog", "cat", "dad", "good"};
        char[] c = {'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o' };
        int[] s = {1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(solution.maxScoreWords(w, c, s));
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char letter : letters) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }
        return fun(words, map, score, 0);
    }

    private int fun(String[] words, HashMap<Character, Integer> map, int[] score, int index) {
        if (index == words.length) {
            return 0;
        }
        int cur = getCurScore(words[index], map, score);
        int p1 = 0, p2 = 0;
        if (cur != 0) {
            deleteMap(words[index], map);
            p1 = fun(words, map, score,  index + 1) + cur;
            recoveryMap(words[index], map);
        }
        p2 = fun(words, map, score, index + 1);
        return Math.max(p1, p2);
    }

    private HashMap<Character, Integer> recoveryMap(String word, HashMap<Character, Integer> map) {
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);

        }
        return map;
    }

    private HashMap<Character, Integer> deleteMap(String word, HashMap<Character, Integer> map) {
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            if (map.get(aChar) == 1) {
                map.remove(aChar);
            } else {
                map.put(aChar, map.get(aChar) - 1);

            }
        }
        return map;
    }

    private int getCurScore(String word, HashMap<Character, Integer> map, int[] score) {
        int sum = 0;
        HashMap<Character, Integer> cm = new HashMap<>(map);
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            if (cm.containsKey(aChar)) {
                if (cm.get(aChar) == 1) {
                    cm.remove(aChar);
                } else {
                    cm.put(aChar, cm.get(aChar) - 1);
                }

                sum += score[aChar - 'a'];
            } else {
                return 0;
            }
        }
        return sum;
    }
}

