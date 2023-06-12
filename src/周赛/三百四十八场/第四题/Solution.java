package 周赛.三百四十八场.第四题;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.count("1", "5", 1, 5));

    }

    int MOD = (int) (1e9 + 7);
    String start;
    String end;
    int min;
    int max;

    public String minusOne(String str) {
        // 首先将字符串转换为字符数组
        char[] charArray = str.toCharArray();

        // 将最后一位字符减1
        charArray[charArray.length - 1] = (char) (charArray[charArray.length - 1] - 1);

        // 如果最后一位为0，需要借位
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] < '0') {
                charArray[i] = '9'; // 借位
                if (i == 0) {
                    // 如果第一位也需要借位，那么需要在字符数组前添加一个0
                    char[] newCharArray = new char[charArray.length + 1];
                    newCharArray[0] = '0';
                    System.arraycopy(charArray, 0, newCharArray, 1, charArray.length);
                    charArray = newCharArray;
                } else {
                    // 否则继续向前借位
                    charArray[i - 1] = (char) (charArray[i - 1] - 1);
                }
            }
        }
        // 返回字符串
        return new String(charArray);
    }

    public int count(String num1, String num2, int min_sum, int max_sum) {
        start = num1;
        // num1 = minusOne(num1);
        // start = num1;
        end = num2;
        min = min_sum;
        max = max_sum;
        char[] f = start.toCharArray();
        char[] s = end.toCharArray();
        //  Long[][] dpf = new Long[f.length + 1][max_sum + 1];
        Long[][] dps = new Long[s.length + 1][max_sum + 1];
        return (int) dfs(s, f.length - 1, false, true, 0, dps) % MOD;
        // return (int) ((dfs(s, 0, false, true, 0, dps) - dfs(f, 0, false, true, 0, dpf)) % MOD);
    }

    private long dfs(char[] c, int index, boolean isNum, boolean isLimit, int status, Long[][] dps) {
        if (status > max) {
            return 0;
        }
        if (index == c.length) {
            if (status >= min && status <= max) {
                return 1;
            }
            return 0;
        }
        if (isNum && !isLimit && dps[index][status] != null) {
            return dps[index][status];
        }
        long ans = 0;
        if (!isNum) {
            ans = dfs(c, index + 1, false, false, status, dps);
        }
        int limit = isLimit ? c[index] - '0' : 9;

        for (int i = (index == start.length() - 1) ? start.charAt(index) - '0' : 0; i <= limit; i++) {
            ans += dfs(c, index + 1, true, isLimit && i == limit, status + i, dps);
        }
        if (isNum && !isLimit) {
            dps[index][status] = ans;
        }
        return ans;
    }
}
