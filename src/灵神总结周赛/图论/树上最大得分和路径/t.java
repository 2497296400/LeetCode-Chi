package 灵神总结周赛.图论.树上最大得分和路径;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t {
    public static void main(String[] args) {
        t t = new t();
        int[][] g = LeetCodeUtils.getIntTow("[[0,1],[1,2],[1,3],[3,4]]");
        System.out.println(t.mostProfitablePath(g, 3, new int[]{-2, 4, 2, -4, 6}));
    }
    int[] bobTime;
    int[] amount;
    int res = Integer.MIN_VALUE;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {

        int n = amount.length;
        bobTime = new int[n];
        Arrays.fill(bobTime, n);
        this.amount = amount;

        //构建树
        List<Integer>[] g  = new List[n];
        for(int i = 0; i < n; ++i) g[i] = new ArrayList<>();
        for(int[] edge : edges){

            int x = edge[0];
            int y = edge[1];
            g[x].add(y);
            g[y].add(x);
        }

        //bob的路线固定 先dfs出 bob 的路线
        dfsB(g, bob, -1,  0); //从bob点出发 走向0,  初始父节点为 -1

        g[0].add(-1); //防止0节点被误认为叶子节点
        dfsA(g, 0, -1, 0, 0); //寻找从0节点出发 到达叶子节点的最优路线
        return res;
    }
    public boolean dfsB(List<Integer>[] g, int p, int f, int time){

        if(p == 0){//到达0节点

            //到达0点 记录时间
            bobTime[p] = time;
            return true;
        }
        else{
            boolean flag = false;
            for(int e : g[p])
                if(e != f && dfsB(g, e, p, time + 1)) {flag = true; break;}

            //到达0点 记录时间
            if(flag) bobTime[p] = time;
            return flag;
        }
    }

    //total 参数表示路径得分
    public void dfsA(List<Integer>[] g, int p, int f, int time, int total){

        if(bobTime[p] == time){ //Alice 和 Bob 相遇 平摊分数

            total += amount[p] / 2;
        }else if(bobTime[p] > time){

            total += amount[p];
        }
        //到达叶子节点的路径
        if(g[p].size() == 1) res = res > total ? res : total;

        for(int e : g[p]) if(e != f) dfsA(g, e, p, time + 1, total);

    }
}
