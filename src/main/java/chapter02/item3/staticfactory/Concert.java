package chapter02.item3.staticfactory;

import java.util.function.Supplier;

public class Concert {

    public void start(Supplier<Singer> singerSupplier) {
        Singer singer = singerSupplier.get();
        singer.sing();
    }

    public static void main(String[] args) {
        Concert concert = new Concert();
        // 인자 없는 메서드를 호출해서 무언가 하나를 리턴해주는 메서드가 Supplier에 준하는 메서드가 된다.
        // 여기서는 getInstance() 메서드 참조를 공급자로 사용할 수 있다!
        concert.start(Elvis::getInstance); // concert.start(() -> Elvis.getInstance())
    }
}
