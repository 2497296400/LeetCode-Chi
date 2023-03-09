package 卷一核心技术.当前月份日历表;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Break {
    public static void main(String[] args) {
        LocalDate data = LocalDate.now();
        int month = data.getMonthValue();
        int today = data.getDayOfMonth();
        data = data.minusDays(today - 1);
        DayOfWeek dayOfWeek = data.getDayOfWeek();
        int value = dayOfWeek.getValue();
        int[][] ans = {{1, 1, 1}, {2, 2, 2}};
        String s=Arrays.deepToString(ans);
        System.out.println(s);
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }
        while (data.getMonthValue() == month) {
            System.out.printf("%3d", data.getDayOfMonth());
            if (data.getDayOfMonth() == today) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            data = data.plusDays(1);
            if (data.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }
        if (data.getDayOfWeek().getValue() != 1) {
            System.out.println();
        }
        ArrayList<String>arrayList=new ArrayList<>();
        arrayList.ensureCapacity(100);
        arrayList.trimToSize();
    }
}