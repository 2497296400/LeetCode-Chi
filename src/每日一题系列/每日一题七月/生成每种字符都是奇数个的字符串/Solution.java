package 每日一题系列.每日一题七月.生成每种字符都是奇数个的字符串;

public class Solution {
    public static void main(String[] args) {
     Solution solution=   new Solution();
        System.out.println(solution.generateTheString(7));
    }
    public String generateTheString(int n) {
        char []ar=new char[26];
        for(int i=0;i<26;i++){
            ar[i]= (char) (i+'a');
        }
        StringBuilder s= new StringBuilder();
        if(n%2!=0){
            for(int i=0;i<n;i++){
                s.append(ar[0]);
            }
        }else {
            if(n==2){
                s.append(ar[0]).append(ar[1]);
            }else {
                for(int i=0;i<n-1;i++){
                    s.append(ar[0]);
                }
                s.append(ar[1]);
            }
        }
        return String.valueOf(s);
    }
}
