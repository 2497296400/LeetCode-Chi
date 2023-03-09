package 每日一题系列.每日一题十月.子域名访问计数;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = {
                "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(solution.subdomainVisits(strings));
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            fun(map, cpdomain);
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer entryValue = entry.getValue();
            String valueOf = String.valueOf(entryValue);
            valueOf += " " + entry.getKey();
            ans.add(valueOf);
        }
        return ans;
    }

    private void fun(HashMap<String, Integer> map, String cpdomain) {
        String[] strings = cpdomain.split(" ");
        int sum = Integer.parseInt(strings[0]);
        String string = strings[1];
        toget(string, map, sum);
    }

    private void toget(String string, HashMap<String, Integer> map, int sum) {
        for (int i = 0; i < string.length(); i++) {
            if (i == 0) {
                map.put(string, map.getOrDefault(string, 0) + sum);
            }
            if (string.charAt(i) == '.') {
                map.put(string.substring(i + 1), map.getOrDefault(string.substring(i + 1), 0) + sum);
            }
        }
    }
}
