package com.bio.algorithms;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public interface Algorithm<T,E> extends Function<T,E> {
    public T run(T t,List<E> e);
}
