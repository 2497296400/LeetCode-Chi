package 手写一系列东西.多线程的生产者消费者;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LinkedList <Integer> list = new LinkedList<>();
        Coustomer coustomer = new Coustomer(list);
        Product product = new Product(list, 10);
        Thread thread = new Thread(coustomer);
        thread.start();
        Thread thread1 = new Thread(product);
        thread1.start();
        thread.join();
        thread1.join();
        
    }
}
