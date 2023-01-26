package chapter02.item3.staticfactory;

public class GenericMain {

    public static void main(String[] args) {
        MetaElvis<String> elvis1 = MetaElvis.getInstance();
        MetaElvis<Integer> elvis2 = MetaElvis.getInstance();
        System.out.println(elvis1.equals(elvis2)); // true
//        System.out.println(elvis1 == elvis2); // 타입이 달라서 == 비교 불가능

        System.out.println(elvis1); // 같은 인스턴스
        System.out.println(elvis2);
        elvis1.say("hello");
        elvis2.say(100);
    }
}
