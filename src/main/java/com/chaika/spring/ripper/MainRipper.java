package com.chaika.spring.ripper;

import com.chaika.spring.ripper.interfaces.Quoter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by echaika on 04.02.2019
 */
public class MainRipper {

    public static void main(String[] args) throws InterruptedException {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ripper/ripperContext.xml")) {
            //This is example. Don't get bean by class implementation!
            while (true) {
                Thread.sleep(100);
                context.getBean(Quoter.class).sayQuote();
            }
        }
    }
}
