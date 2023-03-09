package 周赛.三百场周赛;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String s = "aowrzlqeyicbnbdyvfsmbrgbkethbuueraldpqfwkukmvmphuccxjdrczf";
        String mes = "uoeazfvmhiqjnvdverxxglfubcfrnhrsmabdqdaqolvjnilt ";
        System.out.println(new Solution().decodeMessage(s, mes));
    }

    public String decodeMessage(String key, String message) {
        Map<Character, Integer> map = new HashMap<>();
        String replaceAll = key.replaceAll(" ", "");
        char[] ar = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] chars = replaceAll.toCharArray();
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], index++);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = message.toCharArray();
        String[] strings = message.split(" ");
        int len = 0;
//        for (String string : strings) {
//            len++;
//            char[] array = string.toCharArray();
//            for (int i = 0; i < array.length; i++) {
//                stringBuilder.append(ar[map.get(array[i])]);
//            }
//            if (len != strings.length ) {
//                stringBuilder.append(" ");
//            }
//        }
        for(int i=0;i<charArray.length;i++){
            if(charArray[i]!=' '){
                stringBuilder.append(ar[map.get(charArray[i])]);
            }
            else {
                stringBuilder.append(" ");

            }
        }

        return String.valueOf(stringBuilder);
    }
}
