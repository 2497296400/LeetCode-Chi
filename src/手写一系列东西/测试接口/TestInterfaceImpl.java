package 手写一系列东西.测试接口;

public class TestInterfaceImpl  implements  TestInterface{
    @Override
    public void fun() {
        System.out.println("13123213123");
    }
    

    public static void main(String[] args) {
        TestInterface testInterface = new TestInterfaceImpl();
        testInterface.getFun();
    }
}
