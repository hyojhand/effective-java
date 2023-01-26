package chapter02.item3.staticfactory;

// 3-2 정적 팩터리 방식의 싱글턴
public class Elvis implements Singer {
    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    @Override
    public void sing() {
        System.out.println("my way~~~");
    }
}
