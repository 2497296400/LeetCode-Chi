package Top集合.栅栏凸包;

import java.util.*;

public class Solution {
    public int[][] outerTrees(int[][] trees) {
        Arrays.sort(trees, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int[][] stack = new int[trees.length << 1][2];
        int curLas = 0;
        for (int i = 0; i < trees.length; i++) {
            while (curLas > 1 && corss(stack[curLas - 2], stack[curLas - 1], trees[i]) > 0) {
                curLas--;
            }
            stack[curLas++] = trees[i];
        }
        for (int i = trees.length - 2; i >= 0; i--) {
            while (curLas > 1 && corss(stack[curLas - 2], stack[curLas - 1], trees[i]) > 0) {
                curLas--;
            }
            stack[curLas++] = trees[i];
        }

        Arrays.sort(stack, 0, curLas, (a, b) -> b[0] == a[0] ? b[1] - a[1] : b[0] - a[0]);
        int n = 1;
        for(int i = 1;i< curLas;i++){
            if(stack[i][0]!=stack[i-1][0]||stack[i][1]!=stack[i-1][1]){
                stack[n++]=stack[i];
            }
        }
        return Arrays.copyOf(stack, n);
    }
    //向量
    private int corss(int[] a, int[] b, int[] c) {
        return (b[1] - a[1]) * (c[0] - b[0]) - (b[0] - a[0]) * (c[1] - b[1]);
    }
}
