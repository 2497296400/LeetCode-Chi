package 每日一题系列.每日一题十一月.到达终点数字;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 2; i < 200; i++) {
            System.out.println(i + "  =" + solution.reachNumber(i));
        }
    }

    public int reachNumber(int target) {
        int cur = Math.abs(target);
        int sum = 0;
        int i = 1;
        while (true) {
            if ((sum+=i) >= cur && (sum - cur) % 2 == 0) {
                return i;
            }
            i++;
        }
    }
    private int fun(int target, long cur, long index, HashMap<Data, Integer> map) {
        if (cur == target) {
            return 0;
        }
        if (index > 2 * target) {
            return -1;
        }
        Data data = new Data(cur, index);
        if (map.containsKey(data)) {
            return map.get(data);

        }
        int ans = Integer.MAX_VALUE;
        int p1 = fun(target, cur + index, index + 1, map);
        int p2 = fun(target, cur - index, index + 1, map);
        if (p1 != -1 && p2 != -1) {
            ans = Math.min(ans, Math.min(p2, p1) + 1);
        } else if (p2 != -1) {
            ans = Math.min(ans, p2 + 1);
        } else {
            ans = Math.min(ans, p1 + 1);
        }
        map.put(data, ans);
        return ans;
    }

}

class Data {
    long f;
    long s;

    public Data(long f, long s) {
        this.f = f;
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data = (Data) o;

        if (f != data.f) return false;
        return s == data.s;
    }

    @Override
    public int hashCode() {
        int result = (int) (f ^ (f >>> 32));
        result = 31 * result + (int) (s ^ (s >>> 32));
        return result;
    }
}
