package org.cliff.ddd.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Spring Boot应用的入口类
 *
 * @author Frank Zhang
 */
@ImportResource(locations = {"classpath*:applicationContext.xml"})
@SpringBootApplication(scanBasePackages = {"org.cliff.ddd"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
