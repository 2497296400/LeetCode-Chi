package 卷一核心技术.多线程.TheadLocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 在多线程环境中,把字符串转换为日期对象,多个线程使用同一个 SimpleDateFormat 对象可能会产生线程安全问题,有异常
 * 为每个线程指定自己的 SimpleDateFormat 对象, 使用 ThreadLocal
 */
public class Test02 {
    //定义 SimpleDateFormat 对象,该对象可以把字符串转换为日期
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH:mm:ss");
    static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();

    static class ParseDate implements Runnable {
        private int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                String text = "2068 年 11 月 22 日 08:28:" + i % 60;//构建日期字符串
                //先判断当前线程是否有 SimpleDateFormat 对象,如果当前线程没有SimpleDateFormat 对象就创建一个,如果有就直接使用
                if (threadLocal.get() == null) {
                    threadLocal.set(new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH:mm:ss"));
                }
                Date date = threadLocal.get().parse(text);
                System.out.println(i + " -- " + date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new ParseDate(i)).start();
        }
    }
}