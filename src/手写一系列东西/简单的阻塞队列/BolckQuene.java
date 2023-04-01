package 手写一系列东西.简单的阻塞队列;

public interface BolckQuene<E> {
    void  put(E e);
    E  get();
    int size();
}
