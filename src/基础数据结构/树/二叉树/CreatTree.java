package 二叉树;

import java.util.Scanner;

public class CreatTree {
    static int count = 0;
    int idx = 0;
    static public TreeNode Tree(TreeNode tree) {
        int temp = new Scanner(System.in).nextInt();
        if (temp == 0) {
            return null;
        } else {
            tree = new TreeNode(temp);
            tree.left = Tree(new TreeNode());
            tree.right = Tree(new TreeNode());
            return tree;
        }
    }
}
