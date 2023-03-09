package 深度广度遍历问题.字母大小排序;


import java.util.ArrayList;
import java.util.List;

public class Solution01 {
    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        char[] chs = s.toCharArray();
        process(chs, list, 0);
        return list;
    }
    public void process(char[] chs, List<String> list, int index) {
        if (index == chs.length) {
            list.add(new String(chs));
            return;
        }
        if (Character.isLetter(chs[index])) {
            process(chs, list, index + 1);
            chs[index] ^= 32;
            process(chs, list, index + 1);
        } else {
            process(chs, list, index + 1);
        }
    }
}
