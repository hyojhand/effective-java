package chapter02.item7.cache;

import java.util.Map;
import java.util.WeakHashMap;

public class PostRepository {

    private Map<CacheKey, Post> cache;

    public PostRepository() {
        this.cache = new WeakHashMap<>();
    }

    public Post getPostById(CacheKey key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            Post post = new Post();
            cache.put(key, post);
            return post;
        }
    }

    public Map<CacheKey, Post> getCache() {
        return cache;
    }
}
