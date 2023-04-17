package chapter03.item14;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Comparator.comparingInt;

// PhoneNumber를 비교할 수 있게 만든다
public final class PhoneNumber implements Cloneable, Comparable<PhoneNumber> {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "지역코드");
        this.prefix = rangeCheck(prefix, 999, "프리픽스");
        this.lineNum = rangeCheck(lineNum, 9999, "가입자 번호");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d",
                areaCode, prefix, lineNum);
    }

    // 14-2 기본 타입 필드가 여럿일 때의 비교자
    @Override
    public int compareTo(PhoneNumber pn) {
        int result = Short.compare(areaCode, pn.areaCode); // 가장 중요한 필드
        if (result == 0) {
            result = Short.compare(prefix, pn.prefix); // 두번째 중요한 필드
            if (result == 0)
                result = Short.compare(lineNum, pn.lineNum); // 세번째 중요한 필드
        }
        return result;
    }

    // 14-3 비교자 생성 메서드를 활용한 비교자
//    private static final Comparator<PhoneNumber> COMPARATOR =
//            Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode)
//                    .thenComparingInt(pn -> pn.getPrefix())
//                    .thenComparingInt(pn -> pn.lineNum);
//
//    @Override
//    public int compareTo(PhoneNumber pn) {
//        return COMPARATOR.compare(this, pn);
//    }

    private static PhoneNumber randomPhoneNumber() {
        Random rnd = ThreadLocalRandom.current();
        return new PhoneNumber((short) rnd.nextInt(1000),
                (short) rnd.nextInt(1000),
                (short) rnd.nextInt(10000));
    }

    public static void main(String[] args) {
        Set<PhoneNumber> s = new TreeSet<>();
        for (int i = 0; i < 10; i++)
            s.add(randomPhoneNumber());
        System.out.println(s);
    }

}
