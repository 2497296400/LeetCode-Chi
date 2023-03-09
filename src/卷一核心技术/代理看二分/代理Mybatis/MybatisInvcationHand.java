package 卷一核心技术.代理看二分.代理Mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MybatisInvcationHand implements InvocationHandler {
    private Class userMapper;

    public MybatisInvcationHand(Class userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        chiGe ge = method.getAnnotation(chiGe.class);
        String value = ge.value();
        return null;
    }

    public <T> T getProxy() {
      return (T) Proxy.newProxyInstance(userMapper.getClassLoader(),new Class[]{userMapper} , this);
    }
}
