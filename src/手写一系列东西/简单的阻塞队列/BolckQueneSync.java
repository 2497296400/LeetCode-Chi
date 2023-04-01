package 手写一系列东西.简单的阻塞队列;

import java.util.ArrayDeque;

public class BolckQueneSync<E>  implements  BolckQuene<E>{
    private final  static  int DEAUL_MAX_CONUT = 10;
    private  final  int maxCount;
    private  final ArrayDeque<E>blockingQueue;

    public BolckQueneSync() {
       this(DEAUL_MAX_CONUT);
    }
    public BolckQueneSync(int size){
        blockingQueue = new ArrayDeque<>(size);
        this.maxCount = size;
    }
    
    @Override
    public void put(E e) {
        synchronized (blockingQueue){
            while (blockingQueue.size()==maxCount){
                try {
                    System.out.println("队列满了"+" " + Thread.currentThread().getName());
                    blockingQueue.wait();
                } catch (InterruptedException ex) {
                        ex.printStackTrace();
                }
            }
            blockingQueue.add(e);
            blockingQueue.notifyAll();
        }
    }

    @Override
    public E get() {
        synchronized (blockingQueue){
            while (blockingQueue.size()==0){
                try {
                    System.out.println("队列空了"+" "+ Thread.currentThread().getName());
                    blockingQueue.wait();
                } catch (InterruptedException e) {
                   e.printStackTrace();
                }
            }
            blockingQueue.notifyAll();
        }
        return blockingQueue.removeFirst();
    }

    @Override
    public int size() {
        return blockingQueue.size();
    }
}
