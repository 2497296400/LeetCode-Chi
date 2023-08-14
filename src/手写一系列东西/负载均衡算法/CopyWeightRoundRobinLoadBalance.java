package 手写一系列东西.负载均衡算法;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CopyWeightRoundRobinLoadBalance extends AbstractLoadBalance {

    private List<Invoker> weightInvokers = new ArrayList<>();
    protected AtomicInteger offset = new AtomicInteger(-1);
    @Override
    protected Invoker doSelect() {
        return getInvokers().get(offset.addAndGet(1) % getInvokers().size());
    }
    public CopyWeightRoundRobinLoadBalance(List<Invoker> invokers) {
        super(invokers);
        invokers.forEach(invoker -> {
            if (invoker.getWeight() < 2) {
                weightInvokers.add(invoker);
                return;
            }
            IntStream.range(0, invoker.getWeight()).forEach(i -> weightInvokers.add(invoker));
        });
    }

    @Override
    public final List<Invoker> getInvokers() {
        return weightInvokers;
    }
    

    public static void main(String[] args) {
        List<Invoker> invokers = List.of(
                new Invoker("176.170.209.1",1),
                new Invoker("176.170.209.2",9),
                new Invoker("176.170.209.3",1),
                new Invoker("176.170.209.4",9),
                new Invoker("176.170.209.5",4),
                new Invoker("176.170.209.6",6),
                new Invoker("176.170.209.7",1),
                new Invoker("176.170.209.8",9),
                new Invoker("176.170.209.9",1),
                new Invoker("176.170.209.10",9));
        AbstractLoadBalance copyWeightRoundRobinLoadBalance = new CopyWeightRoundRobinLoadBalance(invokers);
        IntStream.range(0,50).forEach(i-> System.out.println(copyWeightRoundRobinLoadBalance.selectHost()));
    }
}
