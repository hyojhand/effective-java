package chapter04.item17;

/**
 * 자신 외에는 내부의 가변 컴포넌트에 접근해서는 안된다.
 */
public class Person {
    private final Address address;

    public Person(Address address) {
        this.address = address;
    }

    // 방어적 복사 수행
    public Address getAddress() {
        Address copyAddress = new Address();
        copyAddress.setStreet(address.getStreet());
        copyAddress.setCity(address.getCity());
        copyAddress.setZipCode(address.getZipCode());
        return copyAddress;
    }

    public static void main(String[] args) {
        Address address = new Address();
        address.setCity("Seoul");

        Person person = new Person(address);
        Address tokyo = person.getAddress();
        tokyo.setCity("Tokyo");

        System.out.println(person.getAddress().getCity());
    }
}
