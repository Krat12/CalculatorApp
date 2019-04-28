package com.mycompany.calculate.service.service.impl;



import com.mycompany.calculate.exeption.RequirementException;
import com.mycompany.calculate.model.CalculatorRoman;
import com.mycompany.calculate.model.RomanNumber;
import com.mycompany.calculate.service.service.CalculatorRomanService;

import java.util.ArrayList;
import java.util.List;


public class CalculatorRomanImpl implements CalculatorRomanService {


    private CalculatorRomanImpl() {
    }

    private static CalculatorRomanImpl instance;

    public static CalculatorRomanImpl getInstance(){

        if(instance == null){

            instance = new CalculatorRomanImpl();

        }
        return instance;
    }

    private List<Integer> numbers;

    private static final String MESSAGE_ERROR = "This operation is not possible";


    private static final String MESSAGE_NEGATIVE_NUMBER = "There can be no negative numbers";

    @Override
    public String sum(CalculatorRoman calculatorRoman) {
        try {
            checkNumber(calculatorRoman.getNumberOne(), calculatorRoman.getNumberToo());
            Integer result = numbers.get(0) + numbers.get(1);
            return ConvertIntegerToString(result);
        } catch (RequirementException e) {
            return e.getMessage();
        }
    }

    @Override
    public String div(CalculatorRoman calculatorRoman) {
        try {
            checkNumber(calculatorRoman.getNumberOne(), calculatorRoman.getNumberToo());
            Integer result = numbers.get(0) / numbers.get(1);
            return ConvertIntegerToString(result);
        } catch (RequirementException e) {
            return e.getMessage();
        }
    }

    @Override
    public String multiply(CalculatorRoman calculatorRoman) {
        try {
            checkNumber(calculatorRoman.getNumberOne(), calculatorRoman.getNumberToo());
            Integer result = numbers.get(0) * numbers.get(1);
            return ConvertIntegerToString(result);
        } catch (RequirementException e) {
            return e.getMessage();
        }
    }

    @Override
    public String sub(CalculatorRoman calculatorRoman) {
        try {
            checkNumber(calculatorRoman.getNumberOne(), calculatorRoman.getNumberToo());
            Integer result = numbers.get(0) - numbers.get(1);
            return ConvertIntegerToString(result);
        } catch (RequirementException e) {
            return e.getMessage();
        }
    }


    private void checkNumber(String... inputRomanNumber) throws RequirementException {

        numbers = new ArrayList<>();

        for (String inputString : inputRomanNumber) {

            for (RomanNumber romanNumber : RomanNumber.values()) {

                if (romanNumber.name().equals(inputString)) {
                    numbers.add(romanNumber.getArabNumber());
                }

            }
        }


        if (numbers.size() < 2) {
            throw new RequirementException(MESSAGE_ERROR);
        }
    }

    private String ConvertIntegerToString(Integer resultNumber) {

        StringBuilder stringResult = new StringBuilder();
        Integer tmp = resultNumber;

        if (tmp < 1) {
            return MESSAGE_NEGATIVE_NUMBER;
        }
        if (tmp > 10) {

            stringResult.append("X");

            if (tmp % 10 == 0) {
                return stringResult.append("X").toString();
            } else {
                tmp = tmp % 10;
            }

        }

        for (RomanNumber romanNumber : RomanNumber.values()) {
            if (romanNumber.getArabNumber().equals(tmp)) {
                stringResult.append(romanNumber.name());
            }
        }

        return stringResult.toString();
    }
}
