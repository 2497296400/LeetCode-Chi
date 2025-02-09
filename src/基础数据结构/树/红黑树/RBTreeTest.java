package 基础数据结构.树.红黑树;

import java.util.Scanner;

public class RBTreeTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RBTree<String, Object> rbt = new RBTree<>();
        while (true) {
            System.out.println("请输入key");
            String key = scanner.next();
            System.out.println();
            rbt.insert(key, null);
            TreeOperation.show(rbt.getRoot());
            rbt.print_tree();
        }

    }

}
