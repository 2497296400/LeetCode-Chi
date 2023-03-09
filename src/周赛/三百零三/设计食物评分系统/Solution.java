package 周赛.三百零三.设计食物评分系统;

import java.util.*;

public class Solution {
}
class FoodRatings {

    class data {
        String name;
        int curCore;

        public data(String name, int curCore) {
            this.name = name;
            this.curCore = curCore;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            data data = (data) o;

            if (curCore != data.curCore) return false;
            return name != null ? name.equals(data.name) : data.name == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + curCore;
            return result;
        }
    }

    HashMap<String, data> stringDataHashMap = new HashMap<>();
    HashMap<String, TreeSet<data>> listHashMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

        for (int i = 0; i < foods.length; i++) {
            stringDataHashMap.put(foods[i], new data(cuisines[i], ratings[i]));
            if (listHashMap.containsKey(cuisines[i])) {
                TreeSet<data> data = listHashMap.get(cuisines[i]);
                data.add(new data(foods[i], ratings[i]));
                listHashMap.put(cuisines[i], data);
            } else {
                TreeSet<data> treeSet = new TreeSet<>(new Comparator<>() {
                    @Override
                    public int compare(data o1, data o2) {
                        return o2.curCore - o1.curCore == 0 ? o1.name.compareTo(o2.name) : o2.curCore - o1.curCore;
                    }
                });
                treeSet.add(new data(foods[i], ratings[i]));
                listHashMap.put(cuisines[i], treeSet);
            }
        }
    }

    public void changeRating(String food, int newRating) {
        data data = stringDataHashMap.get(food);
        data oldData=new data(food,data.curCore);
        data.curCore = newRating;
        data s = new data(food, newRating);
        stringDataHashMap.put(food, data);
        TreeSet<FoodRatings.data> treeSet = listHashMap.get(data.name);
        treeSet.remove(oldData);
        treeSet.add(s);
    }
    public String highestRated(String cuisine) {
        TreeSet<data> treeSet = listHashMap.get(cuisine);
        return treeSet.first().name;
    }
}