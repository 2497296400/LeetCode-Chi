package 手写一系列东西.利用ConcurrentHashMap实现分段锁;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SegmentLock {
    ConcurrentHashMap<String, Lock> map = new ConcurrentHashMap<>();

    public void lock(String key) {
        Lock lock = map.get(key);
        if (lock == null) {
            lock = new ReentrantLock();
            Lock existing = map.putIfAbsent(key, lock);
            if (existing != null) {
                lock = existing;
            }
        }
        lock.lock();
    }

    public void unluck(String key) {
        Lock lock = map.get(key);
        if (lock != null && lock instanceof ReentrantLock) {
            ReentrantLock reentrantLock = (ReentrantLock) lock;
            if (reentrantLock.isHeldByCurrentThread()) {
                reentrantLock.unlock();
            }
        }
    }
}
