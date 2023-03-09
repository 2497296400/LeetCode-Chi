package 基础数据结构.IndexTree;

public class indexTree {
    private int[] tree;
    private int N;

    public indexTree(int size) {
        N = size;
        tree = new int[N + 1];
    }

    public int sum(int index) {
        int ret = 0;
        while (index > 0) {
            ret += tree[index];
            index -= index & (-index);
        }
        return ret;
    }

    public void add(int index, int task) {
        while (index <= N) {
            tree[index] += task;
            index += index & (-index);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 9, 7, 1, 2};
        indexTree indexTree = new indexTree(arr.length);
        int len = 0;
        for (int i : arr) {
            indexTree.add(++len, i);
        }
        System.out.println(indexTree.sum(len));
        System.out.println(indexTree.sum(5));
    }
}
