package chapter04.item24.memberclass;

import java.util.AbstractSet;
import java.util.Iterator;

/**
 * Adapter 패턴
 * MyIterator를 클라이언트가 사용하는 Iterator에 맞게 재정의해준다.
 */
public class MySet<E> extends AbstractSet<E> {

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public int size() {
        return 0;
    }

    private class MyIterator implements Iterator<E> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }
}
