package 精选一百道题.汉明距离;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingDistance(3,1));
    }
    public int hammingDistance(int x, int y) {
        int curLen=0;

        while (x!=0||y!=0){
            int curX=0;
            if(x%2!=0){
               curX=1;
            }
            int curY=0;
            if(y%2!=0){
                curY=1;
            }
            if(curX!=curY){
                curLen++;
            }
            x>>=1;
            y>>=1;
        }
        return curLen;
    }
}
