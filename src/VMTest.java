import 力扣工具类.力扣树的序列化.LeetCodeUtils;
import 力扣工具类.树的节点.TreeNode;

public class VMTest {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode treeNode = LeetCodeUtils.GetTreeNode(arr);
        pre(treeNode);
        System.out.println("-------");
        order(treeNode);
        System.out.println("--------");
        last(treeNode);
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
