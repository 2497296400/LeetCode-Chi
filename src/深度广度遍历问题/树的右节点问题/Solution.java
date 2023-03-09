package 深度广度遍历问题.树的右节点问题;

public class Solution {
    public static void main(String[] args) {
        Node root=new Node(1);
        Node l1=new Node(2);
        Node l2=new Node(3);
        Node l3=new Node(4);
        Node l4=new Node(5);
        Node l5=new Node(7);
        root.left=l1;
        root.right=l2;
        root.left.right=l4;
        root.left.left=l3;
        root.right.right=l5;
        Node connect = new Solution().connect(root);
        System.out.println(connect);

    }
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            Node dumpy = new Node(0);
            Node pre = dumpy;
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = dumpy.next;
        }

return  root;
    }
}
