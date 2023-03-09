package 重复数快慢指针;
public class Dome {
    public static void main(String[] args) {
        Solution s=new Solution();
        Solution01 s01=new Solution01();
        int []num= {1,3,4,2,2};
        System.out.println(s.findDuplicate(num));
        System.out.println(s01.findDuplicate(num));
    }
}
