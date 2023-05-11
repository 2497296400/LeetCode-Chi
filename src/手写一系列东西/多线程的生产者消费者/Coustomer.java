package 手写一系列东西.多线程的生产者消费者;

import java.util.LinkedList;

public class Coustomer implements Runnable {
    private final LinkedList<Integer> list;

    public Coustomer(LinkedList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                while (list.isEmpty()) {
                    System.out.println("消费者为空");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("消费者消费"+list.remove());
                list.notifyAll();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
