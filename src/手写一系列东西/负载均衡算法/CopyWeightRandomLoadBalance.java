package 手写一系列东西.负载均衡算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class CopyWeightRandomLoadBalance extends AbstractLoadBalance {
    private List<Invoker> weightInvokers = new ArrayList<>();

    public CopyWeightRandomLoadBalance(List<Invoker> invokers) {
        super(invokers);
        if (invokers != null && !invokers.isEmpty()) {
            invokers.forEach(invoker -> {
                if (invoker.getWeight() < 2) {
                    weightInvokers.add(invoker);
                    return;
                }
                IntStream.range(0, invoker.getWeight()).forEach(i -> weightInvokers.add(invoker));
            });
        }
    }

    @Override
    public final List<Invoker> getInvokers() {
        return weightInvokers;
    }
    @Override
    public final Invoker doSelect() {
        return getInvokers().get(new Random().nextInt(getInvokers().size()));
    }

    public static void main(String[] args) {
        List<Invoker> invokers = Arrays.asList(
                new Invoker("176.170.209.1", 1),
                new Invoker("176.170.209.2", 9),
                new Invoker("176.170.209.3", 1),
                new Invoker("176.170.209.4", 9),
                new Invoker("176.170.209.5", 4),
                new Invoker("176.170.209.6", 6),
                new Invoker("176.170.209.7", 1),
                new Invoker("176.170.209.8", 9),
                new Invoker("176.170.209.9", 1),
                new Invoker("176.170.209.10", 9));
        AbstractLoadBalance abstractLoadBalance = new CopyWeightRandomLoadBalance(invokers);
        abstractLoadBalance.result(20000);
    }
}