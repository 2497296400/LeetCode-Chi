//package 每日一题系列.每日一题十月.在LR字符串中交换相邻字符;
//
//public class SOlution {
//    public boolean canTransform(String start, String end) {
//        char[] c1 = start.toCharArray();
//        char[] c2 = end.toCharArray();
//        int i, j = 0;
//        int n = c1.length;
//        while (true) {
//            while (c1[i] == 'X') i++;
//            while (c2[j] == 'X') j++;
//            if (i >= n && j >= n) return true;
//            if (i >= n || j >= n) return false;
//            if (c1[i] == 'L' && i < j) return false;
//            if (c1[i] == 'R' && i > j) return false;
//        }
//    }
//}