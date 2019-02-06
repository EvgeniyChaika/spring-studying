package com.chaika.spring.ripper.context;

import com.chaika.spring.ripper.interfaces.Quoter;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Created by echaika on 06.02.2019
 */
public class PropertyFileApplicationContext extends GenericApplicationContext {

    public PropertyFileApplicationContext(String fileName) {
        PropertiesBeanDefinitionReader propertiesBeanDefinitionReader = new PropertiesBeanDefinitionReader(this);
        int i = propertiesBeanDefinitionReader.loadBeanDefinitions(fileName);
        System.out.println("Found " + i + " beans");
        refresh();
    }

    public static void main(String[] args) {
        PropertyFileApplicationContext context = new PropertyFileApplicationContext("ripper/context.properties");
        context.getBean(Quoter.class).sayQuote();
    }
}
