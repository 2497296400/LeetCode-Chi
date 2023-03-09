package 一些模式.结构型模式.bridge;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 黑马程序员
 */
public class Client {
    public static void main(String[] args) {
        //创建mac系统对象
        OpratingSystem system = new Mac(new AviFile());
        //使用操作系统播放视频文件
        system.videoFile.decode("12313232");
        system.play("战狼3");
        Mac mac = new Mac(new RmvbFile());
        mac.play("sss");
        mac.playPusl();
        Windows windows = new Windows(new RmvbFile());
        system = windows;
        system.play("asdasd");

    }
}
