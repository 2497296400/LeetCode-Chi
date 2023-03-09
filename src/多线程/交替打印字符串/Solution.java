package 多线程.交替打印字符串;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        CountDownLatch latch = new CountDownLatch(4);
        Runnable fizz = new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.fizz(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("fizz");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            }
        };
        Runnable buzz = new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.buzz(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("buzz");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                     latch.countDown();
                }
            }
        };
        Runnable fizzbuzz = new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.fizzbuzz(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("fizzbuzz");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                       latch.countDown();
                }
            }
        };
        Runnable number = new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.number(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.println(value);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            }
        };
        new Thread(fizz).start();
        new Thread(buzz).start();
        new Thread(fizzbuzz).start();
        new Thread(number).start();
        latch.await();
        System.out.println("done...");
    }
}

class FizzBuzz {
    private int n;
    private volatile boolean flag = false;
    private volatile boolean toEnd = false;
    private Semaphore number = new Semaphore(1);
    private Semaphore three = new Semaphore(0);
    private Semaphore five = new Semaphore(0);
    private Semaphore threeAndFive = new Semaphore(0);
    public FizzBuzz(int n) {
        this.n = n;
    }
    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 0; i <= n; i += 3) {
            if (!toEnd) {
                three.acquire();
                if(toEnd){
                    break;
                }
                printFizz.run();
                flag = false;
                number.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 0; i <= n; i += 5) {
            if (!toEnd) {
                five.acquire();
                if(toEnd){
                    break;
                }
                printBuzz.run();
                flag = false;
                number.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 0; i <= n; i += 15) {
            if (!toEnd) {
                threeAndFive.acquire();
                if(toEnd){
                    break;
                }
                printFizzBuzz.run();
                flag = false;
                number.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            number.acquire();
            if (i % 15 == 0) {
                flag = true;
                threeAndFive.release();
            } else if (i % 3 == 0) {
                flag = true;
                three.release();
            } else if (i % 5 == 0) {
                flag = true;
                five.release();
            } else {
                printNumber.accept(i);
                number.release();
            }
            while (flag) {
            }

        }
        toEnd = true;
        three.release();
        threeAndFive.release();
        five.release();
    }
}