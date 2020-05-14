package com.example.elasticserach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.example")//开启spring注解扫描
@EnableSwagger2//开启swagger
@EnableElasticsearchRepositories
public class ElasticserachApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticserachApplication.class, args);
    }

}
