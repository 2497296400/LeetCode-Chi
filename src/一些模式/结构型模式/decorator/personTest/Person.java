package 一些模式.结构型模式.decorator.personTest;

public class Person implements IShowInterface {
    String name ;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println("装扮的"+name);
    }
}
