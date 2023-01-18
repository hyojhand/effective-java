package chapter02.item01;
// 인터페이스도 다중 상속이 안될 수 있다.
// 동일한 이름으로 default 메서드가 정의되어 있다면, 다중상속을 지원하지 않거나, 무조건 다중상속 시에 재정의 해주어야 사용할 수 있다.
public class KoreaHelloService implements HelloService {
    @Override
    public String hello() {
        return "안녕";
    }
}
