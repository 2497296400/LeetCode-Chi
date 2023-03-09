package 周赛.三百场周赛.螺旋矩阵IV;

import java.util.Arrays;
import java.util.List;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(6);
        ListNode l5 = new ListNode(8);
        ListNode l6 = new ListNode(1);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(9);
        ListNode l9 = new ListNode(4);
        ListNode l10 = new ListNode(2);
        ListNode l11 = new ListNode(5);
        ListNode l12 = new ListNode(5);
        ListNode l13 = new ListNode(0);
        l1.next = l2;
        l1.next.next = l3;
        l1.next.next.next = l4;
        l1.next.next.next.next = l5;
        l1.next.next.next.next.next = l6;
        l1.next.next.next.next.next.next = l7;
        l1.next.next.next.next.next.next.next = l8;
        l1.next.next.next.next.next.next.next.next = l9;
        l1.next.next.next.next.next.next.next.next.next = l10;
        l1.next.next.next.next.next.next.next.next.next.next = l11;
        l1.next.next.next.next.next.next.next.next.next.next.next = l12;
        l1.next.next.next.next.next.next.next.next.next.next.next.next = l13;
        spiralMatrix(5,1, l1);


    }

    static class Data {
        int x;
        int y;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        Data curData = new Data(0, 0);
        Data lestData = new Data(m - 1, n - 1);
        int[][] martix = new int[m][n];
        while (curData.x <= lestData.x && curData.y <= lestData.y) {
            head = porcess(curData, lestData, martix, head);
            curData.x += 1;
            curData.y += 1;
            lestData.x -= 1;
            lestData.y -= 1;
        }
        System.out.println(Arrays.deepToString(martix));
        return martix;

    }

    private static ListNode porcess(Data curData, Data lestData, int[][] martix, ListNode head) {
        int curX = curData.x;
        int curY = curData.y;
        int nextX = lestData.x;
        int nextY = lestData.y;
        if(curX==nextX){
            while (curY<=nextY){
                martix[curX][curY++]=head == null ? -1 : head.val;
                if (head != null) {
                    head = head.next;
                }
            }
            return head;
        }else if(curY==nextY){
            while (curX<=nextX){
                martix[curX++][nextY]=head == null ? -1 : head.val;
                if (head != null) {
                    head = head.next;
                }
            }
            return head;
        }
        while (curY < lestData.y) {
            martix[curX][curY++] = head == null ? -1 : head.val;
            if (head != null) {
                head = head.next;
            }
        }
        while (curX < lestData.x) {
            martix[curX++][curY] = head == null ? -1 : head.val;
            if (head != null) {
                head = head.next;
            }
        }
        while (nextY > curData.y && curX <= lestData.x) {
            martix[curX][nextY--] = head == null ? -1 : head.val;
            if (head != null) {
                head = head.next;
            }
        }
        while (curX > curData.x && nextY >= curData.y) {
            martix[curX--][nextY] = head == null ? -1 : head.val;
            if (head != null) {
                head = head.next;
            }
        }
        return head;
    }

}

