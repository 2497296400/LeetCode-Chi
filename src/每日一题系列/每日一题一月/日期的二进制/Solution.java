package 每日一题系列.每日一题一月.日期的二进制;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public String convertDateToBinary(String date) {
        String[] f = date.split("-");
        List<String> ss = new ArrayList<>();
        for (String s : f) {
            int num = Integer.parseInt(s);
            String binary = Integer.toBinaryString(num);
            ss.add(binary);
        }
        return String.join("-", ss);
    }
}
