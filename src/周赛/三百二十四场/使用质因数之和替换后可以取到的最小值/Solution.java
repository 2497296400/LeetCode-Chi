package 周赛.三百二十四场.使用质因数之和替换后可以取到的最小值;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestValue(19132));
    }
    public int smallestValue(int n) {
        ArrayList<Data> all = getALl(n);
        if (all.size()==1&&all.get(0).cur*all.get(0).sum==n) {
            return all.get(0).cur*all.get(0).sum;
        } else {
           return smallestValue(toCheck(all, n));
        }
    }
    private int toCheck(ArrayList<Data> all, int n) {
        int cur = 0;
        for (Data data : all) {
            cur += data.cur * data.sum;
        }
        return cur;
    }

    private ArrayList<Data> getALl(int n) {
        int j = 2;
        ArrayList<Data> cur = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                int cursum = 0;
                while (n % i == 0) {
                    n /= i;
                    cursum++;
                }
                cur.add(new Data(i, Math.max(1, cursum)));
            }
        }
        if (n > 1) {
            cur.add(new Data(n, 1));
        }
        return cur;
    }
}

class Data {
    int cur;
    int sum;

    public Data(int cur, int sum) {
        this.cur = cur;
        this.sum = sum;
    }
}
