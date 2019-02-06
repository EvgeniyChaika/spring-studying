package com.chaika.spring.ripper.custombeanscope.beanfactorypostprocessor;

import com.chaika.spring.ripper.custombeanscope.scope.PeriodicalScopeConfigurer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Created by echaika on 06.02.2019
 */
@Component
public class CustomScopeRegistryBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        configurableListableBeanFactory.registerScope("periodical", new PeriodicalScopeConfigurer());
    }
}
