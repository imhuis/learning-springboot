package org.imhui.nosql;

import lombok.extern.slf4j.Slf4j;
import org.imhui.nosql.service.CoffeeService;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;

/**
 * @author: zyixh
 * @date: 2020/10/18 16:23
 * @description:
 */
@SpringBootTest
@Slf4j
public class JedisTest {

    @Autowired
    private CoffeeService coffeeService;
    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private JedisPoolConfig jedisPoolConfig;

    @Test
    public void test(){
        log.info(jedisPoolConfig.toString());
//        Jedis jedis = jedisPool.getResource();
//        jedis.set("Hello","World");
//        jedis.expire("Hello",10);

        try (Jedis jedis = jedisPool.getResource()) {
            coffeeService.findAllCoffee().forEach(c -> {
                jedis.hset("springbucks-menu",
                        c.getName(),
                        Long.toString(c.getPrice().getAmountMinorLong()));
            });

            Map<String, String> menu = jedis.hgetAll("springbucks-menu");
            log.info("Menu: {}", menu);

            String price = jedis.hget("springbucks-menu", "espresso");
            log.info("espresso - {}",
                    Money.ofMinor(CurrencyUnit.of("CNY"), Long.parseLong(price)));
        }
    }
}
