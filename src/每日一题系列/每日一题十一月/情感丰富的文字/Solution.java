package 每日一题系列.每日一题十一月.情感丰富的文字;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "zzzzzyyyyy";
        String[] c = {"zzyy","zy","zyy"};
        System.out.println(solution.expressiveWords(s, c));
    }

    public int expressiveWords(String s, String[] words) {
        ArrayList<Data> arrayList = new ArrayList<>();
        char[] sc = s.toCharArray();
        int curMax = 0;
        for (int i = 0; i < sc.length; i++) {
            int curSum = 1;
            while (i < sc.length-1 && sc[i] == sc[i + 1]) {
                curSum++;
                i++;
            }
            arrayList.add(new Data(sc[i], curSum));
            curMax = Math.max(curMax, curSum);
        }
        if (curMax < 3) {
            return 0;
        }
        int ans = 0;
        for (String word : words) {
            if (word.length() >= arrayList.size() && fun(word, arrayList)) {
                ans++;
            }
        }
        return ans;

    }

    private boolean fun(String word, ArrayList<Data> arrayList) {
        char[] sc = word.toCharArray();
        ArrayList<Data> curA = new ArrayList<>();
        for (int i = 0; i < sc.length; i++) {
            int curSum = 1;
            while (i < sc.length-1 && sc[i] == sc[i + 1]) {
                curSum++;
                i++;
            }
            curA.add(new Data(sc[i], curSum));
        }
        if (curA.size() != arrayList.size()) {
            return false;
        } else {
            boolean t = false;
            for (int i = 0; i < curA.size(); i++) {
                if (!curA.get(i).c.equals(arrayList.get(i).c)) {
                    return false;
                }
                if (curA.get(i).sum < arrayList.get(i).sum && arrayList.get(i).sum < 3) {
                    return false;
                }
                if (curA.get(i).sum > arrayList.get(i).sum) {
                    return false;
                }
                if (curA.get(i).sum < arrayList.get(i).sum && arrayList.get(i).sum >= 3) {
                    t = true;
                }
            }
        }
        return true;
    }

    public class Data {
        Character c;
        int sum;

        public Data(Character c, int sum) {
            this.c = c;
            this.sum = sum;
        }
    }
}