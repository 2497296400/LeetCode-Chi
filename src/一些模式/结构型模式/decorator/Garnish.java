package 一些模式.结构型模式.decorator;

/**
 * @version v1.0
 * @ClassName: Garnish
 * @Description: 装饰者类(抽象装饰者角色)
 * @Author: 黑马程序员
 */
public abstract class Garnish extends FastFood {

    //声明快餐类的变量
    private FastFood fastFood;

    private int times = 0;

    public FastFood getFastFood() {
        System.out.println(fastFood.toString()+ " " + times++);
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }

    public Garnish(FastFood fastFood, float price, String desc) {
        super(price, desc);
        this.fastFood = fastFood;
    }

    @Override
    public String toString() {
        return "Garnish{" +
                "fastFood=" + fastFood +
                ", times=" + times +
                '}';
    }
}
