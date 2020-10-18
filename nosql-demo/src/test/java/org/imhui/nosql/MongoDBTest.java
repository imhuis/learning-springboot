//package org.imhui.nosql;
//
//import com.mongodb.client.result.UpdateResult;
//import lombok.extern.slf4j.Slf4j;
//import org.imhui.nosql.model.Coffee;
//import org.joda.money.CurrencyUnit;
//import org.joda.money.Money;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Update;
//
//import java.util.Date;
//import java.util.List;
//
//import static org.springframework.data.mongodb.core.query.Criteria.where;
//import static org.springframework.data.mongodb.core.query.Query.query;
//
///**
// * @author: zyixh
// * @date: 2020/10/18 13:53
// * @description:
// */
//@SpringBootTest
//@Slf4j
//public class MongoDBTest {
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    public void test() throws InterruptedException {
//        Coffee espresso = Coffee.builder()
//                .name("espresso")
//                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
//                .createTime(new Date())
//                .updateTime(new Date()).build();
//        Coffee saved = mongoTemplate.save(espresso);
//        log.info("Coffee {}", saved);
//
//        List<Coffee> list = mongoTemplate.find(
//                query(where("name").is("espresso")), Coffee.class);
//        log.info("Find {} Coffee", list.size());
//        list.forEach(c -> log.info("Coffee {}", c));
//
//        Thread.sleep(1000); // 为了看更新时间
//        UpdateResult result = mongoTemplate.updateFirst(query(where("name").is("espresso")),
//                new Update().set("price", Money.ofMajor(CurrencyUnit.of("CNY"), 30))
//                        .currentDate("updateTime"),
//                Coffee.class);
//        log.info("Update Result: {}", result.getModifiedCount());
//        Coffee updateOne = mongoTemplate.findById(saved.getId(), Coffee.class);
//        log.info("Update Result: {}", updateOne);
//
//        mongoTemplate.remove(updateOne);
//    }
//}
