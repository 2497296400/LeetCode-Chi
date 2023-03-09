package 每日一题系列.每日一题七月.字典树.创建字典树.前缀和后缀搜索;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    static class Tire {
        public int pass;
        public int end;
        public Set<Integer>set;
        Tire[] nexts;
        public Tire() {
            pass = 0;
            end = 0;
            nexts = new Solution.Tire[26];
            set=new HashSet<>();
        }
        private void insertHead(Tire tire, String word,int curIndex) {
            char[] chars = word.toCharArray();
            Tire root = tire;
            root.pass++;
            int index = 0;
            for (char aChar : chars) {
                index=aChar-'a';
                if(root.nexts[index]==null){
                    root.nexts[index]=new Tire();
                }
                root=root.nexts[index];
                root.pass++;
                root.set.add(curIndex);
            }
            root.end++;
        }
        private void insertTail(Tire tire, String word,int curIndex) {
            char[] chars = word.toCharArray();
            Tire root = tire;
            root.pass++;
            int index=0;
            for(int j=chars.length-1;j>=0;j--){
                index=chars[j]-'a';
                if(root.nexts[index]==null){
                    root.nexts[index]=new Tire();
                }
                root=root.nexts[index];
                root.pass++;
                root.set.add(curIndex);
            }
            root.end++;
        }
        public int search(String pref, String suff, Tire tireHead,Tire tireTail) {
            if (pref == null||suff==null) {
                return 0;
            }
            char[]charPref  = pref.toCharArray();
            char[] charSuff = suff.toCharArray();
            Set <Integer>set1 = new HashSet();
            Set <Integer>set2 = new HashSet();
            int secondIndex=-1;
            Tire tire1=tireHead;
            Tire tire2=tireTail;
            for (char c : charPref) {
                if(tire1.nexts[c-'a']==null){
                    return -1;
                }
                tire1=tire1.nexts[c-'a'];
            }
            set1=tire1.set;
           for(int i=charSuff.length-1;i>=0;i--){
                if(tire2.nexts[charSuff[i]-'a']==null){
                    return -1;
                }
                tire2=tire2.nexts[charSuff[i]-'a'];
            }
            set2=tire2.set;
            int max=0;
            for (Integer integer : set1) {
                for (Integer integer1 : set2) {
                    if(integer.equals(integer1)){
                        max=Math.max(max,integer);
                    }
                }
            }

            return max;
        }

    }
  static   class WordFilter {
        Tire tireHead=new Tire();
        Tire tireTail=new Tire();
        String[] strings;
        public WordFilter(String[] words) {
        strings=words;
        for(int i=0;i<strings.length;i++){
                tireHead.insertHead(tireHead,strings[i],i);
                tireTail.insertTail(tireTail,strings[i],i);
        }
        }
        public int f(String pref, String suff) {
            return new Tire().search(pref,suff,tireHead,tireTail);
        }
    }
    public static void main(String[] args) {
        String [] strings={"abbba","abba"};
        String s="ab";
        String p="ba";
        WordFilter wordFilter=new WordFilter(strings);
        System.out.println(wordFilter.f(s,p));
    }
}