package Top集合.完美矩形;

import java.util.HashMap;

public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        HashMap<Data, Integer> map = new HashMap<>();
        int area = 0;
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;
        for (int[] rectangle : rectangles) {
            int cx1 = rectangle[0];
            int cy1 = rectangle[1];
            int cx2 = rectangle[2];
            int cy2 = rectangle[3];
            Data d1 = new Data(cx1, cy1);
            Data d2 = new Data(cx1, cy2);
            Data d3 = new Data(cx2, cy1);
            Data d4 = new Data(cx2, cy2);
            map.put(d1, map.getOrDefault(d1, 0) + 1);
            map.put(d2, map.getOrDefault(d2, 0) + 1);
            map.put(d3, map.getOrDefault(d3, 0) + 1);
            map.put(d4, map.getOrDefault(d4, 0) + 1);
            area += (cx2 - cx1) * (cy2 - cy1);
            x1 = Math.min(x1, cx1);
            x2 = Math.max(x2, cx2);
            y1 = Math.min(y1, cy1);
            y2 = Math.max(y2, cy2);
        }
        return toCheck(map, x1, y1, x2, y2) && (x2 - x1) * (y2 - y1) == area;
    }

    private boolean toCheck(HashMap<Data, Integer> map, int x1, int y1, int x2, int y2) {
        Data d1 = new Data(x1, y1);
        Data d2 = new Data(x1, y2);
        Data d3 = new Data(x2, y1);
        Data d4 = new Data(x2, y2);
        if (map.containsKey(d1) && map.containsKey(d2) && map.containsKey(d3) && map.containsKey(d4)) {
            if (map.get(d1) == 1) {
                map.remove(d1);
                if (map.get(d2) == 1) {
                    map.remove(d2);
                }
                if (map.get(d3) == 1) {
                    map.remove(d3);
                }
                if (map.get(d4) == 1) {
                    map.remove(d4);
                }
                for (Integer value : map.values()) {
                    if (value % 2 != 0) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}

class Data {
    int x;
    int y;

    public Data(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data = (Data) o;

        if (x != data.x) return false;
        return y == data.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
