package z.blog.kit;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 简单缓存类
 *
 * @author beifengtz
 */
@Slf4j
public class CacheKit {

    // 本类实例对象，单例
    private static volatile CacheKit instance;

    // 缓存容器定义
    private static ConcurrentHashMap<String, Entry> cacheMap;

    // 然后是内部类Entry的定义, 该类是用来存储实际数据的, 为了方便处理过期时间, 添加初始化时间戳和过期时间等属性
    // 存储内容的结构定义
    static class Entry {
        // 存储时间
        long initTime;
        // 单位:秒
        int expire;
        // 具体数据
        Object data;

        Entry(long initTime, int expire, Object data) {
            this.initTime = initTime;
            this.expire = expire;
            this.data = data;
        }
    }

    // 然后是使用双检锁单例方式获取本类实例对象, 因为单例只能存在唯一的特点, 所以注意构造函数需要设为private
    private CacheKit() {
        cacheMap = new ConcurrentHashMap<>(64);
    }

    public static CacheKit cache() {
        if (instance == null) {
            synchronized (CacheKit.class) {
                if (instance == null) {
                    instance = new CacheKit();
                }
                return instance;
            }
        }
        return instance;
    }

    // 接下来是存入缓存数据`put()`方法
    // 这里的`clearExpiredCache()`是清理过期缓存
    // 后面会看到方法体, 因为在我项目中存入缓存的情况较少
    // 所以这里我固定了每次存之前先清理一次过期时间缓存
    // 这里可以根据自己项目实际情况进行优化
    public synchronized void put(String key, Object value, int expire) {
        clearExpiredCache();
        Entry entry = new Entry(System.currentTimeMillis(), Math.max(expire, 0), value);
        cacheMap.put(key, entry);
    }

    public synchronized void put(String key, Object value) {
        put(key, value, 0);
    }

    // 然后是获取缓存`get()`方法, 因为获取数据的时间较为多数
    // 所以这里我设定了三分之一的概率清理过期缓存, 适当地释放堆内存
    // 并且在获取时检测是否过期, 如果已过期然而还获取到了, 就删除并返回空
    public synchronized Object get(String key) {
        //  构造三分之一的几率清除过期缓存
        if (new Random().nextInt(12) > 8) {
            clearExpiredCache();
        }
        if (cacheMap.containsKey(key)) {
            Entry entry = cacheMap.get(key);
            if (entry.expire > 0 && System.currentTimeMillis() > entry.expire * 1000 + entry.initTime) {
                cacheMap.remove(key);
                return null;
            } else {
                return entry.data;
            }
        } else {
            return null;
        }
    }

    // 然后就是比较常规的一些方法, 具体可以看代码
    public int size() {
        return cacheMap.size();
    }

    public boolean contains(String key) {
        return cacheMap.containsKey(key);
    }

    public Set<String> keySet() {
        return cacheMap.keySet();
    }

    public void remove(String key) {
        cacheMap.remove(key);
    }

    // 最后一个方法就是清理过期缓存, 这里你可以选择启动一个监听
    // 线程实时地清理缓存, 也可以选择在适当时机进行一次清理
    // 比如我这里就是在存在put和get操作时固定或概率地清理缓存
    private synchronized void clearExpiredCache() {
        cacheMap.entrySet().removeIf(entry -> entry.getValue().expire > 0 && System.currentTimeMillis() > entry.getValue().expire * 1000 + entry.getValue().initTime);
    }
}