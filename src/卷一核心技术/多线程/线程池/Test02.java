package 卷一核心技术.多线程.线程池;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* 线程池的计划任务  */
public class Test02 {
    public static void main(String[] args) {
        //创建一个有调度功能的线程池
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        //在延迟2秒后执行任务, schedule(  Runnable任务, 延迟时长, 时间单位)
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId() + " -- " + System.currentTimeMillis() );
            }
        }, 2, TimeUnit.SECONDS);
        //以固定的频率执行任务,开启任务的时间是固定的, 在3秒后执行任务,以后每隔5秒重新执行一次

   /*        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
           @Override
           public void run() {
               System.out.println(Thread.currentThread().getId() + "----在固定频率开启任务---" + System.currentTimeMillis());
               try {
                   TimeUnit.SECONDS.sleep(3);  //睡眠模拟任务执行时间 ,如果任务执行时长超过了时间间隔,则任务完成后立即开启下个任务
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }, 3, 2, TimeUnit.SECONDS);*/

//在上次任务结束后,在固定延迟后再次执行该任务,不管执行任务耗时多长,总是在任务结束后的2秒再次开启新的任务(5s)
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId() + "----在固定频率开启任务---" + System.currentTimeMillis());
                try {
                    TimeUnit.SECONDS.sleep(3);  //睡眠模拟任务执行时间 ,如果任务执行时长超过了时间间隔,则任务完成后立即开启下个任务
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } } }, 3, 2, TimeUnit.SECONDS);
    }}