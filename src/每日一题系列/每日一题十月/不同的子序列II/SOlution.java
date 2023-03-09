package 每日一题系列.每日一题十月.不同的子序列II;

import java.util.HashMap;

public class SOlution {
    public static void main(String[] args) {
        SOlution sOlution = new SOlution();
        String s = "blljuffdyfrkqtwfyfztpdiyktrhftgtabxxoibcclbjvirnqyynkyaqlxgyybkgyzvcahmytjdqqtctirnxfjpktxmjkojlvvrr";
        System.out.println(sOlution.distinctSubseqII(s));
    }
    public int distinctSubseqII(String s) {
        long MOD = (long) (1e9 + 7);
        HashMap<Character, Long> map = new HashMap<>();
        map.put(' ', 1L);
        long sum = 1;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            long newAll = sum%MOD;
            sum = (sum+ newAll - map.getOrDefault(aChar, 0L)+MOD)%MOD;
            map.put(aChar, newAll);
        }
        return (int) ((sum - 1) % MOD);
    }
}

