package 深度广度遍历问题.电话组合排列;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(letterCombinations("24"));
    }
    public static List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put( '5', "jkl");
        map.put( '6', "mno");
        map.put( '7', "pqs");
        map.put( '8', "tuv");
        map.put( '9', "wxyz");
        List<String>res = new ArrayList<>();
        if(digits.length()<1){
            return res;
        }
        StringBuilder str=new StringBuilder();
        DFS(res,digits,0,str,map);
        return  res;

    }

    private static  void DFS(List<String> res, String digits, int dept, StringBuilder str,HashMap<Character,String>map) {
        if(str.length()==digits.length()){
            res.add(String.valueOf(str));
            return;
        }
        char charAt = digits.charAt(dept);
        String maps = map.get(charAt);
        int len=maps.length();

        for(int i=0;i<len;i++){
            str.append(maps.charAt(i));
            DFS(res,digits,dept+1,str,map);
            str.deleteCharAt(dept);
        }
    }
}
