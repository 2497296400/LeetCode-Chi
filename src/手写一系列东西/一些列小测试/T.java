package 手写一系列东西.一些列小测试;

import java.io.*;

public class T {
    public static void main(String[] args) throws Exception {
        TestAll testAll = new TestAll(1);
        ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("test.ser"));
        objectOutput.writeObject(testAll);
        objectOutput.close();
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("test.ser"));
        TestAll t = (TestAll) inputStream.readObject();
        inputStream.close();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1);
        System.out.println(t.value + " " + TestAll.staticValue);
        System.out.println(methoh());

    }

    private static int methoh() {
        try {
            int i = 1 / 5;
            return 3;
        } catch (Exception e) {
            return 1;
        } finally {
            return 2;
        }
    }
}
