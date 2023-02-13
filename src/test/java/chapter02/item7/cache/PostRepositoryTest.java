package chapter02.item7.cache;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PostRepositoryTest {

    @Test
    void cache() throws InterruptedException {
        PostRepository postRepository = new PostRepository();
        // Integer key = 1; // reference 타입으로 사용하면 GC로 사라지지 않고 어딘가에 남아있는다.
        CacheKey key = new CacheKey(1); // 계속 참조하고 있기 때문에 weakHashMap을 사용해도 메서드가 끝날때 까지 gc에 의해 삭제되지 않는다.
        postRepository.getPostById(key);

        assertFalse(postRepository.getCache().isEmpty());

        // 임의로 null을 넣었는데,
        // 메서드가 끝나서 메서드 범위 밖으로 나가면서 해당 key가 유효해지지 않는다면, weakHashMap에 의해 삭제된다.
        key = null;

        // TODO run gc
        System.out.println("run gc");
        System.gc();
        System.out.println("wait");
        Thread.sleep(3000L);

        assertTrue(postRepository.getCache().isEmpty());
    }

    @Test
    void backgroundThread() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        PostRepository postRepository = new PostRepository();
        CacheKey key1 = new CacheKey(1);
        postRepository.getPostById(key1);

        Runnable removeOldCache = () -> {
            System.out.println("running removeOldCache task");
            Map<CacheKey, Post> cache = postRepository.getCache();
            Set<CacheKey> cacheKeys = cache.keySet();
            Optional<CacheKey> key = cacheKeys.stream().min(Comparator.comparing(CacheKey::getCreated));
            key.ifPresent((k) -> {
                System.out.println("removing " + k);
                cache.remove(k);
            });
        };

        System.out.println("The time is : " + new Date());

        executor.scheduleAtFixedRate(removeOldCache, 1, 3, TimeUnit.SECONDS);

        Thread.sleep(20000L);

        executor.shutdown();
    }

}