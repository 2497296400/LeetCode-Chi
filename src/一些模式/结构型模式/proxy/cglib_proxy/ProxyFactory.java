//package 一些模式.结构型模式.proxy.cglib_proxy;
//
//import org.aopalliance.intercept.MethodInterceptor;
//import org.aopalliance.intercept.MethodInvocation;
//
//import java.lang.reflect.Method;
//
///**
// * @version v1.0
// * @ClassName: ProxyFactory
// * @Description: 代理对象工厂，用来获取代理对象
// * @Author: 黑马程序员
// */
//public class ProxyFactory implements MethodInterceptor {
//
//    //声明火车站对象e
//    private TrainStation station = new TrainStation();
//
//    public TrainStation getProxyObject() {
//        //创建Enhancer对象，类似于JDK代理中的Proxy类
//        Enhancer enhancer = new Enhancer();
//        //设置父类的字节码对象。指定父类
//        enhancer.setSuperclass(TrainStation.class);
//        //设置回调函数
//        enhancer.setCallback(this);
//        //创建代理对象
//        TrainStation proxyObject = (TrainStation) enhancer.create();
//        return proxyObject;
//    }
//
//    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//        //System.out.println("方法执行了");
//        System.out.println("代售点收取一定的服务费用(CGLib代理)");
//        //要调用目标对象的方法
//        Object obj = method.invoke(station, objects);
//        return obj;
//    }
//
//    @Override
//    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
//        return null;
//    }
//}
