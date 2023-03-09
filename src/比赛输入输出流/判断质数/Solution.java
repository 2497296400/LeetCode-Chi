package 比赛输入输出流.判断质数;

import java.io.*;
import java.util.HashMap;

public class Solution {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static long nextInt() throws IOException {
        in.nextToken();
        in.nextToken();
        return (long) in.nval;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        HashMap<Long, Boolean> map = new HashMap<>();
   
        int N = (int) nextInt();
        for (int i = 0; i < N; i++) {
            long anInt = nextInt();
            if (!map.containsKey(anInt)) {
                if (isT(anInt)) {
                    map.put(anInt, true);
                    out.println(1);
                } else {
                    map.put(anInt, false);
                    out.println(0);
                }
            } else {
                if (map.get(anInt)) {
                    out.println(1);
                } else {
                    out.println(0);
                }
            }
        }
        out.close();
    }
    private static boolean isT(long nextInt) {
        if (nextInt <= 3) {
            return nextInt > 1;
        }
        if (nextInt % 6 != 1 && nextInt % 6 != 5) {
            return false;
        }
        for (int i = 5; i < Math.sqrt(nextInt); i += 6) {
            if (nextInt % i == 0 || nextInt % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
