package 周赛.三百二十六.第三题;

import java.util.HashMap;

public class Solution {
    public int minimumPartition(String s, int k) {
        char[] chars = s.toCharArray();
        HashMap<Data, Integer> set = new HashMap<>();

        return fun(chars, 0, 0, k, set);
    }

    private int fun(char[] chars, int curIndex, long curSum, int k, HashMap<Data, Integer> set) {
        if (curIndex == chars.length && curSum <= k) {
            return 1;
        }
        if (curSum > k) {
            return -1;
        }
        Data cur = new Data(curIndex, curSum);
        if(set.containsKey(cur)){
            return set.get(cur);
        }
        int p1 = fun(chars, curIndex + 1, curSum * 10 + chars[curIndex] - '0', k, set);
        int p2 = fun(chars, curIndex + 1, chars[curIndex] - '0', k, set);
        int ans = 0;
        if (p1 == -1 && p2 == -1) {
            ans = -1;
        } else {
            if (p1 == -1) {
                ans = p2 + 1;
            } else if (p2 == -1) {
                ans = p1;
            } else {
                ans = Math.min(p1, p2 + 1);
            }
        }
        set.put(cur, ans);
        return ans;
    }
}

class Data {
    int curIndex;
    long curSum;

    public Data(int curIndex, long curSum) {
        this.curIndex = curIndex;
        this.curSum = curSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data = (Data) o;

        if (curIndex != data.curIndex) return false;
        return curSum == data.curSum;
    }

    @Override
    public int hashCode() {
        int result = curIndex;
        result = 31 * result + (int) (curSum ^ (curSum >>> 32));
        return result;
    }
}
