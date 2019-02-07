package com.chaika.spring.conditional.components;

import com.chaika.spring.conditional.annotations.GodMode;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * Created by echaika on 07.02.2019
 */
public class OnGodModeCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(GodMode.class.getName());

        assert annotationAttributes != null;
        boolean godModeRequested = (Boolean) annotationAttributes.get("value");
        boolean hasGodMode = System.getProperties().containsKey("godMode");
        return godModeRequested && hasGodMode || !godModeRequested && !hasGodMode;
    }
}
