package 基础数据结构.设计跳表;

public class Skiplist {
    /*
    Redis底层数据结构:跳表->以O(logN)的时间复杂度内完成增删改查指定元素
    核心原理:建立多层随机索引,将时间复杂度降至logN,具体可参考简书的博客
    重要函数:1.findClosest(node,level,num) (从curNode开始)寻找level内最靠近target的左边节点
            该位置就是在该层内最接近target且<target的位置,将来用于完成插入、删除、查找等操作
            2.randomLevel() 以0.25为概率因子生成最大值为32的随机数
            数字每增加1,出现的概率为前一个数的0.25倍
            如:1出现的概率为0.75;1以上出现的概率为0.25;
            2出现的概率就是0.25*0.75;3出现的概率就是0.25*0.75*0.75
            .......这样可以间接保证每一层的元素成类似于二叉树的结构,最大高度不过logN
    */
    // 随机数概率因子
    private static final double P_FACTOR = 0.25;
    // 最大层数
    private static final int MAX_LEVEL = 32;
    // 当前实际有效的最大层数
    private int curLevel;
    // 头结点
    Node head;

    /*
    节点类:值+同层右边的节点引用数组
    */
    class Node {
        int val;
        Node[] next;

        public Node(int _val, int level) {
            val = _val;
            next = new Node[level];
        }
    }

    /*
    用给定规则生成随机数(非静态方法也可以调用静态变量)
    */
    private int randomLevel() {
        // 层数level从1开始
        int level = 1;
        while (Math.random() < P_FACTOR && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }
    /*
    跳表构造器
    */
    public Skiplist() {
        // 一开始啥也没
        curLevel = 0;
        // head指出32个next的节点
        head = new Node(-1, MAX_LEVEL);
    }

    /*
    从curNode开始:
    寻找level层内最靠近target的左边节点(如target=6,5->6->7,停留在5;如target=6,5->7->8,停留在5)
    */
    private Node findClosest(Node curNode, int level, int target) {
        // curNode就是上一层下沉位置的开端
        while (curNode.next[level] != null && curNode.next[level].val < target) {
            curNode = curNode.next[level];
        }
        return curNode;
    }

    /*
    查找跳表内是否存在target元素
    */
    public boolean search(int target) {
        Node curNode = head;
        // 从有效的顶层开始搜索
        for (int i = curLevel - 1; i >= 0; i--) {
            // searchNode停留在<=target的左边
            curNode = findClosest(curNode, i, target);
            if (curNode.next[i] != null && curNode.next[i].val == target) {
                // 找到一个即可返回true
                return true;
            }
        }
        // 找遍所有层都找不到就返回false
        return false;
    }

    /*
    往跳表内添加元素num
    */
    public void add(int num) {
        // 随机层
        int level = randomLevel();
        // 随机层对应的新节点
        Node newNode = new Node(num, level);
        Node curNode = head;
        for (int i = curLevel - 1; i >= 0; i--) {
            // 找到要插入的位置
            curNode = findClosest(curNode, i, num);
            // 当前层<newNode要求的层数时,每一层均要进行插入操作
            // 如level=2时,只要求索引为0,1的层进行插入
            if (i < level) {
                if (curNode.next[i] == null) {
                    // 目标位置处为空直接接上
                    curNode.next[i] = newNode;
                } else {
                    // 否则就要进行标准插入操作
                    Node tmp = curNode.next[i];
                    curNode.next[i] = newNode;
                    newNode.next[i] = tmp;
                }
            }

        }
        // 此时有可能要更新curLevel
        if (level > curLevel) {
            for (int i = curLevel; i < level; i++) {
                head.next[i] = newNode;
            }
            curLevel = level;
        }
    }

    /*
    往跳表内删除元素num
    */
    public boolean erase(int num) {
        Node curNode = head;
        // 删除成功标记
        boolean flag = false;
        for (int i = curLevel - 1; i >= 0; i--) {
            curNode = findClosest(curNode, i, num);
            // 可能有多个相同的值(如果存在多个num删除其中任意一个即可)
            // 当出现多个重复值且前面节点层数低后面层数高,一层一层删下来其实删除的不是同一个节点
            // 但是不会影响最终结果
            if (curNode.next[i] != null && curNode.next[i].val == num) {
                // 进行删除操作
                curNode.next[i] = curNode.next[i].next[i];
                // 标记删除成功
                flag = true;
            }
        }
        return flag;
    }
}