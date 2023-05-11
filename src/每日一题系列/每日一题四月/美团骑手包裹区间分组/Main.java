package 每日一题系列.每日一题四月.美团骑手包裹区间分组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        String cur = nextString();
        int[] arr = new int[26];
        char[] chars = cur.toCharArray();
        for (char aChar : chars) {
            arr[aChar - 'A']++;
        }
        int l = 0;
        for (int i = 0; i < cur.length(); ) {
            char charAt = cur.charAt(i);
            int indexOf = cur.lastIndexOf(charAt);
            for (int j = i + 1; j < indexOf && indexOf < cur.length(); j++) {
                char charAt1 = cur.charAt(j);
                int lastIndexOf = cur.lastIndexOf(charAt1);
                if (lastIndexOf < indexOf) {
                    continue;
                } else {
                    indexOf = lastIndexOf;
                }
            }
            System.out.print(indexOf - i + 1 + " ");
            i = indexOf + 1;
        }
        System.out.println();
    }

    public static String nextString() throws IOException {
        in.nextToken();

        return in.sval;
    }
}
