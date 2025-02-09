package 一些模式.结构型模式.decorator.personTest;

public class TestMain {
    public static void main(String[] args) {
        Person person = new Person("小明");
        半截袖 外套 = new 半截袖(new 外套 (new 半截袖(person)));
        外套.show();
    }
}
