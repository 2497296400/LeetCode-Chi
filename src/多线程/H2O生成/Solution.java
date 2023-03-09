package 多线程.H2O生成;

import java.util.concurrent.Semaphore;

public class Solution {
    class H2O {
        private  Semaphore curH=new Semaphore(2);
        private  Semaphore curO=new Semaphore(0);
        public H2O() {
        }
        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            curH.acquire();
            releaseHydrogen.run();
            if(curO.getQueueLength()==0){
            curO.release();}
        }
        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            if(curH.getQueueLength()==0){
            curO.acquire();
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            curH.release();
            curH.release();
        }}
    }
}
