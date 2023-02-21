package chapter02.item7.executor;

import java.util.concurrent.*;

public class ExecutorsExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 스레드
//        Thread thread = new Thread(new Task());
//        thread.start();

        // 스레드 풀
//        int numberOfCpu = Runtime.getRuntime().availableProcessors(); // cpu 개수
        ExecutorService service = Executors.newFixedThreadPool(10);
//        ExecutorService service = Executors.newCachedThreadPool(); // 필요한 만큼 스레드를 생성하고, 기존의 스레드가 있으면 재사용한다. 오래된 스레드는 삭제한다.
//        ExecutorService service = Executors.newSingleThreadExecutor(); // 하나의 스레드로 진행
//        ExecutorService service = Executors.newScheduledThreadPool(10); // 몇초 뒤에 딜레이하거나, 주기적으로 실행하는 용도의 스레드 풀
//        for(int i = 0; i < 100; i++) {
//            service.submit(new Task());
//        }

        Future<String> submit = service.submit(new Task());

        System.out.println(Thread.currentThread() + " hello");

        System.out.println(submit.get()); // blocking call 이기 때문에 결과를 기다리고 수행된다.

        service.shutdown();
    }

    static class Task implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(2000L);
            return Thread.currentThread() + " world";
        }
    }

//    static class Task implements Runnable {
//        @Override
//        public void run() {
//            try {
//                Thread.sleep(2000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread() + " world");
//        }
//    }


}
