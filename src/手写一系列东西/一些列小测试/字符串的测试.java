package 手写一系列东西.一些列小测试;

public class 字符串的测试 {
    public static void main(String[] args) {
        String a = "str_a";
        String b = new String(a + "str_b");
        String c = "str_astr_b";
        System.out.println(b == c);
    }
}
