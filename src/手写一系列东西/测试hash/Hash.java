package 手写一系列东西.测试hash;

import java.util.HashMap;

public class Hash {
    public static void main(String[] args) {

        HashMap<Data, Data> map = new HashMap<>();
        Data[] f = new Data[63];
        for (int i = 0; i < 63; i++) {
            f[i] = new Data(i);
        }
        for (Data data : f) {
            map.put(data, data);
        }
        System.out.println(map.get(f[20]));
    }
}

class Data {
    int f;

    public Data(int f) {
        this.f = f;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return f == data.f;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "Data{" +
                "f=" + f +
                '}';
    }
}
