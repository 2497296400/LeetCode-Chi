package 卷一核心技术.链表集合;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinklistTest {
    public static void main(String[] args) {
        var a=new LinkedList<String>();
        a.add("1");
        a.add("2");
        a.add("3");
        var b =new LinkedList<String>();
        b.add("A");
        b.add("B");
        b.add("C");
        b.add("D");
        ListIterator<String> aIter = a.listIterator();
        ListIterator<String> bIter = b.listIterator();
        while (bIter.hasNext()){
            if(aIter.hasNext()){
                aIter.next();
            }
            aIter.add(bIter.next());
        }
        System.out.println(a);
        bIter=b.listIterator();
        while (bIter.hasNext()){
            bIter.next();
            if(bIter.hasNext()){
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(b);
        a.removeAll(b);
        System.out.println(a);
    }
}
