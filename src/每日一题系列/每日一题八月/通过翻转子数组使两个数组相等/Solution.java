package 每日一题系列.每日一题八月.通过翻转子数组使两个数组相等;

public class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
    int []cur=new int[1001];
    for(int i=0;i< target.length;i++){
        cur[target[i]]++;
        cur[arr[i]]--;
    }
    for(int i=0;i<1001;i++){
        if(cur[i]!=0){
            return false;
        }
    }
    return true;
    }
}
