package com.chaika.spring.ripper.custombeanscope;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * Created by echaika on 06.02.2019
 */
@Configuration
@ComponentScan("com.chaika.spring.ripper.custombeanscope")
class Config {

    @Bean
    @Scope("periodical")
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
