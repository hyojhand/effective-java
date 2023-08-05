package chapter04.item17;

/**
 * Setter를 제공하지 않고, 생성자로만 값을 가지게 하여 불변으로 만든다.
 * final 클래스로 하여 상속을 방지한다.
 * final 필드로 값을 변경할 수 없게한다.
 * 모든 필드를 private으로 만든다.
 */
public final class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    public short getAreaCode() {
        return areaCode;
    }

//    public void setAreaCode(short areaCode) {
//        this.areaCode = areaCode;
//    }

    public short getPrefix() {
        return prefix;
    }

//    public void setPrefix(short prefix) {
//        this.prefix = prefix;
//    }

    public short getLineNum() {
        return lineNum;
    }

//    public void setLineNum(short lineNum) {
//        this.lineNum = lineNum;
//    }
}
