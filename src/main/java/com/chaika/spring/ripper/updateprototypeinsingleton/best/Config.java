package com.chaika.spring.ripper.updateprototypeinsingleton.best;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * Created by echaika on 06.02.2019
 */
@Configuration
@ComponentScan(basePackages = "com.chaika.spring.ripper.updateprototypeinsingleton.best")
class Config {

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Bean
    public ColorFrame frame() {
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return color();
            }
        };
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true) {
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(50);
        }
    }
}