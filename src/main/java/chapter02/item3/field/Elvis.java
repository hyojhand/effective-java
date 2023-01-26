package chapter02.item3.field;

import java.io.Serializable;

// 3-1 public static final 필드 방식의 싱글턴
public class Elvis implements IElvis, Serializable {
    /**
     * 싱글턴 오브젝트
     */
    public static final Elvis INSTANCE = new Elvis();
    // 인스턴스 생성확인 flag
    private static boolean created;

    // 리플렉션 방지
    // 최초에 생성자가 한번 호출되어 인스턴스가 만들어지면 created flag를 true
    private Elvis() {
        if (created) {
            throw new UnsupportedOperationException("can't be created by constructor.");
        }

        created = true;
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    public void sing() {
        System.out.println("I'll have a blue~ Christmas without you~");
    }

    // 역직렬화 방지 - 역직렬화 시 기존의 INSTANCE return
    private Object readResolve() {
        return INSTANCE;
    }
}
