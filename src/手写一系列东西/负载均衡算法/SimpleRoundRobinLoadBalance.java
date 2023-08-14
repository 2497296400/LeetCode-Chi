package 手写一系列东西.负载均衡算法;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class SimpleRoundRobinLoadBalance extends AbstractLoadBalance {
    protected AtomicInteger offset = new AtomicInteger(-1);

    public SimpleRoundRobinLoadBalance(List<Invoker> invokers) {
        super(invokers);
    }

    @Override
    protected Invoker doSelect() {
        return getInvokers().get(offset.addAndGet(1) % getInvokers().size());
    }

    public static void main(String[] args) {
        List<Invoker> invokers = List.of(
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
        AbstractLoadBalance roundRobinLoadBalance = new SimpleRoundRobinLoadBalance(invokers);
        IntStream.range(0, 10).forEach(i -> {
            System.out.println(roundRobinLoadBalance.doSelect());
    });
}
}
