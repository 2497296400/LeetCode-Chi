package 秋招笔试.小红书笔试;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class Main {
    //树状数组
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static List<List<Integer>> all;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        char[] c = scanner.next().toCharArray();
        long ans = 0;
        int l = 0, r = 0;
        while (l < c.length) {
            int preOne = 0, preZero = 0;
            while (r < c.length) {
                if (c[r] == '1') {
                    preOne++;
                } else {
                    preZero++;
                }
                r++;
                if (preOne >= preZero) {
                    break;
                }
                ans += preZero - preOne;
            }
            l = r;
        }
        System.out.println(ans);
    }
    

    public static boolean isT(int target) {
        if (target == 1) {
            return false;
        }
        for (int i = 2; i * i <= target; i++) {
            if (target % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

}

class IndexTree {
    int N;
    int[] nums;

    public int lowbit(int x) {
        return x & (-x);
    }

    public IndexTree(int n) {
        N = n;
        nums = new int[N + 1];
    }

    public void update(int i, int k) {
        while (i <= N) {
            nums[i] += k;
            i += lowbit(i);
        }
    }

    public int query(int i) {
        int res = 0;
        while (i > 0) {
            res += nums[i];
            i -= lowbit(i);
        }
        return res;
    }
}

//区间更新区间查值
class IndexTreeTow {
    int N;
    int[] sum1;
    int[] sum2;

    public int lowbit(int x) {
        return x & (-x);
    }

    public IndexTreeTow(int n) {
        N = n;
        sum1 = new int[N + 1];
        sum2 = new int[N + 1];
    }

    public void update(int i, int k) {
        int preIndex = i;
        while (i <= N) {
            sum1[i] += k;
            sum2[i] += k * (preIndex - 1);
            i += lowbit(i);
        }
    }

    public void update(int l, int r, int k) {
        update(l, k);
        update(r + 1, -k);
    }

    public int query(int i) {
        int res = 0, preIndex = i;
        while (i > 0) {
            res += preIndex * sum1[i] - sum2[i];
            i -= lowbit(i);
        }
        return res;
    }

    public int query(int l, int r) {
        return query(r) - query(l - 1);
    }
}
