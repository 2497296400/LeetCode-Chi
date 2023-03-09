package 基础数据结构.按公因数计算最大组件大小.官方答案并查集;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int []nums={4, 6, 15, 35};
        System.out.println(solution.largestComponentSize(nums));
    }
        public int largestComponentSize(int[] nums) {
            int m = Arrays.stream(nums).max().getAsInt();
            UnionFind uf = new UnionFind(m + 1);
            for (int num : nums) {
                for (int i = 2; i * i <= num; i++) {
                    if (num % i == 0) {
                        uf.union(num, i);
                        uf.union(num, num / i);
                    }
                }
            }
            int[] counts = new int[m + 1];
            int ans = 0;
            for (int num : nums) {
                int root = uf.find(num);
                counts[root]++;
                ans = Math.max(ans, counts[root]);
            }
            return ans;
        }
    }

    class UnionFind {
        int[] parent;
        int[] rank;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            rank = new int[n];
        }
        public void union(int first, int second) {
            int firstFather = find(first);
            int secondFather = find(second);
            if (firstFather != secondFather) {
                if (rank[firstFather] > rank[secondFather]) {
                    parent[secondFather] = firstFather;
                } else if (rank[firstFather] < rank[secondFather]) {
                    parent[firstFather] = secondFather;
                } else {
                    parent[secondFather] = firstFather;
                    rank[firstFather]++;
                }
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
