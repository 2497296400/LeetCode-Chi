package 基础数据结构.AC自动机;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestAC {

    public static void main(String[] args) {
        AcAutomain acAutomain = new AcAutomain();
        acAutomain.insert("abc");
        acAutomain.insert("bc");
        acAutomain.insert("efg");

        acAutomain.build();
        System.out.println(acAutomain.contains("abcabcefg"));

    }
}

class Node {
    public Node[] nexts;
    public Node fail;
    public Boolean endUse;
    public String end;

    public Node() {
        fail = null;
        nexts = new Node[26];
        end = "";
        endUse = false;
    }
}

class AcAutomain {
    private Node root;

    public AcAutomain() {
        root = new Node();
    }

    public void insert(String s) {
        char[] chars = s.toCharArray();
        Node cur = root;
        for (char aChar : chars) {
            int index = aChar - 'a';
            if (cur.nexts[index] == null) {
                cur.nexts[index] = new Node();
            }
            cur = cur.nexts[index];
        }
        cur.end = s;
    }

    public void build() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node curFail = null;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (int i = 0; i < 26; i++) {
                if (curNode.nexts[i] != null) {
                    //儿子节点
                    curNode.nexts[i].fail = root;
                    //父亲节点
                    curFail = curNode.fail;
                    //儿子节点找fail指针
                    while (curFail != null) {
                        if (curFail.nexts[i] != null) {
                            curNode.nexts[i].fail=curFail.nexts[i];
                            break;
                        }
                        curFail = curFail.fail;
                    }
                    queue.add(curNode.nexts[i]);
                }
            }
        }
    }

    public List<String> contains(String s) {
        char[] chars = s.toCharArray();
        Node findAns = null;
        Node curNode = root;
        List<String> ans = new ArrayList<>();
        for (char aChar : chars) {
            int index = aChar - 'a';
            while (curNode.nexts[index] == null && curNode != root) {
                curNode = curNode.fail;
            }
            curNode = curNode.nexts[index] == null ? root : curNode.nexts[index];
            findAns = curNode;
            while (findAns != null) {
                if (findAns.endUse) {
                    break;
                } else {
                    if (!"".equals(findAns.end)) {
                        ans.add(findAns.end);
                        findAns.endUse = true;
                    }
                    findAns = findAns.fail;
                }
            }
        }
        return ans;
    }
}