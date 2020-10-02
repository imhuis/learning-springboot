package org.imhui.rest;

import lombok.extern.slf4j.Slf4j;
import org.imhui.rest.model.Coffee;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@SpringBootApplication
@Slf4j
public class ResttemplateDemoApplication implements ApplicationRunner {

    public static void main(String[] args) {
//        SpringApplication.run(ResttemplateDemoApplication.class, args);
        new SpringApplicationBuilder()
                .sources(ResttemplateDemoApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Autowired
    private RestTemplate restTemplate;


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
    }



    @Override
    public void run(ApplicationArguments args) throws Exception {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8080/coffee/?name={name}")
                .build("mocha");
        RequestEntity<Void> req = RequestEntity.get(uri)
                .accept(MediaType.APPLICATION_XML)
                .build();
        ResponseEntity<String> resp = restTemplate.exchange(req, String.class);
        log.info("Response Status: {}, Response Headers: {}", resp.getStatusCode(), resp.getHeaders().toString());
        log.info("Coffee: {}", resp.getBody());

        String coffeeUri = "http://localhost:8080/coffee/";
        Coffee request = Coffee.builder()
                .name("Americano")
                .price(Money.of(CurrencyUnit.of("CNY"), 25.00))
                .build();
        Coffee response = restTemplate.postForObject(coffeeUri, request, Coffee.class);
        log.info("New Coffee: {}", response);

        ParameterizedTypeReference<List<Coffee>> ptr =
                new ParameterizedTypeReference<List<Coffee>>() {};
        ResponseEntity<List<Coffee>> list = restTemplate
                .exchange(coffeeUri, HttpMethod.GET, null, ptr);
        list.getBody().forEach(c -> log.info("Coffee: {}", c));
    }


    /**
     *
     * 构造Url {@link UriComponentsBuilder}
     * 构造相对于当前请求的url {@link org.springframework.web.servlet.support.ServletUriComponentsBuilder}
     * 构造指向controller的url {@link org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder}
     */

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        URI uri = UriComponentsBuilder
//                .fromUriString("http://localhost:8080/coffee/{id}")
//                .build(1);
//        ResponseEntity<Coffee> c = restTemplate.getForEntity(uri, Coffee.class);
//        log.info("Response Status: {}, Response Headers: {}", c.getStatusCode(), c.getHeaders().toString());
//        log.info("Coffee: {}", c.getBody());
//
//        String coffeeUri = "http://localhost:8080/coffee/add";
//        Coffee request = Coffee.builder()
//                .name("Americano")
//                .price(BigDecimal.valueOf(25.00))
//                .build();
//        Coffee response = restTemplate.postForObject(coffeeUri, request, Coffee.class);
//        log.info("New Coffee: {}", response);
//
//        String s = restTemplate.getForObject(coffeeUri, String.class);
//        log.info("String: {}", s);
//    }
}
