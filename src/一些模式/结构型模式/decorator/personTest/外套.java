package 一些模式.结构型模式.decorator.personTest;

public class 外套  implements IShowInterface{
    private final IShowInterface iShowInterface;

    public 外套(IShowInterface iShowInterface) {
        this.iShowInterface = iShowInterface;
    }

    @Override
    public void show() {
        System.out.println("外套  ");
        iShowInterface.show();
    }
}
