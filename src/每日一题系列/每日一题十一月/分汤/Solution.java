package 每日一题系列.每日一题十一月.分汤;

import java.util.HashMap;

public class Solution {
    public double soupServings(int n) {
        if (n >= 5000) {
            return 1;
        }
        HashMap<String, Double> map = new HashMap<>();
        return fun(n, n, map);
    }

    private double fun(int a, int b, HashMap<String, Double> map) {
        if (a == 0 && b != 0) {
            return 1;
        }
        if (a == 0 && b == 0) {
            return 0.5;
        }
        if (a != 0 && b == 0) {
            return 0;
        }
        String curS = a + " " + b;
        if (map.containsKey(curS)) {
            return map.get(curS);
        }
        double curP = 0;
        curP += fun(Math.max(0, a - 100), b, map) * 0.25;
        curP += fun(Math.max(a - 75, 0), Math.max(b - 25, 0), map) * 0.25;
        curP += fun(Math.max(a - 50, 0), Math.max(b - 50, 0), map) * 0.25;
        curP += fun(Math.max(a - 25, 0), Math.max(b - 75, 0), map) * 0.25;
        map.put(curS, curP);
        return curP;

    }
}
