package 每日一题系列.每日一题十二月.考场就座;

import java.util.HashMap;
import java.util.TreeSet;

public class Test {
    class ExamRoom {
        HashMap<Integer, int[]> pre;
        HashMap<Integer, int[]> last;
        TreeSet<int[]> treeSet;
        int N;


        public ExamRoom(int N) {
            pre = new HashMap<>();
            last = new HashMap<>();
            treeSet = new TreeSet<>(((o1, o2) -> {
                int ff = distance(o1);
                int ss = distance(o2);
                if (ff != ss) {
                    return ff - ss;
                }
                return o1[0] - o2[0];
            }));
            this.N = N;
            addLine(new int[]{-1, N});
        }

        private int distance(int[] arr) {
            if (arr[0] == -1) {
                return arr[1];
            }
            if (arr[1] == N) {
                return N - 1 - arr[0];
            }
            return (arr[1] - arr[0]) / 2;
        }

        private void addLine(int[] arr) {
            treeSet.add(arr);
            pre.put(arr[0], arr);
            last.put(arr[1], arr);
        }

        private void remove(int[] arr) {
            treeSet.remove(arr);
            pre.remove(arr[0]);
            last.remove(arr[1]);
        }

        public int seat() {
            int[] v = treeSet.last();
            int f = v[0];
            int s = v[1];
            int seat;
            if (f == -1) {
                seat = 0;
            } else if (s == N) {
                seat = N - 1;
            } else {
                seat = (f + s) / 2;
            }
            int[] left = new int[]{f, seat};
            int[] right = new int[]{seat, s};
            remove(v);
            addLine(left);
            addLine(right);
            return seat;
        }

        public void leave(int v) {
            int[] left = pre.get(v);
            int[] right = last.get(v);
            int[] newLine = new int[]{left[0], right[1]};
            remove(left);
            remove(right);
            addLine(newLine);
        }
    }
}
