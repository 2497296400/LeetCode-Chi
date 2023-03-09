package 每日一题系列.每日一题十月.股票价格跨度;

import java.util.Stack;

public class Solution {

}

class StockSpanner {
    Stack<Data> asn;

    public StockSpanner() {
        asn = new Stack<>();
    }

    public int next(int price) {
        Data cur = new Data(price, 0);
        int sum = 1;
        while (!asn.isEmpty()&& cur.curD >= asn.peek().curD) {
            sum += asn.pop().curV;
        }
        asn.add(new Data(price, sum));
        return sum;
    }
}

class Data {
    int curD;
    int curV;

    public Data(int curD, int curV) {
        this.curD = curD;
        this.curV = curV;
    }
}