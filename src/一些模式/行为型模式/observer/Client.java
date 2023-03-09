package 一些模式.行为型模式.observer;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 黑马程序员
 */
public class Client {
    public static void main(String[] args) {
        //1,创建公众号对象
        SubscriptionSubject subject = new SubscriptionSubject();

        //2,订阅公众号
        subject.attach(new WeiXinUser("孙悟空"));
        subject.attach(new WeiXinUser("猪悟能"));
        WeiXinUser 沙悟净 = new WeiXinUser("沙悟净");
        subject.attach(沙悟净);
        //3,公众号更新，发出消息给订阅者（观察者对象）
        String 大傻逼 ="大傻逼";
        int length = 大傻逼.length();
        System.out.println(length);
        subject.notify("传智黑马的专栏更新了！");
    }
}
