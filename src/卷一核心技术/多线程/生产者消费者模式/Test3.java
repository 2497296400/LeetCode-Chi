package 卷一核心技术.多线程.生产者消费者模式;

//定义一个操作数据的类
//测试多生产,多消费的情况
public class Test3 {
    public static void main(String[] args) {
        ValueOP valueOP = new ValueOP();
        ProducerThread p1 = new ProducerThread(valueOP);
        ProducerThread p2 = new ProducerThread(valueOP);
        ConsumerThread c1 = new ConsumerThread(valueOP);
        ConsumerThread c2 = new ConsumerThread(valueOP);
        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
 static    class ValueOP {
        private String value = "";
        //定义方法修改 value 字段的值
        public void setValue() {
            synchronized (this) {
                while (!value.equalsIgnoreCase("")) {//while
                    try {
                        this.wait();//如果 value 值不是""空串就等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String value = System.currentTimeMillis() + " - " + System.nanoTime();
                System.out.println("set 设置的值是: " + value);
                this.value = value;//如果 value 字段值是容串, 就设置 value 字段的值
                //this.notify();在多生产者多消费者环境中,notify()不能保证是生产者唤醒消费者,如果生产者唤醒的还是生产者可能会出现假死的情况
                this.notifyAll();
            }
        }
        //定义方法读取字段值
        void getValue() {
            synchronized (this) {
                while (value.equalsIgnoreCase("")) {//while
                    try {
                        this.wait();//如果 value 是空串就等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }//不是空串,读取 字段值
                System.out.println("get 的值是: " + this.value);
                this.value = "";
                this.notifyAll();
            }
        }
    }

    /**
     * 定义线程类模拟生产者
     */
    static class ProducerThread extends Thread {
        //生产者生产数据就是调用 ValueOP 类的 setValue 方法给 value 字段赋值
        private ValueOP obj;

        public ProducerThread(ValueOP obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            while (true) {
                obj.setValue();
            }
        }
    }

    // 定义线程类模拟消费者
    static class ConsumerThread extends Thread {
        private ValueOP obj;

        public ConsumerThread(ValueOP obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            while (true) {
                obj.getValue();
            }
        }
    }
}