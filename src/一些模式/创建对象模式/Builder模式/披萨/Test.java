package 一些模式.创建对象模式.Builder模式.披萨;

public class Test {
    NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL).addTopping(Pizza.Topping.MUSHROOM).addTopping(Pizza.Topping.HAM).build();
    Calzone calzone = new Calzone.Builder().addTopping(Pizza.Topping.MUSHROOM).addTopping(Pizza.Topping.MUSHROOM).build();

}
