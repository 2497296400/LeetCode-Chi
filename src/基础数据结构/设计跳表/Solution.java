package 基础数据结构.设计跳表;

public class Solution {
    public static void main(String[] args) {
        SkiplistTest skiplist = new SkiplistTest();
        skiplist.add(0);
        skiplist.add(5);
        skiplist.add(2);
        skiplist.add(1);
        for(int i=0;i<50000000;i++){
            skiplist.add(i);
        }
        System.out.println(skiplist.search(5));
        System.out.println(skiplist.erase(2));
        System.out.println(skiplist.curLevel);
    }
}
