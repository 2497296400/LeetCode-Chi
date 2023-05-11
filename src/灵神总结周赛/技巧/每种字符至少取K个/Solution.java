package 灵神总结周赛.技巧.每种字符至少取K个;

public class Solution {
    int K;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.takeCharacters("acbcc" , 1));
    }

    public int takeCharacters(String s, int k) {
        K = k;
        int[] arr = new int[3];
        char[] chars = s.toCharArray();
        int preIndex = 0;
        if (k == 0) {
            return 0;
        }
        for (int i = chars.length - 1; i >= 0; i--) {
            arr[chars[i] - 'a']++;
            if (toCheck(arr)) {
                preIndex = i;
                break;
            }
        }
        int ans = chars.length - preIndex;
        if (!toCheck(arr)) {
            return -1;
        }
        int l = 0, r = 0;
        while (preIndex < chars.length) {
            arr[chars[preIndex++] - 'a']--;
            while (l < chars.length && !toCheck(arr)) {
                arr[chars[l++] - 'a']++;
            }
            ans = Math.min(ans, l + chars.length - preIndex );
        }
        return ans;
    }

    private boolean toCheck(int[] arr) {
        for (int i : arr) {
            if (i < K) {
                return false;
            }
        }
        return true;
    }
}
