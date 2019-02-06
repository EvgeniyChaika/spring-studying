package com.chaika.spring.ripper.components;

import com.chaika.spring.ripper.annotations.DeprecatedClass;
import com.chaika.spring.ripper.annotations.InjectRandomInt;
import com.chaika.spring.ripper.annotations.PostProxy;
import com.chaika.spring.ripper.annotations.Profiling;
import com.chaika.spring.ripper.interfaces.Quoter;

import javax.annotation.PostConstruct;

/**
 * Created by echaika on 04.02.2019
 */
@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    public TerminatorQuoter() {
        System.out.println("Phase 1 - constructor, repeat " + repeat);
    }

    @PostConstruct
    void initMethod() {
        System.out.println("Phase 2 - init method, repeat - " + repeat);
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("Phase 3 - method, repeat - " + repeat);
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * For {@link com.chaika.spring.ripper.context.PropertyFileApplicationContext}
     */
    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    @Override
    public String toString() {
        return "TerminatorQuoter{" +
                "repeat=" + repeat +
                ", message='" + message + '\'' +
                '}';
    }
}
