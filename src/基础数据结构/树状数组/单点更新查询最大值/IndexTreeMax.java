package 基础数据结构.树状数组.单点更新查询最大值;

public class IndexTreeMax {
    public static void main(String[] args) {
        IndexTreeMax indexTreeMax = new IndexTreeMax(10);
        indexTreeMax.update(1, 1000);
        indexTreeMax.update(2, 800);
        indexTreeMax.update(3, 500);
        indexTreeMax.update(5, 2000);
        System.out.println(indexTreeMax.query(2, 5));
    }

    int N;
    int[] tree;
    int[] fuzhu;

    public IndexTreeMax(int n) {
        N = n;
        tree = new int[n + 1];
        fuzhu = new int[n + 1];
    }

    public int lowbit(int x) {
        return x & (-x);
    }

    public void update(int index, int value) {
        tree[index] = fuzhu[index] = value;
        while (index < N) {
            tree[index] = Math.max(tree[index], value);
            index += lowbit(index);
        }
    }

    public int query(int l, int r) {
        int ans = 0;
        while (r >= l) {
            ans = Math.max(ans, fuzhu[r]);
            for (r--; r - lowbit(r) >= l; r -= lowbit(r)) {
                ans = Math.max(ans, tree[r]);
            }
        }
        return ans;
    }
}
