package 手写一系列东西.单例模式;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

public class Singleton {
    private volatile static Singleton singleton;

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}

class SinglentonFactory {
    private final static ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();

    public static <T> T getInstance(Class<T> clazz) {
        String key = clazz.toString();
        if (map.contains(key)) {
            return clazz.cast(map.get(key));
        }
        return clazz.cast(map.computeIfAbsent(key, k -> {
            try {
                return clazz.getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }));
    }
}
