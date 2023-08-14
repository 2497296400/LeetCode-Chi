package 代码随想录.额外题目;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedInteger {
    Integer val;
    List<NestedInteger> list;

    public NestedInteger(Integer val) {
        this.val = val;
        this.list = null;
    }

    public NestedInteger(List<NestedInteger> list) {
        this.val = null;
        this.list = list;
    }

    public boolean isInteger() {
        return val != null;
    }

    public boolean isList() {
        return list != null;
    }

    public Integer getInteger() {
        return val;
    }

    public List<NestedInteger> getList() {
        return list;
    }

    class NestedIterator implements Iterator<Integer> {
        public Iterator<Integer> it;

        public NestedIterator(List<NestedInteger> nestedList) {
            List<Integer> resutl = new ArrayList<>();
            for (NestedInteger nestedInteger : nestedList) {
                traverse(nestedInteger, resutl);
            }
            this.it = resutl.iterator();
        }

        private void traverse(NestedInteger nestedInteger, List<Integer> resutl) {
            if (nestedInteger.isInteger()) {
                resutl.add(nestedInteger.getInteger());
                return;

            }
            for (NestedInteger integer : nestedInteger.getList()) {
                traverse(integer, resutl);
            }
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();

        }

        @Override
        public Integer next() {
            return it.next();
        }
    }
    
}
