
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int T = (int) nextInt();
        for (int i = 0; i < T; i++) {
            int m = (int) nextInt();
            int[] arr = new int[m];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < m; j++) {
                arr[j] = nextInt();
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            }
            Arrays.sort(arr);
            if (toCheck(arr, map)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean toCheck(int[] arr, HashMap<Integer, Integer> map) {
        long sum = 0L;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % (arr.length / 2) != 0) {
            return false;
        }
        int cur = (int) (sum / (arr.length / 2));
       // System.out.println(cur);
        for (int i = 0; i < arr.length; i++) {
            if (map.isEmpty()) {
                return true;
            }
            if (!map.containsKey(arr[i])) {
                continue;
            }
            if (!map.containsKey(cur - arr[i])) {
                return false;
            } else {
                Integer f = map.get(arr[i]);
                Integer s = map.get(cur - arr[i]);
                if (f == 1) {
                    map.remove(arr[i]);
                } else {
                    map.put(arr[i], f - 1);
                }
                if (s == 1) {
                    map.remove(cur - arr[i]);
                } else {
                    map.put(cur - arr[i], s - 1);

                }
            }
        }
        return true;
    }

    public static int nextInt() throws IOException {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

    public static String nextString() throws IOException {
        tokenizer.nextToken();
        return tokenizer.sval;
    }
}
