package 深度广度遍历问题.矩阵;

import java.util.Arrays;

public class DOme {
    public static void main(String[] args) {
        Solution01 s=new Solution01();
        int [][] a={{0,0,0},{0,1,0},{1,1,1}};
        System.out.println(Arrays.deepToString(s.updateMatrix(a)));
    }
}
