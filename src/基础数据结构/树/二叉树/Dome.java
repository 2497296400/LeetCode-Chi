package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class Dome {
    static List<String> ans;

    public static void main(String[] args) {
        String ip = "25525511135";
       ans = new ArrayList<>();
        getAns(ip, "", 0, 4);
        System.out.println(ans);
    }

    private static void getAns(String ip, String cur, int index, int lessSum) {
        if (lessSum == 0) {
            if (index == ip.length()) {
                ans.add(cur);
            }
            return;
        }
        
        for (int i = index; i < Math.min(index + 3, ip.length()); i++) {
            String substring = ip.substring(index, i + 1);
            if (substring.length() > 1 && substring.startsWith("0")) {
                continue;
            }
            if (Integer.parseInt(substring) <= 255) {
                getAns(ip, cur + substring + (lessSum == 1 ? "" : "."), i + 1, lessSum - 1);
            }
        }
    }
}
