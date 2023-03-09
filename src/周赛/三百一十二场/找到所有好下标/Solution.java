package 周赛.三百一十二场.找到所有好下标;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {243655, 573257, 92104, 932396, 605975, 645879, 104190, 32569};
        System.out.println(solution.goodIndices(arr, 3));
    }

    public List<Integer> goodIndices(int[] nums, int k) {
        boolean[] isZ = new boolean[nums.length];
        List<Integer> list = new LinkedList<>();
        Data[] dataz = new Data[nums.length];
        if (k == 1) {
            for (int i = k; i < nums.length - k; i++) {
                list.add(i);
            }
            return list;
        }
        for (int i = 0; i < dataz.length; i++) {
            dataz[i] = new Data(1, 1);
        }
        Data[] dataD = new Data[nums.length];
        for (int i = 0; i < dataD.length; i++) {
            dataD[i] = new Data(1, 1);
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                dataz[i] = new Data(dataz[i - 1].Zk + 1, 1);
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] >= nums[i]) {
                dataD[i] = new Data(1, dataD[i + 1].Dk + 1);
            }
        }
        for (Data datum : dataz) {
            System.out.println(datum.Zk + " " + datum.Dk);
        }
        System.out.println("-----------");

        for (Data data : dataD) {
            System.out.println(data.Zk + " " + data.Dk);
        }

        for (int i = k; i < nums.length - k; i++) {
            if (dataz[i - 1].Zk >= k && dataD[i + 1].Dk >= k) {
                list.add(i);

            }
        }
        return list;
    }
}

class Data {

    int Zk;
    int Dk;

    public Data() {
    }

    public Data(int zk, int dk) {
        Zk = zk;
        Dk = dk;
    }
}
