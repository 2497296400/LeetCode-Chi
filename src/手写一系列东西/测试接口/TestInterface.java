package 手写一系列东西.测试接口;

public interface TestInterface {
    public void fun();

    default void getFun() {
        fun();
        System.out.println("getFun");
    }
}
