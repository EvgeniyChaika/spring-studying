package com.chaika.spring.ripper.updateprototypeinsingleton;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * Created by echaika on 06.02.2019
 */
@Configuration
@ComponentScan(basePackages = "com.chaika.spring.ripper.updateprototypeinsingleton")
public class Config {

    @Bean
    //2)
    /**
     * The second approach, but when we call the bean, it will be created every time.
     */
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true) {
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(50);
        }
    }
}
