package 周赛.三百零九.恰好移动k步到达某一位置的方法数目;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println( solution.numberOfWays(272, 270, 6));
    }
    public int numberOfWays(int startPos, int endPos, int k) {

        return fun(startPos, endPos, k);
    }

    HashMap<Data, Integer> map = new HashMap<>();
    public int MOD = (int) (1e9+7);
    private int fun(int startPos, int endPos, int k) {
        if (k == 0) {
            return startPos == endPos ? 1 : 0;
        }
        if(map.containsKey(new Data(startPos, k))){
            return map.get(new Data(startPos, k));
        }
        if (k < Math.abs(startPos - endPos)) {
            return 0;
        }
        long ways = 0;
        ways += fun(startPos + 1, endPos, k - 1) % MOD;
        ways += fun(startPos - 1, endPos, k - 1) % MOD;
        map.put(new Data(startPos,k), (int) ways);
        return (int )ways%MOD;
    }
}
class Data{
    int startPos;
    int k;

    public Data(int startPos, int k) {
        this.startPos = startPos;
        this.k = k;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data = (Data) o;

        if (startPos != data.startPos) return false;
        return k == data.k;
    }

    @Override
    public int hashCode() {
        int result = startPos;
        result = 31 * result + k;
        return result;
    }
}
