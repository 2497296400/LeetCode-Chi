package 一些模式.创建对象模式.Builder模式.创建对象的方法;

public class NutrilonFacts {
    private  int servingSize;
    private  int servings;
    private  int calories;
    private  int fat;
    private  int sodium;

    private NutrilonFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
    }
    private static NutrilonFacts createNutrilonFacts(Builder builder) {
        return new NutrilonFacts(builder);
    }

    public static class Builder {
        private final int servingSize;
        private final int servings;
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public NutrilonFacts build() {
            return new NutrilonFacts(this);
        }
    }

    public static void main(String[] args) {
        NutrilonFacts build = new Builder(10, 20).fat(10).calories(20).fat(30).build();
    }
}
