package 灵神总结周赛.模拟.统计共同度过的日子数;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countDaysTogether("10-01", "10-31", "11-01", "12-31"));
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] asr = new int[13];

        for (int i = 1; i < asr.length-1; i++) {
            asr[i] += arr[i-1] + asr[i - 1];
        }
        String[] af = arriveAlice.split("-");
        String[] as = leaveAlice.split("-");
        String[] bf = arriveBob.split("-");
        String[] bs = leaveBob.split("-");
        int apre = asr[Integer.parseInt(af[0])-1] + Integer.parseInt(af[1]);
        int anext = asr[Integer.parseInt(as[0])-1] + Integer.parseInt(as[1]);
        int bpre = asr[Integer.parseInt(bf[0])-1] + Integer.parseInt(bf[1]);
        int bnext = asr[Integer.parseInt(bs[0])-1] + Integer.parseInt(bs[1]);
        return Math.max(0, Math.min(anext, bnext) - Math.max(apre, bpre)+1);
    }
}

