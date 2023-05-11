package 手写一系列东西.一些列小测试;

import java.io.*;

public class TestAll implements Serializable {
    private static final long serialVersionUID = 1L;
    int value;
    static int staticValue;
   
    public TestAll(int value) {
        this.value = value;
    }
}
