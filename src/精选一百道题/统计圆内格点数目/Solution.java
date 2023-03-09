package 精选一百道题.统计圆内格点数目;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[][] circles = {{2, 2, 2},{3,4,1}};
        System.out.println(countLatticePoints(circles));
    }
    static class Node {
        int curX;
        int curY;

        public Node(int curX, int curY) {
            this.curX = curX;
            this.curY = curY;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return curX == node.curX && curY == node.curY;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(curX);
        }
    }

    public static int countLatticePoints(int[][] circles) {
        Set<Node> set = new HashSet<>();
        for (int i = 0; i < circles.length; i++) {
            findNode(set, circles[i]);
        }
        return set.size();
    }

    private static void findNode(Set<Node> set, int[] circle) {
        int x = circle[0];
        int y = circle[1];
        int r = circle[2];
        set.add(new Node(x, y));
        for (int i = x; i <= x + r; i++) {
            for (int j = y; j >= y - r; j--) {
                if (Math.sqrt((y - j) * (y - j) + (i - x) * (i - x)) <= r) {
                    set.add(new Node(i, j));
                }
            }
        }
        for (int i = x; i <= x + r; i++) {
            for (int j = y; j <= y + r; j++) {
                if (Math.sqrt((y - j) * (y - j) + (i - x) * (i - x)) <= r) {
                    set.add(new Node(i, j));
                }
            }
        }
        for (int i = x; i >= x - r; i--) {
            for (int j = y; j >= y - r; j--) {
                if (Math.sqrt((y - j) * (y - j) + (i - x) * (i - x)) <= r) {
                    set.add(new Node(i, j));
                }
            }
        }
        for (int i = x; i >= x - r; i--) {
            for (int j = y; j <= y + r; j++) {
                if (Math.sqrt((y - j) * (y - j) + (i - x) * (i - x)) <= r) {
                    set.add(new Node(i, j));
                }
            }
        }
    }
}
