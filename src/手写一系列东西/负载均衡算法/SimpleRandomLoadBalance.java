package 手写一系列东西.负载均衡算法;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SimpleRandomLoadBalance extends AbstractLoadBalance {
    public SimpleRandomLoadBalance(List<Invoker> invokers) {
        super(invokers);
    }

    @Override
    protected Invoker doSelect() {
        return getInvokers().get(new Random().nextInt(getInvokers().size()));
    }

    @Override
    public List<Invoker> getInvokers() {
        return invokers;
    }

    public static void main(String[] args) {
        List<Invoker> invokers = Arrays.asList(
                new Invoker("176.170.209.1"),
                new Invoker("176.170.209.2"),
                new Invoker("176.170.209.3"),
                new Invoker("176.170.209.4"),
                new Invoker("176.170.209.5"),
                new Invoker("176.170.209.6"),
                new Invoker("176.170.209.7"),
                new Invoker("176.170.209.8"),
                new Invoker("176.170.209.9"),
                new Invoker("176.170.209.10"));

        AbstractLoadBalance abstractLoadBalance = new SimpleRandomLoadBalance(invokers);
        abstractLoadBalance.result(10000);
    }
}



