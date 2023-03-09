package 一些模式.结构型模式.bridge;

/**
 * @version v1.0
 * @ClassName: VideoFile
 * @Description: 视频文件(实现化角色)
 * @Author: 黑马程序员
 */
public interface VideoFile {

    //解码功能
    void decode(String fileName);
}
