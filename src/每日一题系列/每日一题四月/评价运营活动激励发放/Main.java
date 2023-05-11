package 每日一题系列.每日一题四月.评价运营活动激励发放;

import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int anInt = scanner.nextInt();
        ReviewEncourage encourage = new ReviewEncourage(anInt);
        
    }
}

class ReviewEncourage {
    private volatile int count;
    private AtomicInteger atomicInteger;
    private volatile int n;
    private Semaphore one;
    private Semaphore tow;

    public ReviewEncourage(int n) {
        atomicInteger = new AtomicInteger(1);
        one = new Semaphore(1);
        tow = new Semaphore(0);

        this.n = n;
    }      // 构造函数,n为中奖用户数


    public class PrizePool {
        public void send(String input) {
            System.out.print(input);
        }
    }

    public void bonus(PrizePool prizePool) throws InterruptedException {
        while (count < n) {
            one.acquire();
            prizePool.send("A");
            count++;
            tow.release();
        }
    }  // 仅能打印A，表示发放积分

    public void coupon(PrizePool prizePool) throws InterruptedException {
        while (count < n) {
            if ((count / n) % n == 0) {
                tow.acquire();
                prizePool.send("B");
                one.release();
                count++;
            }
        }

    }  // 仅能打印B，表示发}放优惠券

    public void contribution(PrizePool prizePool) throws InterruptedException {
        while (count < n) {
            if ((count / n) % n != 0) {
                tow.acquire();
                prizePool.send("B");
                one.release();
                count++;
            }
        }
    }  // 仅能打印C，表示发放贡献值
}
