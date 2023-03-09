package 每日一题系列.每日一题十一月.设计Goal解析器;

public class Solution {
    public String interpret(String command) {
        char[] chars = command.toCharArray();
        StringBuilder stringBuilder= new StringBuilder();
        for(int i= 0;i<chars.length;i++){
            if(chars[i]=='G'){
                stringBuilder.append('G');
            }else if(chars[i]=='('){
                if(chars[i]==')'){
                    stringBuilder.append('o');
                    i++;
                }else {
                    stringBuilder.append("al");
                    i+=2;
                }
            }
        }
        return String.valueOf(stringBuilder);
    }
}
