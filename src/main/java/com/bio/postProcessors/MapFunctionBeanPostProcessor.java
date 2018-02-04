package com.bio.postProcessors;

import com.bio.algorithms.Algorithm;
import com.bio.config.FunctionMap;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapFunctionBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> map = new HashMap<>();
    private Map<String, Algorithm> mapResult = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Class<?>[] interfaces = beanClass.getInterfaces();
        for (Class anInterface : interfaces) {
            if (anInterface==Algorithm.class) {
                map.put(beanName, beanClass);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.equals(FunctionMap.class)) {
            try {
                Field function = beanClass.getDeclaredField("function");
                function.setAccessible(true);
                Set<String> strings = map.keySet();
                for (String string : strings) {
                    Class s = map.get(string);
                    Object obj = s.newInstance();
                    mapResult.put(string,(Algorithm) obj);
                }
                ReflectionUtils.setField(function,bean,mapResult);
            } catch ( NoSuchFieldException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
        return bean;
    }
}
