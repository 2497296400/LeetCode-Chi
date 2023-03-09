package 卷一核心技术.多线程;

/**
 * @author pc
 */
public class DemoThread {
    public static void main(String[] args) {
        Bank bank=new Bank(10,1000);
        Runnable runnable1= () -> {
            try {
                bank.transfer(0,1,50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        Runnable runnable2= () -> {
            try {
                bank.transfer(1,2,50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
         new Thread(runnable1).start();
         new Thread(runnable2).start();


    }

}
