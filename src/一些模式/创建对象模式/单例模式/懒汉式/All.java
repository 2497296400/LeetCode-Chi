package 一些模式.创建对象模式.单例模式.懒汉式;

public class All {
    //线程不安全
     class singleton1 {
        private static singleton1 instace;

        public singleton1() {
        }

        public  singleton1 getInstace() {
            if (instace == null) {
                instace = new singleton1();
            }
            return instace;
        }
    }

        //线程安全
     class singleton2 {
        private static singleton2 instace;

        public singleton2() {
        }

        public  synchronized singleton2 getInstace() {
            if (instace == null) {
                instace = new singleton2();
            }
            return instace;
        }
    }
    //双重检查
     class singleton3 {
        //防止指令重新排序 valatile
        private static volatile singleton3 instace;

        public singleton3() {
        }

        public  singleton3 getInstace() {
            if (instace == null) {
                synchronized (singleton3.class){
                    if(instace==null){
                        instace = new singleton3();
                    }
                }
            }
            return instace;
        }
    }
    //静态内部类方
    static class  singleton4{
        public singleton4() {
        }
        static  class sinleton4Holder{
            private static  final singleton4 instace = new singleton4();
        }
        public static singleton4 getInstance(){
            return  sinleton4Holder.instace;
        }
    }
    
}
