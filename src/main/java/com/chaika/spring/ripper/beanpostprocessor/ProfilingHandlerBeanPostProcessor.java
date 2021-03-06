package com.chaika.spring.ripper.beanpostprocessor;

import com.chaika.spring.ripper.annotations.Profiling;
import com.chaika.spring.ripper.profiling.controller.ProfilingController;
import com.chaika.spring.ripper.profiling.interfaces.ProfilingControllerMBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.StandardMBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by echaika on 04.02.2019
 */
public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> map = new HashMap<>();
    private ProfilingController controller = new ProfilingController();

    public ProfilingHandlerBeanPostProcessor() throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        StandardMBean mBean = new StandardMBean(controller, ProfilingControllerMBean.class);
        mBeanServer.registerMBean(mBean, new ObjectName("profiling", "name", "controller"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Profiling.class)) {
            map.put(beanName, beanClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = map.get(beanName);
        if (Objects.nonNull(beanClass)) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (controller.isEnabled()) {
                        System.out.println("Profiling...");
                        long before = System.nanoTime();
                        Object retVal = method.invoke(bean, args);
                        long after = System.nanoTime();
                        System.out.println("Profiling finished - " + (after - before));
                        return retVal;
                    } else {
                        return method.invoke(bean, args);
                    }
                }
            });
        }
        return bean;
    }
}
