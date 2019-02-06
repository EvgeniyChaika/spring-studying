package com.chaika.spring.ripper.benchmark.senior;

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
        Quoter terminatorQuoter = null;
        long before = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            terminatorQuoter = context.getBean("terminatorQuoter", TerminatorQuoter.class);
        }
        long after = System.nanoTime();
        System.out.println((after - before) / 1_000_000);
        System.out.println(terminatorQuoter);
    }
}
