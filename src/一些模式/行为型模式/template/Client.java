package 一些模式.行为型模式.template;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 黑马程序员
 */
public class Client {
    public static void main(String[] args) {
        //炒包菜
        //创建对象
        ConcreteClass_BaoCai baoCai = new ConcreteClass_BaoCai();
        //调用炒菜的功能
        baoCai.cookProcess();
    }
}
