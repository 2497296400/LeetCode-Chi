package 基础数据结构.树状数组.区间更新区间查询;

public class IndexTreeRange {
    public static void main(String[] args) {

        int len = 10;
        IndexTreeRange indexTreeRange = new IndexTreeRange(len);
        indexTreeRange.update(1, 4, 5);
        System.out.println(indexTreeRange.query(4));
        System.out.println(indexTreeRange.query(1, 3));
        indexTreeRange.update(2, 3, 6);
        System.out.println(indexTreeRange.query(1, 3));
    }

    int[] sum1;
    int[] sum2;
    int N;

    public IndexTreeRange(int n) {
        sum1 = new int[n + 1];
        sum2 = new int[n + 1];
        N = n;
    }

    public int lowbit(int x) {
        return x & (-x);
    }

    public void update(int index, int value) {
        int preIndex = index;
        while (index <= N) {
            sum1[index] += value;
            //这里是关键 为什么要乘以preIndex-1 因为sum2[i]表示的是前i个数的和，所以要减去前面的数 也就是preIndex-1 个数 乘以value 
            sum2[index] += value * (preIndex - 1);
            index += lowbit(index);
        }
    }

    public void update(int l, int r, int v) {
        update(l, v);
        update(r + 1, -v);
    }

    public int query(int l, int r) {
        return query(r) - query(l - 1);
    }

    private int query(int index) {
        int res = 0;
        int preIndex = index;
        while (index > 0) {
            //这里是关键 为什么要乘以index 因为sum1[i]表示的是前i个数的和，所以要减去前面的数 也就是index 个数 乘以value
            //为什么要减去sum2[index] 因为sum2[index]表示的是前index个数的和，所以要减去前面的数 也就是index
            res += sum1[index] * preIndex - sum2[index];
            index -= lowbit(index);
        }
        return res;
    }

}
