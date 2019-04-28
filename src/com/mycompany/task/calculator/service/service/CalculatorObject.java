package com.mycompany.calculate.service.service;

public interface CalculatorObject<R,T> {

    R sum(T entity);

    R div(T entity);

    R multiply(T entity);

    R sub(T entity);
}
