package 每日一题系列.每日一题七月.并查集.按公因数计算最大组件大小.并查集;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int curMax = 0;

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7, 4, 12, 21, 39};
        int[] nums2 = {4, 6, 15, 35};
        Solution solution = new Solution();
        System.out.println(solution.largestComponentSize(nums));
    }
    public int largestComponentSize(int[] nums) {
        int numMax = Arrays.stream(nums).max().getAsInt();
        UnionFind unionFind = new UnionFind(numMax + 1);
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    unionFind.union(num, i);
                    unionFind.union(num, num / i);
                }
            }
        }
        int[] count = new int[numMax + 1];
        int max = 0;
        for (int num : nums) {
            Element father = unionFind.getHead(new Element(num));
            count[father.var]++;
            max = Math.max(max, count[father.var]);
        }
        return max;
    }

    static class Element {
        int var;
        public Element(int var) {
            this.var = var;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Element element = (Element) o;

            return var == element.var;
        }

        @Override
        public int hashCode() {
            return var;
        }
    }

    class UnionFind {
        public HashMap<Integer, Element> elementHashMap;
        public HashMap<Element, Element> fatherMap;
        public HashMap<Element, Integer> sizeMap;

        public UnionFind(int n) {
            elementHashMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                Element element = new Element(i);
                elementHashMap.put(i, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }
        public void union(int first, int second) {
            Element firstFather = getHead(elementHashMap.get(first));
            Element secondFather =getHead(elementHashMap.get(second));
            if (firstFather != secondFather) {
                int firstSize = sizeMap.get(firstFather);
                int secondSize = sizeMap.get(secondFather);
                Element big = firstSize >= secondSize ? firstFather : secondFather;
                Element small = big == firstFather ? secondFather : firstFather;
                fatherMap.put(small, big);
                curMax = Math.max(curMax, firstSize + secondSize);
                sizeMap.put(big, firstSize + secondSize);
                sizeMap.remove(small);
            }
        }
        private Element getFather(Element first) {
            Stack<Element> stack = new Stack<>();
            while (first != fatherMap.get(first)) {
                stack.push(first);
                first = fatherMap.get(first);
            }
            while (!stack.isEmpty()) {
                fatherMap.put(stack.pop(), first);
            }
            return first;
        }
        private  Element getHead(Element fisrt){
            if(fisrt!=fatherMap.get(fisrt)){
                fatherMap.put(fisrt,getHead(fatherMap.get(fisrt)));
            }
            return fatherMap.get(fisrt);
        }
    }
}


