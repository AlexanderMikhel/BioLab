package com.bio.algorithms;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Algorithm<T,E> {
    public T run(T t,List<E> e);
}
