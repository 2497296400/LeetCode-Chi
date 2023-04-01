package 每日一题系列.每日一题三月.字符流;

public class StreamChecker {
    class Tire {
        boolean isEnd;
        Tire next[];

        public Tire() {
            next = new Tire[26];
        }
    }

    Tire root = new Tire();
    StringBuilder stringBuilder = new StringBuilder();

    public void insert(String s) {
        Tire curNode = root;
        StringBuilder stringBuilder = new StringBuilder(s);
        StringBuilder reverse = stringBuilder.reverse();
        for (int i = 0; i < reverse.length(); i++) {
            int index = reverse.charAt(i) - 'a';
            if (curNode.next[index] == null) {
                curNode.next[index] = new Tire();
            }
            curNode = curNode.next[index];
        }
        curNode.isEnd = true;
    }

    public boolean search(StringBuilder s) {
        Tire curNode = root;
        int len = s.length() - 1;
        while (len >= 0) {
            int index = s.charAt(len--) - 'a';
            if (curNode.isEnd) {
                return true;
            }
            if (curNode.next[index] == null) {
                return false;
            }
            curNode = curNode.next[index];
        }
        return curNode.isEnd;
    }


    public StreamChecker(String[] words) {
        for (String word : words) {
            insert(word);
        }
    }

    public boolean query(char letter) {
        stringBuilder.append(letter);
        return search(stringBuilder);

    }
     //,["a"],["a"],["b"],["b"],["b"],["a"],["a"],["b"],["b"],["a"],["a"],["a"],["a"],["b"],["a"],["b"],["b"],["b"],["a"],["b"],["b"],["b"],["a"],["a"],["a"],["a"],["a"],["b"],["a"],["b"],["b"],["b"],["a"],["a"],["b"],["b"],["b"],["a"],["b"],["a"]]
    public static void main(String[] args) {
        StreamChecker streamChecker = new StreamChecker(new String[]{"abaa","abaab","aabbb","bab","ab"});
        String[] arr = {"a","a","b","b","b"};
        for (String s : arr) {
            System.out.println(streamChecker.query(s.charAt(0)));
        }
    }
}
