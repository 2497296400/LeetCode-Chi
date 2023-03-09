package 汉诺塔;

public class Solution {
    public static void main(String[] args) {

        int n = 2;
        fun(n, n, "left", "right", "mid");
    }

    private static void fun(int rest, int down, String start, String end, String other) {
        if (rest == 1) {
            System.out.println(" move " + 1 + " from " + start+" to " + end);
        } else {
            fun(rest - 1, down - 1, start, other, end);
            System.out.println(" move " + rest + " from " + start + " to " +end);
            fun(rest - 1, down - 1, other, end, start);
        }
    }
}
