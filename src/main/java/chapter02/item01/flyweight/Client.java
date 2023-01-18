package chapter02.item01.flyweight;

public class Client {
    public static void main(String[] args) {

        // 같은 Font를 쓸때마다 새로운 인스턴스를 생성하지 않고, 하나의 인스턴스를 공유해서 사용하여 메모리 사용을 줄여서 객체를 가볍게 할 수 있다.
        FontFactory fontFactory = new FontFactory();
        FlyweightCharacter c1 = new FlyweightCharacter('s', "white", fontFactory.getFont("nanum:12"));
        FlyweightCharacter c2 = new FlyweightCharacter('o', "white", fontFactory.getFont("nanum:12"));
        FlyweightCharacter c3 = new FlyweightCharacter('n', "white", fontFactory.getFont("nanum:12"));

    }
}
