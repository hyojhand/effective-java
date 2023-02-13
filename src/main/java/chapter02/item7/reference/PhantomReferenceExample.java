package chapter02.item7.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceExample {

    public static void main(String[] args) throws InterruptedException {
        BigObject strong = new BigObject();
        ReferenceQueue<BigObject> rq = new ReferenceQueue<>();

        BigObjectReference<BigObject> phantomReference = new BigObjectReference<>(strong, rq);
//        PhantomReference<BigObject> phantomReference = new BigObjectReference<>(strong, rq); // 2번째 파라미터로 ReferenceQueue를 넣어준다.
        strong = null;

        System.gc(); // GC가 일어나면, Phantom Reference가 ReferenceQueue에 들어간다!
        Thread.sleep(3000L);

        System.out.println(phantomReference.isEnqueued()); // 큐에 들어있다면 해당 Object가 사라졌음을 알 수 있다.

        Reference<? extends BigObject> reference = rq.poll();
        BigObjectReference bigObjectCleaner = (BigObjectReference) reference;
        bigObjectCleaner.cleanUp(); // custom한 자원 반납 메서드
        reference.clear(); // 최종적으로 clear 해주어야 Phantom Reference가 사라진다.
    }
}
