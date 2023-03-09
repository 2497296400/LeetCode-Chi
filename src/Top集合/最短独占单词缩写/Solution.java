package Top集合.最短独占单词缩写;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int curMin = Integer.MAX_VALUE;
    String curAns;

    public static void main(String[] args) {
        Solution solution = new Solution();
        String target = "appleds";
        String[] dic = {"appdads","apdeeds"};
        System.out.println(solution.TheShortestWordIsExclusive(target, dic));
    }

    public String TheShortestWordIsExclusive(String target, String[] dictionaries) {
        char[] curTarget = target.toCharArray();
        List<Integer> curL = new ArrayList<>();
        for (String dictionary : dictionaries) {
            if (dictionary.length() == target.length()) {
                curL.add(toFun(dictionary, target));
            }
        }
        dfs(curTarget, 0, 0, curL);
        return curAns;

    }

    private void dfs(char[] curTarget, int index, int status, List<Integer> curL) {
        if (index < curTarget.length) {
            dfs(curTarget, index + 1, status, curL);
            dfs(curTarget, index + 1, status | (1 << index), curL);
        } else {
            if (getLen(status) < curMin && checkSequence(status, curL)) {
                curMin = getLen(status);
                curAns = getCurAns(curTarget, status);
            }
        }
    }

    private boolean checkSequence(int status, List<Integer> curL) {
        for (Integer integer : curL) {
            if ((status & integer) == 0) {
                return false;
            }
        }
        return true;
    }

    private String getCurAns(char[] curTarget, int status) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < curTarget.length;) {
            int cur = 0;
            while (i < curTarget.length && (status >> i & 1) != 1) {
                cur++;
                i++;
            }
            if (cur != 0) {
                stringBuilder.append(cur);
            } else {
                stringBuilder.append(curTarget[i++]);
            }
        }
        System.out.println(stringBuilder);
        return String.valueOf(stringBuilder);

    }

    private int getLen(int status) {
        int sum = 0;
        for (int i = 0; i <= 21; i++) {
            if ((status >> i & 1) == 1) {
                sum++;
            }
        }
        return sum;
    }

    private Integer toFun(String dictionary, String target) {
        int curData = 0;
        char[] chars = target.toCharArray();
        char[] chars1 = dictionary.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars1[i]) {
                curData |= 1 << i;
            }
        }
        return curData;
    }
}
