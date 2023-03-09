package 每日一题系列.每日一题九月.按照频率将数组升序排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.frequencySort(arr)));
    }

    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        pq pq = new pq(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.sum - o2.sum == 0 ? o2.curIndex - o1.curIndex : o1.sum - o2.sum;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            Data data = new Data(1, nums[i]);
            if (pq.isCon(data)) {
                pq.upDate(data);
            } else {
                pq.push(data);
            }
        }
        int[] ans = new int[nums.length];
        int len = 0;
        while (!pq.isEmp()) {
            Data pop = pq.pop();
            while (pop.sum > 0) {
                ans[len++] = pop.curIndex;
                pop.sum--;
            }
        }
        return ans;
    }

    public class Data {
        int sum;
        int curIndex;

        public Data(int data, int curIndex) {
            this.sum = data;
            this.curIndex = curIndex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Data data = (Data) o;

            return curIndex == data.curIndex;
        }

        @Override
        public int hashCode() {
            return curIndex;
        }
    }

    public class pq {
        int heapSize;
        ArrayList<Data> heap;
        HashMap<Data, Integer> indexMap;
        Comparator<Data> comparator;

        public pq(Comparator<Data> comparator) {
            this.comparator = comparator;
            heap = new ArrayList<>();
            indexMap = new HashMap<>();
            heapSize = 0;
        }

        private void heapIndex(int idx) {
            while (comparator.compare(heap.get(idx), heap.get((idx - 1) / 2)) < 0) {
                swap(idx, (idx - 1) / 2);
                idx = (idx - 1) / 2;
            }
        }

        private void swap(int first, int second) {
            Data fd = heap.get(first);
            Data sd = heap.get(second);

            indexMap.put(fd, second);
            indexMap.put(sd, first);

            heap.set(first, sd);
            heap.set(second, fd);

        }

        private void heapfiy(int idx) {
            int left = idx * 2 + 1;
            while (left < heapSize) {
                int best = left + 1 < heapSize && comparator.compare(heap.get(left + 1), heap.get(left)) < 0 ? left + 1 : left;
                best = comparator.compare(heap.get(best), heap.get(idx)) < 0 ? best : idx;
                if (best == idx) {
                    break;
                }
                swap(idx, best);
                idx = best;
                left = idx * 2 + 1;
            }
        }

        public boolean isEmp() {
            return heapSize == 0;
        }

        private boolean isCon(Data data) {
            return indexMap.containsKey(data);
        }

        public void push(Data data) {
            heap.add(data);
            indexMap.put(data, heapSize);
            heapIndex(heapSize++);
        }

        public Data pop() {
            Data ans = heap.get(0);
            swap(0, heapSize - 1);
            heap.remove(--heapSize);
            indexMap.remove(ans);
            heapfiy(0);
            return ans;
        }

        private void remove(Data data) {
            Data replace = heap.get(heapSize - 1);
            Integer oldIndex = indexMap.get(data);
            indexMap.remove(data);
            heap.remove(--heapSize);
            if (replace.curIndex != data.curIndex) {
                heap.set(oldIndex, replace);
                indexMap.put(replace, oldIndex);
                upDate(replace);
            }
        }

        private void upDate(Data replace) {
            Integer integer = indexMap.get(replace);
            Data data = heap.get(integer);
            data.sum++;
            replace=data;
            indexMap.put(replace, integer);
            heap.set(integer, replace);
            heapIndex(integer);
            heapfiy(integer);
        }
    }

}