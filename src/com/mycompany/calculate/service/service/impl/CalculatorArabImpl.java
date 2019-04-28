package com.mycompany.calculate.service.service.impl;


import com.mycompany.calculate.exeption.RequirementException;
import com.mycompany.calculate.model.CalculatorArab;
import com.mycompany.calculate.service.service.CalculatorArabService;

public class CalculatorArabImpl implements CalculatorArabService {


    private static CalculatorArabImpl instance;

    private CalculatorArabImpl() {
    }

    public static CalculatorArabImpl getInstance(){

        if(instance == null){

            instance = new CalculatorArabImpl();
        }
        return instance;
    }

    private static final String MESSAGE_ERROR = "This operation is not possible";


    private static final String MESSAGE_NEGATIVE_NUMBER = "There can be no negative numbers";

    @Override
    public String sum(CalculatorArab calculatorArab) {

        try {
            checkNumber(calculatorArab.getNumberOne(), calculatorArab.getNumberToo());

            return String.valueOf(calculatorArab.getNumberOne() + calculatorArab.getNumberToo());

        } catch (RequirementException e) {
            return e.getMessage();
        }
    }

    @Override
    public String div(CalculatorArab calculatorArab) {

        try {
            checkNumber(calculatorArab.getNumberOne(), calculatorArab.getNumberToo());

            return String.valueOf(calculatorArab.getNumberOne() / calculatorArab.getNumberToo());

        } catch (RequirementException e) {
            return e.getMessage();
        }
    }

    @Override
    public String multiply(CalculatorArab calculatorArab) {

        try {
            checkNumber(calculatorArab.getNumberOne(), calculatorArab.getNumberToo());

            return String.valueOf(calculatorArab.getNumberOne() * calculatorArab.getNumberToo());

        } catch (RequirementException e) {
            return e.getMessage();
        }
    }

    @Override
    public String sub(CalculatorArab calculatorArab) {

        try {
            checkNumber(calculatorArab.getNumberOne(), calculatorArab.getNumberToo());

            Integer result = calculatorArab.getNumberOne() - calculatorArab.getNumberToo();

            return checkNegativeNumber(result);

        } catch (RequirementException e) {

            return e.getMessage();
        }
    }

    private String checkNegativeNumber(Integer result) {
        if (result < 1) {
            return MESSAGE_NEGATIVE_NUMBER;
        }
        return String.valueOf(result);
    }

    private void checkNumber(Integer... numbers) throws RequirementException {

        for (Integer number : numbers) {
            if (number > 10 || number < 1) {
                throw new RequirementException(MESSAGE_ERROR);
            }
        }

    }


}
