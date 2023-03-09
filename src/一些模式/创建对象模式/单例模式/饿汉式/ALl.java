package 一些模式.创建对象模式.单例模式.饿汉式;


public class ALl {
    //静态方法模式
     static  class Singleton1 {
        private static Singleton1 instance = new Singleton1();

        public Singleton1() {
        }

        public static Singleton1 getInstance() {
            return instance;
        }
    }
    //静态代码块
   static   class Singeltio2{
        public Singeltio2() {
        }
        private  static Singeltio2 instance;
        static {
            instance =  new Singeltio2();
        }

        public static Singeltio2 getInstance() {
            return instance;
        }
    }
    static class  Singelton3{

    }
}