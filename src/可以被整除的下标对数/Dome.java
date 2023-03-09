package 可以被整除的下标对数;

public class Dome {
    public static void main(String[] args) {
        Solution s=new Solution();
        int []num={1,2,4,5};
        Solution01 s01=new Solution01();

        System.out.println(s.coutPairs(num,2));
        System.out.println(s01.coutPairs(num,2));
    }
}
