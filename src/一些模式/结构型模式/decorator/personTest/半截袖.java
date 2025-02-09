package 一些模式.结构型模式.decorator.personTest;

public class 半截袖 implements IShowInterface {
    private final IShowInterface iShowInterface;

    public 半截袖(IShowInterface iShowInterface) {
        this.iShowInterface = iShowInterface;
    }

    @Override
    public void show() {
        System.out.println("半截袖  ");
        iShowInterface.show();
    }
}
