package com.chaika.spring.ripper.benchmark.middle;

import com.chaika.spring.ripper.components.TerminatorQuoter;
import com.chaika.spring.ripper.interfaces.Quoter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by echaika on 06.02.2019
 */
class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ripper/ripperContext.xml");
        long before = System.nanoTime();
        //Will be skipped - Java dead code elumination
        for (int i = 0; i < 1_000_000; i++) {
            Quoter terminatorQuoter = context.getBean("terminatorQuoter", TerminatorQuoter.class);
        }
        long after = System.nanoTime();
        System.out.println((after - before) / 1_000_000);
    }
}
