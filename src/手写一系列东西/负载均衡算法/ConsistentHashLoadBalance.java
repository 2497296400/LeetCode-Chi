package 手写一系列东西.负载均衡算法;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class ConsistentHashLoadBalance extends AbstractLoadBalance {

    /**
     * 虚拟节点数量
     */
    private static final int VIRTUAL_NODE_NUM = 1000;
    /**
     * hash 和 虚拟节点映射关系
     */
    private SortedMap<Integer, Invoker> virtualNodesMap = new TreeMap<>();

    public ConsistentHashLoadBalance(List<Invoker> invokers) {
        super(invokers);
        putVirtualNodes(invokers);
    }

    private void putVirtualNodes(List<Invoker> invokers) {
        invokers.forEach(invoker -> {
            for (int i = 0; i < VIRTUAL_NODE_NUM; i++) {
                int hash = HashUtils.getHash(invoker.getAddress() + i);
                virtualNodesMap.put(hash, invoker);
            }
        });
    }

    /**
     * 根据客户端的信息获取 Invoker
     *
     * @param client
     * @return
     */
    public Invoker getInvoker(Object client) {
        if (client == null) {
            return null;
        }
        //获取大于等于 hash 的第一个 Node
        SortedMap<Integer, Invoker> subMap = virtualNodesMap.tailMap(HashUtils.getHash(client.toString()));
        if (subMap.isEmpty()) {
            // hash值在最尾部，映射到第一个Node上
            return virtualNodesMap.get(virtualNodesMap.firstKey());
        }
        return subMap.get(subMap.firstKey());
    }

    @Override
    public void result(int loop) {
        results.clear();
        if (loop < 1) {
            throw new IllegalArgumentException();
        }
        IntStream.range(0, loop).forEach(i -> {
                    Invoker key = selectHost("test-client-" + i);
                    results.put(key, results.getOrDefault(key, 0) + 1);
                }
        );
        results.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    @Override
    protected boolean addInvoker(Invoker invoker) {
        if (super.addInvoker(invoker)) {
            List<Invoker> invokers = getInvokers();
            virtualNodesMap.clear();
            putVirtualNodes(invokers);
            return true;
        }
        return false;
    }

    @Override
    protected boolean removeInvoker(Invoker invoker) {
        if (super.removeInvoker(invoker)) {
            List<Invoker> invokers = getInvokers();
            virtualNodesMap.clear();
            putVirtualNodes(invokers);
            return true;
        }
        return false;
    }

    @Override
    protected Invoker doSelect(Object client) {
        return getInvoker(client);
    }

    public static void main(String[] args) {
        List<Invoker> list = List.of(
                new Invoker("176.170.209.1", 1),
                new Invoker("176.170.209.2", 9),
                new Invoker("176.170.209.3", 1),
                new Invoker("176.170.209.4", 9),
                new Invoker("176.170.209.5", 4),
                new Invoker("176.170.209.6", 6),
                new Invoker("176.170.209.7", 1),
                new Invoker("176.170.209.8", 9),
                new Invoker("176.170.209.9", 1),
                new Invoker("176.1709.10", 9));
        AbstractLoadBalance abstractLoadBalance = new ConsistentHashLoadBalance(list);
        abstractLoadBalance.result(20000);

        System.out.println("addd");
        abstractLoadBalance.addInvoker(new Invoker("192.168.101.111", 9));
        abstractLoadBalance.result(20000);
    }
}
