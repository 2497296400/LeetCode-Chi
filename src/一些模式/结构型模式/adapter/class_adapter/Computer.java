package 一些模式.结构型模式.adapter.class_adapter;

/**
 * @version v1.0
 * @ClassName: Computer
 * @Description: 计算机类
 * @Author: 黑马程序员
 */
public class Computer {

    //从SD卡中读取数据
    public String readSD(SDCard sdCard) {
        if(sdCard == null) {
            throw  new NullPointerException("sd card is not null");
        }
        // 这里是适配器模式的核心代码
        return sdCard.readSD();
    }
}
