package com.bio.algorithms;

import org.springframework.stereotype.Component;

@Component
public interface Algorithm<T,E> {
    public T run(T t,E[] e);
}
