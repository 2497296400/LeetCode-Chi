package 基础数据结构.手写堆;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Test<T> {
    private ArrayList<T> heap;
    private HashMap<T, Integer> indexMap;
    private int heapSize;
    private Comparator<? super T> comparator;

    public Test(Comparator<? super T> comparator) {
        this.comparator = comparator;
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
        heapSize = 0;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    private void heapInsert(int index) {
        while (comparator.compare(heap.get(index), heap.get((index - 1) >> 1)) < 0) {
            swap(index, (index - 1) >> 1);
        }
    }

    private void heapfiy(int index) {
        int left = index << 1 | 1;
        while (left < heapSize) {
            int smallLeftOrRight = left + 1 < heapSize && comparator.compare(heap.get(left + 1), heap.get(left)) < 0 ? left + 1 : left;
            int curSmall = comparator.compare(heap.get(smallLeftOrRight), heap.get(index));
            if (curSmall == index) {
                break;
            }
            swap(index, curSmall);
            index = curSmall;
            left = index << 1 | 1;
        }
    }

    private void swap(int f, int s) {
        T ff = heap.get(f);
        T ss = heap.get(s);
        indexMap.put(ff, s);
        indexMap.put(ss, f);
        heap.set(f, ss);
        heap.set(s, ff);
    }

    public void push(T obj) {
        heap.add(obj);
        indexMap.put(obj, heapSize);
        heapInsert(heapSize++);
    }

    public T pop() {
        T ans = heap.get(0);
        swap(0, heapSize - 1);
        indexMap.remove(ans);
        heap.remove(--heapSize);
        heapfiy(0);
        return ans;
    }

    public void upDate(T obj) {
        heapInsert(indexMap.get(obj));
        heapfiy(indexMap.get(obj));
    }

    public void remove(T obj) {
        Integer index = indexMap.get(obj);
        T replace = heap.get(heapSize-1);
        heap.remove(--heapSize);
        indexMap.remove(obj);
        if (replace != obj) {
            heap.set(index, replace);
            indexMap.put(replace, index);
            upDate(replace);
        }
    }
}
