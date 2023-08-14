package 手写一系列东西.限流算法.滑动窗口限流;

import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiterSlidingWindows {
    private int qps;

    private long windowSize = 1000;
    private Integer windowConut = 10;
    private WindowsInfo[] windowsArray = new WindowsInfo[windowConut];

    public RateLimiterSlidingWindows(int qps) {
        this.qps = qps;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < windowConut; i++) {
            windowsArray[i] = new WindowsInfo(currentTimeMillis, new AtomicInteger(0));
        }
    }

    public synchronized boolean tryAcquire() {
        long currentTimeMillis = System.currentTimeMillis();
        // 当前时间戳对应的窗口下标
        int currentIndex = (int) (currentTimeMillis % windowSize / (windowSize / windowConut));
        int sum = 0;
        // 遍历所有窗口，如果当前窗口已经过期，那么清零
        for (int i = 0; i < windowsArray.length; i++) {
            WindowsInfo windowsInfo = windowsArray[i];
            if ((currentTimeMillis - windowsInfo.getTime()) > windowSize) {
                windowsInfo.getNumber().set(0);
                windowsInfo.setTime(currentTimeMillis);
            }
            if (currentIndex == i && windowsInfo.getNumber().get() < qps) {
                windowsInfo.getNumber().incrementAndGet();
            }
            sum += windowsInfo.getNumber().get();
        }
        return sum <= qps;
    }

    public static void main(String[] args) {
        RateLimiterSlidingWindows rateLimiterSlidingWindows = new RateLimiterSlidingWindows(10);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                boolean limit = rateLimiterSlidingWindows.tryAcquire();
                if (limit) {
                    System.out.println("正常访问");
                } else {
                    System.out.println("限流");
                }
            }).start();
        }
    }
}

class WindowsInfo {
    private long time;
    private AtomicInteger number;

    public WindowsInfo(long time, AtomicInteger number) {
        this.time = time;
        this.number = number;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public AtomicInteger getNumber() {
        return number;
    }

    public void setNumber(AtomicInteger number) {
        this.number = number;
    }
}
