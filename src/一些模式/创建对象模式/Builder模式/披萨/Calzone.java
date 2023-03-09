package 一些模式.创建对象模式.Builder模式.披萨;

public class Calzone extends Pizza {
    private final boolean sauceInside;

   private Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false;

        @Override
        Calzone build() {
            return new Calzone(this);
        }
        public Builder sauceInside() {
            this.sauceInside = true;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
