package 树.二插搜索树;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        BSTree tree=new BSTree();
        while(true){
            int key=new Scanner(System.in).nextInt();
            if(key==0) {
                break;
            }
            tree.insert(key);
            //tree.print();
            TreeOperation.show(tree.getmRoot());

        }
        tree.remove(10);
        tree.remove(7);
        TreeOperation.show(tree.getmRoot());
    }
}
