import java.io.*;
import java.util.*;

public class Main {
    public static StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = nextInt();
        int m = nextInt();
        int q = nextInt();
        Set<Integer>[] graph = new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int i = 0; i < m; i++) {
            int a = nextInt();
            int b = nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        int[] color = new int[n + 1];
        int colorCount = 0;
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                colorCount++;
                dfs(i, graph, color, colorCount);
            }
        }
        for (int i = 0; i < q; i++) {
            int op =nextInt();
            int u = nextInt();
            int v = nextInt();
            if (op == 1) {
                graph[u].remove(Integer.valueOf(v));
                graph[v].remove(Integer.valueOf(u));
                color = new int[n + 1];
                colorCount = 0;
                for (int j = 1; j <= n; j++) {
                    if (color[j] == 0) {
                        colorCount++;
                        dfs(j, graph, color, colorCount);
                    }
                }
            } else if (op == 2) {
                if (color[u] == color[v]) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    private static void dfs(int node, Set<Integer>[] graph, int[] color, int colorCount) {
        color[node] = colorCount;
        for (int neighbor : graph[node]) {
            if (color[neighbor] == 0) {
                dfs(neighbor, graph, color, colorCount);
            }
        }
    }

    public static int nextInt() {
        try {
            tokenizer.nextToken();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (int) tokenizer.nval;
    }
}