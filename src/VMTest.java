import 力扣工具类.树的节点.TreeNode;

public class VMTest {
    public static void main(String[] args) {
        String s= "一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子一个大傻子";
        System.out.println(s.length());
        
        System.out.println("Hello World");
    }

    private static void last(TreeNode root) {
        if (root != null) {
            last(root.left);
            last(root.right);
            System.out.printf(root.val + " ");
        }
    }

    private static void order(TreeNode root) {
        if (root != null) {
            order(root.left);
            System.out.printf(root.val + " ");
            order(root.right);
        }
    }

    private static void pre(TreeNode root) {
        if (root != null) {
            System.out.printf(root.val + " ");
            pre(root.left);
            pre(root.right);
        }
    }

}
