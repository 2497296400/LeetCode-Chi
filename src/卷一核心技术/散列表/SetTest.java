package 卷一核心技术.散列表;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class SetTest {
    public static void main(String[] args) {
        var words=new HashSet<String>();
        long totalTime=0;
        Scanner in = new Scanner(System.in);
            while (in.hasNextLine()){
                String anObject = in.nextLine();
                if("".equals(anObject)){break;
                }
                String word=anObject;
                long callTime=System.currentTimeMillis();
                words.add(word);
                callTime=System.currentTimeMillis()-callTime;
                totalTime+=callTime;

            }

        Iterator<String> iterator = words.iterator();
        for(int i=1;i<=20&&iterator.hasNext();i++){
            System.out.println(iterator.next());
        }
        System.out.println(".....");
        System.out.println(words.size()+"distinct"+totalTime+"miolliseconds");
    }
}
