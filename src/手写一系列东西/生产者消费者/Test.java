package 手写一系列东西.生产者消费者;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            new Thread(new Provider(list, 10,atomicInteger)).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(new Consume(list)).start();
        }
    }

    static class Provider extends Thread {
        private final List<Integer> list;
        private final int Max;
        private AtomicInteger atomicInteger;

        public Provider(List<Integer> list, int max, AtomicInteger atomicInteger) {
            this.list = list;
            Max = max;
            this.atomicInteger = atomicInteger;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    while (list.size() == Max) {
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    int andIncrement = atomicInteger.getAndIncrement();
                    System.out.println("生产者生产" + andIncrement+"---当前线程为"+Thread.currentThread().getName());
                    list.add(andIncrement);
                    list.notify();
                }
            }
        }
    }

    static class Consume extends Thread {
        private final List<Integer> list;

        Consume(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    while (list.isEmpty()) {
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("消费者消费" + list.remove(0)+"---当前线程为"+Thread.currentThread().getName());
                    list.notify();
                }
            }
        }
    }
}
