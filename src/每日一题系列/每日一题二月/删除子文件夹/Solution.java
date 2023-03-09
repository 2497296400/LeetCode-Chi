package 每日一题系列.每日一题二月.删除子文件夹;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        System.out.println(solution.removeSubfolders(strings));
    }


    public List<String> removeSubfolders(String[] folder) {
        List<String> asn = new ArrayList<>();
        Tire tire = new Tire();
        for (String s : folder) {
            tire.insert(s);
        }
        Set<String> set = tire.tireHashMap.keySet();
        getAns(asn, tire, "");
        return asn;
    }

    private void getAns(List<String> asn, Tire tire, String cur) {
        if (tire.isEed) {
            asn.add(cur);
            return;
        }
        HashMap<String, Tire> map = tire.tireHashMap;
        for (Map.Entry<String, Tire> entry : map.entrySet()) {
            String key = entry.getKey();
            Tire value = entry.getValue();
            getAns(asn, value, cur + key);
        }
    }
}

class Tire {
    HashMap<String, Tire> tireHashMap;
    boolean isEed;

    public Tire() {
        tireHashMap = new HashMap<>();
        isEed = false;
    }

    public void insert(String s) {
        Tire root = this;
        String[] strings = s.split("/");
        for (int i = 1; i < strings.length; i++) {
            String string = "/" + strings[i];
            if (!root.tireHashMap.containsKey(string)) {
                root.tireHashMap.put(string, new Tire());
            }
            root = root.tireHashMap.get(string);
            if (i == strings.length - 1) {
                root.isEed = true;
            }
        }
    }
}
