package com.chaika.spring.conditional.annotations;

import com.chaika.spring.conditional.components.OnGodModeCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Created by echaika on 07.02.2019
 */
@Target({TYPE, METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnGodModeCondition.class)
public @interface GodMode {
    boolean value();
}
