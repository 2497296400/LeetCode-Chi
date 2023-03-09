package 深度广度遍历问题.深度优先搜索;

public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return DFS(image, sr, sc, image[sr][sc], newColor);
    }
    public int[][] DFS(int[][] image, int x, int y, int color, int newcolor) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] == newcolor || image[x][y] != color) {
        }
        else {
            int temp = image[x][y];
            image[x][y] = newcolor;
            DFS(image, x + 1, y, temp, newcolor);
            DFS(image, x - 1, y, temp, newcolor);
            DFS(image, x, y - 1, temp, newcolor);
            DFS(image, x, y + 1, temp, newcolor);
        }
        return image;
    }
}
