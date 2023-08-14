package 手写一系列东西.负载均衡算法;


import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;


public abstract class AbstractLoadBalance {
    protected List<Invoker> invokers;
    protected final HashMap<Invoker, Integer> results = new HashMap<>();

    public AbstractLoadBalance(List<Invoker> invokers) {
        this.invokers = invokers;
    }

    public Invoker selectHost() {
        List<Invoker> list = getInvokers();
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        return doSelect();
    }

    public Invoker selectHost(Object client) {
        List<Invoker> list = getInvokers();
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        return doSelect(client);
    }

    protected Invoker doSelect(Object client) {
        return null;
    }

    protected Invoker doSelect() {
        return null;
    }

    protected boolean addInvoker(Invoker invoker) {
        if (getInvokers() != null) {
            return invokers.add(invoker);
        }
        return false;
    }

    //todo 不要返回集合
    protected List<Invoker> getInvokers() {
        return invokers;
    }

    public void result(int loop) {
        results.clear();
        if (loop < 1) {
            throw new IllegalArgumentException();
        }
        IntStream.range(0, loop).forEach(i -> {
            Invoker invoker = selectHost();
            results.put(invoker, results.getOrDefault(invoker, 0) + 1);
        });
        results.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    protected boolean removeInvoker(Invoker invoker) {
        if (getInvokers() != null) {
            return invokers.remove(invoker);
        }
        return false;
    }
}
