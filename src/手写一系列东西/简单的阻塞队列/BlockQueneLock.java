package 手写一系列东西.简单的阻塞队列;

import java.util.ArrayDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueneLock<E> implements BolckQuene<E> {
    private final ArrayDeque<E> arrayDeque;
    public final static int DEAUL_MAX_CONUT = 10;
    public final int size;

    public BlockQueneLock() {
        this(DEAUL_MAX_CONUT);
    }

    private Lock lock = new ReentrantLock();
    private final Condition isNull = lock.newCondition();
    private final Condition isFull = lock.newCondition();

    public BlockQueneLock(int size) {
        this.size = size;
        arrayDeque = new ArrayDeque<>();
    }

    @Override
    public void put(E e) {
        lock.lock();
        try {
            try {
                while (arrayDeque.size() == size) {
                    System.out.println("队列满了");
                    isFull.await();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                isFull.signal();
            }
            arrayDeque.offer(e);
            isNull.signal();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E get() {
        lock.lock();
        try {
            try {
                while (arrayDeque.size() == 0) {
                    System.out.println("队列空了");
                    isNull.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                isNull.signal();
            }
            E e = arrayDeque.removeFirst();
            isFull.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int size() {
        return 0;
    }

    public static void main(String[] args) {
        BolckQueneSync<Integer> queue = new BolckQueneSync<>(15);
        for (int i = 0; i < 10; i++) {
            final int data = i;
            new Thread(() -> {
                while (true) {
                    queue.put(data);
                }
            }).start();
        }
        try {
            System.out.println("sleep");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            while (true){
                System.out.println(queue.get());
            }
        }).start();
    }
}
