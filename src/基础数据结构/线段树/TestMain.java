package 基础数据结构.线段树;

public class TestMain {
    public static void main(String[] args) {
        int[] origin = {2, 1, 1, 2, 3, 4, 5};
        TestSegMent segmentTree = new TestSegMent(origin);
        int S = 1;
        int N = origin.length;
        int root = 1;
        int L = 2;
        int R = 5;
        int C = 4;
        segmentTree.build(S, N, root);
        segmentTree.add(L, R, C, S, N, root);
        segmentTree.upDate(L, R, C, S, N, root);
        long query = segmentTree.query(L, R,S, N, root);
        System.out.println(query);
    }
}
