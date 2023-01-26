package chapter02.item3.enumtype;

// 열거 타입 방식의 싱글턴 - 바람직한 방법
public enum Elvis {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("I'm outta here!");
    }
}
