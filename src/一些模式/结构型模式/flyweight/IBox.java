package 一些模式.结构型模式.flyweight;

/**
 * @version v1.0
 * @ClassName: IBox
 * @Description: I图形类(具体享元角色)
 * @Author: 黑马程序员
 */
public class IBox extends AbstractBox {

    public String getShape() {
        return "I";
    }
}
