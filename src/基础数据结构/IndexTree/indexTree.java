package 基础数据结构.IndexTree;

public class indexTree {
    static int[] tree;
    static int N;

    public static int sum(int index) {
        int ans = 0;
        while (index > 0) {
            ans += tree[index];
            index -= lotbit(index);
        }
        return ans;

    }

    public static int lotbit(int i) {
        return i & (-i);
    }

    public static void updata(int i, int target) {
        while (i <= N) {
            tree[i] += target;
            i += lotbit(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        int len = arr.length;
        N = len + 1;
        tree = new int[N];
        System.out.println(sum(len));   
        for (int i = 1; i < arr.length; i++) {
            updata(i, arr[i] - arr[i - 1]);
        }
 /*       updata(1, 5);
        updata(4, -5);*/
        System.out.println(sum(5));
    }
}