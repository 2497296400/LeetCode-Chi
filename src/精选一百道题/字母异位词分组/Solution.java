package 精选一百道题.字母异位词分组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams1(strings));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        boolean[] visit = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (visit[i]) {
                continue;
            }
            int[] nums1 = new int[26];
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            char[] chars = strs[i].toCharArray();
            for (char aChar : chars) {
                nums1[aChar - 'a']++;
            }
            for (int j = i+1; j < strs.length; j++) {
                if (visit[j]) {
                    continue;
                }
                int[] nums2 = new int[26];
                char[] chars1 = strs[j].toCharArray();
                for (char c : chars1) {
                    nums2[c - 'a']++;
                }
                if (Arrays.equals(nums1, nums2)) {
                    list.add(strs[j]);
                    visit[j] = true;
                }
            }
            visit[i] = true;
            lists.add(list);
        }
        return lists;
    }
    public static List<List<String>> groupAnagrams1(String [] strs){
        HashMap<String,ArrayList<String>>map=new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key= String.valueOf(chars);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
