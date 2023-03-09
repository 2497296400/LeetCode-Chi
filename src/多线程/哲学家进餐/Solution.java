package 多线程.哲学家进餐;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {
}

class DiningPhilosophers {
    Semaphore[] lock = {
            new Semaphore(1),
            new Semaphore(0),
            new Semaphore(0),
            new Semaphore(0),
            new Semaphore(0),
    };

    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        lock[philosopher].acquire();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        lock[(philosopher+1)%5].release();
    }
}
class DiningPhilosophers1 {
    private  ReentrantLock lock=new ReentrantLock();
    private Lock lock1=new ReentrantLock();

    public DiningPhilosophers1() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
    try {
        lock1.lock();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();

        //放下左边叉子
        putLeftFork.run();
        //放下右边叉子
        putRightFork.run();
    }finally {
        lock1.unlock();
    }
    }
}