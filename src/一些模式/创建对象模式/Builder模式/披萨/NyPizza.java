package 一些模式.创建对象模式.Builder模式.披萨;

import java.util.Objects;

public class NyPizza extends Pizza {
    private final Size size;

    NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    public enum Size {SMALL, MEDIUM, LARGE}

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        NyPizza build() {
            return new NyPizza(this);
        }
        @Override
        protected Builder self()  {
            return this;
        }
    }
}
