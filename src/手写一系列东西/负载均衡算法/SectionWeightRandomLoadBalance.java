package 手写一系列东西.负载均衡算法;

import java.util.List;
import java.util.Random;

public class SectionWeightRandomLoadBalance extends AbstractLoadBalance {
    private boolean averageWeight = true;

    private int totalWeight;

    public SectionWeightRandomLoadBalance(List<Invoker> invokers) {
        super(invokers);
        for (int i = 0; i < invokers.size(); i++) {
            Invoker invoker = invokers.get(i);
            if (averageWeight && i > 0 && invoker.getWeight() != invokers.get(i - 1).getWeight()) {
                averageWeight = false;
            }
            totalWeight += invoker.getWeight();
        }
    }

    @Override
    protected Invoker doSelect() {
        if (averageWeight || totalWeight < 1) {
            return super.doSelect();
        }
        int index = new Random().nextInt(totalWeight);
        for (Invoker invoker : invokers) {
            if (index < invoker.getWeight()) {
                return invoker;
            }
            index -= invoker.getWeight();
        }
        return super.doSelect();
    }

    public static void main(String[] args) {
        List<Invoker> invokers = List.of(
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
        AbstractLoadBalance simpleWeightRandomLoadBalance1 = new SectionWeightRandomLoadBalance(invokers);
        simpleWeightRandomLoadBalance1.result(20000);
    }
}
