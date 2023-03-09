package 每日一题系列.每日一题七月.Lisp语法解析难题不会;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String s = "(let x 2 (mult x (let x 3 y 4 (add x y))))";
        int evaluate = new Solution().evaluate(s);
        System.out.println( evaluate);
    }
    public int evaluate(String expression) {
        HashMap<String,Integer>map=new HashMap<>();
        return calculate(map,expression);
    }
    int solve(Map<String,Integer> map,String s){
        //计算在外层变量赋值为map的情况下，求s的表达式值，本方法计算的都是开头有let的式子
        //先把映射复制一份：
        Map<String,Integer> newMap=new HashMap<>();
        for(String t:map.keySet()){newMap.put(t,map.get(t));}
        //先把结果的表达式摘出来：
        int r=nextSpace(s,s.length()-1,-1);
        String ans=s.substring(r+1,s.length()-1);//存储结果的表达式
        //此时的r应该是赋值操作后的那个空格的位置，也即是赋值表达式终止的位置
        //下边处理赋值的若干表达式：
        for(int i=4;i<r;){
            int j=i;
            i=nextSpace(s,i,1);
            String a=s.substring(j+1,i);
            j=i;
            i=nextSpace(s,i,1);
            String b=s.substring(j+1,i);
            newMap.put(a,calculate(newMap,b));
        }
        return calculate(newMap,ans);
    }
    int calculate(Map<String,Integer> map,String s){
        if(s.charAt(0)!='('){
            if(map.containsKey(s)){return map.get(s);}
            return Integer.parseInt(s);
        }
        char c=s.charAt(1);
        if(c=='l'){return solve(map,s);}
        //add：加，mult：乘，，首先开头有括号括着的肯定是这两种运算
        int i=s.indexOf(' ');//定位在要处理的两个变量之前的空格；
        int j=i;
        i=nextSpace(s,i,1);
        int a=calculate(map,s.substring(j+1,i)),b=calculate(map,s.substring(i+1,s.length()-1));
        return c=='a'?a+b:a*b;
    }
    int nextSpace(String s,int k,int plus){
        //在此时k定位某式子之前的时候，找到跳过下边完整表达式的下一个空格的位置
        k+=plus;
        char c=s.charAt(k);
        if(c=='('||c==')'){
            //第一个是表达式
            int d=0;
            for(;;k+=plus){
                c=s.charAt(k);
                if(c=='('){d+=plus;}
                else if(c==')'){d-=plus;}
                if(d==0){
                    k+=plus;
                    break;
                }
            }
        }
        else{while(s.charAt(k)!=' '){k+=plus;}}
        return k;
    }
}
