package com.chaika.spring.ripper.benchmark.junior;

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
        long before = System.currentTimeMillis();
        Quoter terminatorQuoter = context.getBean("terminatorQuoter", TerminatorQuoter.class);
        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }
}
