package chapter02.item3.staticfactory;

// 3-2 제네릭 싱글톤 팩토리
public class MetaElvis<T> {

    private static final MetaElvis<Object> INSTANCE = new MetaElvis<>();

    private MetaElvis() { }

    // 인스턴스는 동일하지만, 원하는 타입으로 바꿔서 사용할 수 있다
    // 제네릭 scope가 다르기 때문에, 클래스에 선언된 제네릭 타입은 인스턴스 scope 이지만,
    // 메서드 앞에 선언된 <E>(or <T>)는 static scope 이기 때문에 다른 타입이다!
    @SuppressWarnings("unchecked")
    public static <E> MetaElvis<E> getInstance() { return (MetaElvis<E>) INSTANCE; }

    public void say(T t) {
        System.out.println(t);
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }
}