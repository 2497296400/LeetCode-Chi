package 卷一核心技术.多线程.原子自增.CAS;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
// 使用 AtomicIntegerFieldUpdater 更新的字段必须使用 volatile 修饰
 class User {
    int id;
    volatile int age;//必须使用 volatile 修饰，实例变量
    public User(int id, int age) {
        this.id = id;
        this.age = age;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}
//线程类
class SubThread extends Thread {
    private User user;
    //要更新的 User 对象创建 AtomicIntegerFieldUpdater 更新器
    private  AtomicIntegerFieldUpdater<User>  updater  = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");
    public SubThread(User user) {
        this.user = user;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {//在子线程中对 user 对象的 age 字段自增 10 次
            System.out.println( updater.getAndIncrement(user));
        } }}
//测试
public class Test01 {
    public static void main(String[] args) {
        User user = new User(1234, 10);
        for (int i = 0; i < 10; i++) {
            new SubThread(user).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( user );
    }}