package chapter02.item3.field;

// Elvis 클라이언트 코드
public class Concert {

    private boolean lightsOn;

    private boolean mainStateOpen;

    // Elvis의 클라이언트 코드인 Concert를 테스트할 때마다 Elvis 객체를 사용하는데 비용이 들어간다.
    // 외부 API를 호출한다거나 연산이 오래 걸리는 작업이라면 매우 비효율적이다!
//    private Elvis elvis;
//
//    public Concert(Elvis elvis) {
//        this.elvis = elvis;
//    }

    // 클라이언트 코드는 인터페이스가 있다면 인터페이스를 기반으로 코딩
    private IElvis elvis;

    public Concert(IElvis elvis) {
        this.elvis = elvis;
    }

    // elvis.sing()의 Elvis 객체를 사용하는데 비용이 들어간다.
    // Concert 테스트가 목적이지, elvis 객체의 sing()을 테스트하려는 목적이 아니다!
    public void perform() {
        mainStateOpen = true;
        lightsOn = true;
        elvis.sing();
    }

    public boolean isLightsOn() {
        return lightsOn;
    }

    public boolean isMainStateOpen() {
        return mainStateOpen;
    }
}
