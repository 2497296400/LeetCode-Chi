package 基础数据结构.设计跳表;

public class SkiplistT {
    private final double P = 0.5F;
    private final int MAX_LEVEL = 32;
    private int curLevel;
    private Node head;

    public SkiplistT() {
        head = new Node(-1, MAX_LEVEL);
        curLevel = 0;
    }

    class Node {
        int val;
        Node[] next;

        public Node(int val, int level) {
            this.val = val;
            next = new Node[level];
        }
    }

    private int getCurLevel() {
        int level = 1;
        while (Math.random() > P) {
            level++;
        }
        return level;
    }

    public void add(int target) {
        Node curNode = head;
        int level = getCurLevel();
        Node newNode = new Node(target, level);
        for (int i = curLevel - 1; i >= 0; i--) {
            curNode = getLeftNode(curNode, i, target);
            if (i < level) {
                if (curNode.next[i] == null) {
                    curNode.next[i] = newNode;
                } else {
                    Node temp = curNode.next[i];
                    curNode.next[i] = newNode;
                    newNode.next[i] = temp;
                }
            }
        }
        if (level > curLevel) {
            for (int i = curLevel; i < level; i++) {
                head.next[i] = newNode;
            }
            curLevel=level;
            
        }
    }

    public boolean search(int target) {
        Node curNode = head;
        for (int i = curLevel - 1; i >= 0; i--) {
            curNode = getLeftNode(curNode, i, target);
            if (curNode.next[i] != null && curNode.next[i].val == target) {
                return true;
            }
        }
        return false;
    }

    private Node getLeftNode(Node curNode, int curLevel, int target) {
        while (curNode.next[curLevel] != null && curNode.next[curLevel].val < target) {
            curNode = curNode.next[curLevel];
        }
        return curNode;
    }

    public void delete(int target) {
        Node curNode = head;
        for (int i = curLevel - 1; i >= 0; i--) {
            curNode = getLeftNode(curNode, i, target);
            if (curNode.next[i] != null) {
                Node cur = curNode.next[i];
                while (cur != null&&cur.val == target ) {
                    cur = cur.next[i];
                }
                curNode.next[i] = cur;
                }
            }
        }
    public static void main(String[] args) {
        SkiplistT t = new SkiplistT();
        t.add(1);
        t.add(2);
        t.add(10);
        System.out.println(t.search(2));
        t.delete(2);
        System.out.println(t.search(2));
    }
}