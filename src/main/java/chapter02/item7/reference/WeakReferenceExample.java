package chapter02.item7.reference;

import java.lang.ref.WeakReference;

public class WeakReferenceExample {

    public static void main(String[] args) throws InterruptedException {
        Object strong = new Object();
        WeakReference<Object> weak = new WeakReference<>(strong); // strong reference를 주입
        strong = null; // strong reference가 사라지면 weak 만 남는다.

        System.gc(); // weak reference만 남아있기 때문에 GC의 대상이 된다
        Thread.sleep(3000L);

        System.out.println(weak.get());
    }
}
