package com.mycompany.calculate.model;

import java.util.Objects;

public abstract class Calculator <T> {

    private T numberOne;

    private T numberToo;

    private char operation;

    public Calculator(T numberOne, T numberToo, char operation) {
        this.numberOne = numberOne;
        this.numberToo = numberToo;
        this.operation = operation;
    }

    public Calculator() {
    }

    public T getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(T numberOne) {
        this.numberOne = numberOne;
    }

    public T getNumberToo() {
        return numberToo;
    }

    public void setNumberToo(T numberToo) {
        this.numberToo = numberToo;
    }

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator<?> that = (Calculator<?>) o;
        return operation == that.operation &&
                Objects.equals(numberOne, that.numberOne) &&
                Objects.equals(numberToo, that.numberToo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOne, numberToo, operation);
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "numberOne=" + numberOne +
                ", numberToo=" + numberToo +
                ", operation=" + operation +
                '}';
    }
}
