package 每日一题系列.每日一题二月.警告一小时内使用相同员工卡大于等于三次的人;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] f = {"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
        String[] s = {"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};
        System.out.println(solution.alertNames(f, s));
    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Data[] data = new Data[keyName.length];
        for (int i = 0; i < keyName.length; i++) {
            data[i] = new Data(keyName[i], keyTime[i]);
        }
        Arrays.sort(data, (o1, o2) -> {
            if (Objects.equals(o1.name, o2.name)) {
                return o1.time.compareTo(o2.time);
            }
            return o1.name.compareTo(o2.name);
        });
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int l = 0;
        int r = 0;
        while (r < data.length) {
            String curTime = data[l].time;
            String curName = data[l].name;
            while (r < data.length && isFun(data[r].time, curTime) && curName.equals(data[r].name)) {
                r++;
            }
            if (r - 3 >= l) {
                set.add(curName);
            }
            if (l >= r) {
                r++;
            }
            l++;
        }
        List<String> strings = new ArrayList<>(set.stream().toList());
        strings.sort(Comparator.naturalOrder());
        return strings;
    }

    private boolean isFun(String time, String curTime) {
        int secondF = 0;
        int secondS = 0;
        String[] ts = time.split(":");
        String[] split = curTime.split(":");
        secondF += Integer.parseInt(ts[0]) * 60 + Integer.parseInt(ts[1]);
        secondS += Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        return secondF - secondS <= 60;
    }
}

class Data {
    String name;
    String time;

    public Data(String name, String time) {
        this.name = name;
        this.time = time;
    }
}
