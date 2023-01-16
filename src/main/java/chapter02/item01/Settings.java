package chapter02.item01;

/**
 * 이 클래스의 인스턴스는 #getInstance()를 통해 사용한다.
 * @see #getInstance()
 */
public class Settings {

    private boolean useAutoSteering;
    private boolean userABS;
    private Difficulty difficulty;

    private Settings() {
    }

    // 미리 생성한 인스턴스를 사용
    private static final Settings SETTINGS = new Settings();

    public static Settings getInstance() {
        return SETTINGS;
    }

    // 새로운 인스턴스를 계속 생성
    public static void main(String[] args) {
        System.out.println(new Settings());
        System.out.println(new Settings());
        System.out.println(new Settings());
    }

}
