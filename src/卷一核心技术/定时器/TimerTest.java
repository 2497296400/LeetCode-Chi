package 卷一核心技术.定时器;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.Arrays;

public class TimerTest {
    public static void main(String[] args) {
//        TimePrinter timePrinter = new TimePrinter();
//        Timer timer = new Timer(1000, timePrinter);
//        Timer timer1 = new Timer(1000, e -> System.out.println(e));
//        timer1.start();
//        JOptionPane.showMessageDialog(null, "Quit program");
//        System.exit(0);
        String[] s = {"aaasdsad", "AAAAAAAAAas"};
        Arrays.sort(s, String::compareToIgnoreCase
        );
        System.out.println(Arrays.toString(s));
        reapeat(10,i-> System.out.println("Countdown: "+(9-i)));
    }
        public interface IntConsumer{
        void accept(int value);
    }
        public static void  reapeat(int n, IntConsumer action) {
            for (int j = 1; j <= n; j++){
            action.accept(j);
            }
        }
    static class TimePrinter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone,the time is " + Instant.ofEpochMilli(e.getWhen()));
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
