package 每日一题系列.每日一题十月.用栈操作构建数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> buildArray(int[] target, int n) {
        String p = "Push";
        String d = "Pop";
        List<String> asn = new ArrayList<>();
        Arrays.sort(target);
        int curIndx = 1;
        for (int cur : target) {
            while (curIndx < cur) {
                asn.add(p);
                asn.add(d);
                curIndx++;
            }
            if (cur == curIndx) {
                asn.add(p);
            }
            curIndx++;
        }
        while (curIndx<n){
            asn.add(p);
            asn.add(d);
            curIndx++;
        }
        return asn;
    }
}
