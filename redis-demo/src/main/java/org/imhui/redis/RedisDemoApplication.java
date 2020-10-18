package org.imhui.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching //开启缓存
public class RedisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisDemoApplication.class, args);
    }

    /**
     * redis高可用 redis sentinel
     * 监控 通知 自动故障转移 服务发现
     *
     * Jedis只能从master读写数据
     * Lettuce可以读写分离
     */

    /**
     * Spring缓存抽象
     * {@link org.springframework.cache.Cache}
     * {@link org.springframework.cache.CacheManager}
     *
     * @CacheConfig(cacheNames = "")
     * @Cacheable
     * @CacheEvict
     */

    /**
     * {@link org.springframework.data.redis.connection.RedisStandaloneConfiguration}
     * {@link org.springframework.data.redis.connection.RedisSentinelConfiguration}
     * {@link org.springframework.data.redis.connection.RedisClusterConfiguration}
     */

}
