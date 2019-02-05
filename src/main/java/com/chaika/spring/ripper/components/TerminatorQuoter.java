package com.chaika.spring.ripper.components;

import com.chaika.spring.ripper.annotations.InjectRandomInt;
import com.chaika.spring.ripper.annotations.PostProxy;
import com.chaika.spring.ripper.annotations.Profiling;
import com.chaika.spring.ripper.interfaces.Quoter;

import javax.annotation.PostConstruct;

/**
 * Created by echaika on 04.02.2019
 */
@Profiling
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
    public final void sayQuote() {
        System.out.println("Phase 3 - method, repeat - " + repeat);
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
