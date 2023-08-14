package 手写一系列东西.限流算法.漏桶算法;

public class LeakyBucketAlgorithm{
    private int capacity;
    private int water;
    private long lastTime;

    public LeakyBucketAlgorithm(int capacity) {
        this.capacity = capacity;
        this.water = 0;
        this.lastTime = System.currentTimeMillis();
    }

    public synchronized boolean tryAcquire() {
        long now = System.currentTimeMillis();
        water = Math.max(0, (int) (water - (now - lastTime)));
        lastTime = now;
        if (water < capacity) {
            water++;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        LeakyBucketAlgorithm leakyBucketAlgorithm = new LeakyBucketAlgorithm(10);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                boolean limit = leakyBucketAlgorithm.tryAcquire();
                if (limit) {
                    System.out.println("正常访问");
                } else {
                    System.out.println("限流");
                }
            }).start();
        }
    }
}
