package 深度广度遍历问题.广度遍历;


import java.util.Arrays;

public class Dome {
    public static void main(String[] args) {

        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.floodFill(image, 1, 1, 2)));
    }
}
