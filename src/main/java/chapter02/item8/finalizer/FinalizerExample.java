package chapter02.item8.finalizer;

public class FinalizerExample {

    @Override
    protected void finalize() throws Throwable {
        System.out.print("");
    }
}
