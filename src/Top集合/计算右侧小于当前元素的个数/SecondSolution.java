package Top集合.计算右侧小于当前元素的个数;

import java.util.*;

public class SecondSolution {
    int[] a;

    public static void main(String[] args) {
        SecondSolution secondSolution = new SecondSolution();
        int[] arr = {5, 2, 6, 1};
        System.out.println(secondSolution.countSmaller(arr));
    }

    public List<Integer> countSmaller(int[] nums) {
        IndexTree indexTree = new IndexTree(nums.length);
        dis(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int id = getId(nums[i]);
            list.add(indexTree.quary(id - 1));
            indexTree.add(1, id);
        }
        Collections.reverse(list);
        return list;
    }

    private int getId(int cur) {
        return Arrays.binarySearch(a, cur) + 1;
    }

    private void dis(int[] num) {
        Set<Integer> set = new HashSet<>();
        for (int i : num) {
            set.add(i);
        }
        int size = set.size();
        a = new int[size];
        int index = 0;
        for (Integer integer : set) {
            a[index++] = integer;
        }
        Arrays.sort(a);
    }
}

class IndexTree {
    int[] indexTree;
    int N;

    public IndexTree(int N) {
        this.N = N;
        indexTree = new int[N + 4];
    }

    public void add(int num, int index) {
        while (index <= N) {
            indexTree[index] += num;
            index += index & (-index);
        }
    }

    public int quary(int index) {
        int sum = 0;
        while (index > 0) {
            sum += indexTree[index];
            index -= index & (-index);
        }
        return sum;
    }
}
