package 手写一系列东西.负载均衡算法;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoker {
    private String address;

    private int weight = 1;

    private int currentWeight = 0;

    public Invoker(String address) {
        this.address = address;
    }

    public Invoker(String address, int weight) {
        this.address = address;
        this.weight = weight;
    }
}
