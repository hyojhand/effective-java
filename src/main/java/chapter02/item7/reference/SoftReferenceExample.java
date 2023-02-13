package chapter02.item7.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceExample {

    public static void main(String[] args) throws InterruptedException {
        Object strong = new Object(); // Strong reference
        SoftReference<Object> soft = new SoftReference<>(strong);
        strong = null; // 더이상 strong reference 없이 soft만 남아있다

        System.gc(); // soft만 남아있지만 메모리가 충분해서 GC의 대상이 되지는 않는다.
        Thread.sleep(3000L);

        System.out.println(soft.get());
    }
}
