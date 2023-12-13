package 手写一系列东西.多线程锁的应用;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Integer i = 12;
        Integer j = 13;
        System.out.println((i&j)+":"+(i|j));
    }
    
    public double fun(byte x ,double y){
        return x/y*2;
    }
}