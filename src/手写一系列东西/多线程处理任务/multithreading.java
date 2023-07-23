package 手写一系列东西.多线程处理任务;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class multithreading {
    public static void main(String[] args) throws InterruptedException {
        多线程(10000);
        System.out.println("---------");
        // 单线程();
        System.out.println("---------");
        //Stream流多线程(10000);
    }

    public static void Stream流多线程(int size) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Map<Integer, int[]>> cM = new HashMap<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long s = System.currentTimeMillis();
        list.parallelStream().forEach(integer -> {
            Map<Integer, Map<Integer, int[]>> map = new HashMap<>();
            Map<Integer, int[]> map1 = new HashMap<>();
            int[] arr = new int[2];
            arr[0] = integer;
            arr[1] = integer;
            map1.put(integer, arr);
            map.put(integer, map1);
            cM.put(integer, map1);
//            if (integer == 9999) {
//                int i = 1 / 0;
//            }
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(cM.size());
        System.out.println(System.currentTimeMillis() - s);
    }

    public static void 单线程(int size) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Map<Integer, int[]>> cM = new HashMap<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long s = System.currentTimeMillis();
        for (Integer integer : list) {
            Map<Integer, Map<Integer, int[]>> map = new HashMap<>();
            Map<Integer, int[]> map1 = new HashMap<>();
            int[] arr = new int[2];
            arr[0] = integer;
            arr[1] = integer;
            map1.put(integer, arr);
            map.put(integer, map1);
            cM.put(integer, map1);

        }
        System.out.println(cM.size());
        System.out.println(System.currentTimeMillis() - s);
    }

    public static void 多线程(int size) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Map<Integer, int[]>> cM = new HashMap<>();
        List<Callable<Map<Integer, Map<Integer, int[]>>>> tasks = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long s = System.currentTimeMillis();
        for (Integer integer : list) {
            tasks.add(() -> {
                Map<Integer, Map<Integer, int[]>> map = new HashMap<>();
                Map<Integer, int[]> map1 = new HashMap<>();
                int[] arr = new int[2];
                arr[0] = integer;
                arr[1] = integer;
                map1.put(integer, arr);
                map.put(integer, map1);
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return map;
            });
        }
        ExecutorService executorService = Executors.newFixedThreadPool(
                //获取当前系统的CPU核心数
                Runtime.getRuntime().availableProcessors()
        );
        List<Future<Map<Integer, Map<Integer, int[]>>>> futures = executorService.invokeAll(tasks);
        futures.stream().map(v -> {
            try {
                return v.get();
            } catch (InterruptedException e) {

            } catch (ExecutionException e) {
            }
            return new HashMap<Integer, Map<Integer, int[]>>();
        }).forEach(cM::putAll);
        executorService.shutdown();
        System.out.println(cM.size());
        System.out.println(System.currentTimeMillis() - s);
    }

}
