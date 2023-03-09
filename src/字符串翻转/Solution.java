package 字符串翻转;

public class Solution {
    public String reverseWords(String s) {
        String [] str=s.split(" ");
        StringBuffer sb=new StringBuffer();
        sb.append("\"");
        for(String st:str){
            sb.append(new StringBuffer(st).reverse());
            sb.append(" ");
        }
        sb.delete(sb.length()-1,sb.length());
        sb.append("\"");
        return sb.toString();
    }
}
