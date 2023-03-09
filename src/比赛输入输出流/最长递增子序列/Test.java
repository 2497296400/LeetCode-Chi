package 比赛输入输出流.最长递增子序列;

import java.io.*;
import java.util.Scanner;

public class Test {
        static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int N = nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nextInt();
        }
        int[] end = new int[N];
        int curEed = 0;
        for (int i = 0; i < N; i++) {
            int curcur = find(end, arr[i], curEed);
            if (curcur == -1) {
                end[curEed++] = arr[i];
            } else {
                end[curcur] = arr[i];
            }
        }
        out.println(end);
        //在此输入您的代码...
        scan.close();
    }
    private static int find(int[] end, int cur, int curEed) {
        int left = 0;
        int right = curEed;
        int index = -1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (end[mid] < cur) {
                left = mid + 1;
            } else {
                index = mid;
                right = mid;
            }
        }
        return index;
    }
    public static int nextInt() throws IOException{
        in.nextToken();
        return (int)in.nval;
    }
}
