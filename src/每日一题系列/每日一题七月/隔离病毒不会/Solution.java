package 每日一题系列.每日一题七月.隔离病毒不会;

import java.util.*;

public class Solution {
    public int containVirus(int[][] isInfected) {
        // 看到这种题目我想到的标签就是bfs, dfs
        // 尝试每次找最大区域? 反正唯一
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = isInfected.length;
        int n = isInfected[0].length;
        // 记录每个病毒块的正常邻居
        List<Set<Integer>> neighbors;
        int result = 0;
        do {
            neighbors = new ArrayList<>();
            // 记录当前能影响周边正常点最多的病毒块的周边正常点个数
            int maxNeighbourSize = 0;
            // 记录当前能影响周边正常点最多的病毒块的索引
            int maxNeighbourSizeIndex = -1;
            // 记录上述指定病毒块的防火墙数
            int maxNeighbourSizeFirewallsCount = 0;
            // 1.bfs寻找当前未被隔离的能影响周边正常点最多的病毒块
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] == 1) {
                        // 找到一个未被隔离的病毒块的入口, 准备对其bfs获取其周边的未被感染区域
                        LinkedList<int[]> queue = new LinkedList<>();
                        queue.offer(new int[] {i, j});
                        Set<Integer> neighbor = new HashSet<>();
                        int firewall = 0;
                        // 这里是记录每个病毒块的索引, 用来区分其是第几块区域
                        int index = neighbors.size() + 1;
                        isInfected[i][j] = -index;
                        while (!queue.isEmpty()) {
                            int[] point = queue.poll();
                            for (int[] direction : directions) {
                                int nx = point[0] + direction[0];
                                int ny = point[1] + direction[1];
                                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                    if (isInfected[nx][ny] == 1) {
                                        // 找到当前病毒块的病毒点
                                        queue.offer(new int[] {nx, ny});
                                        isInfected[nx][ny] = -index;
                                    } else if (isInfected[nx][ny] == 0) {
                                        // 找到一个正常区域, 需要加防火墙
                                        firewall++;
                                        // i j不超过50, i放到前4字节, j放到后16个字节
                                        // 假设有病毒块有两个点隔着一个正常块, 那么通过
                                        // 哈希表可以去重
                                        neighbor.add((nx << 16) ^ ny);
                                    }
                                }
                            }
                        }
                        neighbors.add(neighbor);
                        if (neighbor.size() > maxNeighbourSize) {
                            maxNeighbourSize = neighbor.size();
                            maxNeighbourSizeIndex = index;
                            maxNeighbourSizeFirewallsCount = firewall;
                        }
                    }
                }
            }

            if (neighbors.isEmpty()) {
                // 没有病毒块
                break;
            }

            // 2.重置所有未被隔离的病毒块
            int neighboursSize = neighbors.size();
            result += maxNeighbourSizeFirewallsCount;
            maxNeighbourSizeIndex--;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] < 0) {
                        if (isInfected[i][j] != -(maxNeighbourSizeIndex + 1)) {
                            // 重新将其它未计算过的病毒块回归原来的样子, 等待下次计算
                            isInfected[i][j] = 1;
                        } else {
                            // 下次不用再管这个当前最大病毒块里的点了
                            isInfected[i][j] = 2;
                        }
                    }
                }
            }
            // 3.扩散未被隔离的病毒块
            for (int i = 0; i < neighboursSize; i++) {
                if (i != maxNeighbourSizeIndex) {
                    for (int val : neighbors.get(i)) {
                        // 每天扩散一个位置
                        int x = val >> 16;
                        // 后4字节&后四字节全1为原来的y
                        int y = val & ((1 << 16) - 1);
                        isInfected[x][y] = 1;
                    }
                }
            }
        } while (neighbors.size() > 1);
        return result;
    }
}
