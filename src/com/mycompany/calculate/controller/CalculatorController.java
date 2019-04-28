package com.mycompany.calculate.controller;


import com.mycompany.calculate.model.Calculator;
import com.mycompany.calculate.model.CalculatorArab;
import com.mycompany.calculate.model.CalculatorRoman;
import com.mycompany.calculate.service.service.CalculatorArabService;
import com.mycompany.calculate.service.service.CalculatorRomanService;
import com.mycompany.calculate.service.service.impl.CalculatorArabImpl;
import com.mycompany.calculate.service.service.impl.CalculatorRomanImpl;

public class CalculatorController implements CalculatorHandler {

    private static final String TWO_SPACES = "  ";

    private static final String ONE_SPACE = " ";

    private static final int NUMBER_ONE = 0;

    private static final int NUMBER_TWO = 2;

    private static final int MARK_OPERATION = 1;

    private static  final String MESSAGE_ERROR  = "This operation is not possible";

    private CalculatorArabService calculatorArabService = CalculatorArabImpl.getInstance();

    private CalculatorRomanService calculatorRomanService = CalculatorRomanImpl.getInstance();


    @Override
    public String count(String numericExpression) {

        String expression = removeExtraSpaces(numericExpression);

        String[] splitExpression = expression.split(ONE_SPACE);

        return result(splitExpression);

    }

    private String removeExtraSpaces(String numericExpression) {

        while (numericExpression.contains(TWO_SPACES)) {
           String replace = numericExpression.replace(TWO_SPACES, ONE_SPACE);
           numericExpression = replace;
        }
        return numericExpression;
    }

    private String result(String[] arr) {

        if (isNumber(arr[NUMBER_ONE]) && isNumber(arr[NUMBER_TWO])) {

            Calculator<Integer> calculatorArab = new CalculatorArab();

            calculatorArab.setNumberOne(Integer.valueOf(arr[NUMBER_ONE]));

            calculatorArab.setNumberToo(Integer.valueOf(arr[NUMBER_TWO]));

            if(arr[MARK_OPERATION].toCharArray().length > 1){
                return MESSAGE_ERROR;
            }
            calculatorArab.setOperation(arr[MARK_OPERATION].charAt(0));

            return checkOperation(calculatorArab);

        } else if (!isNumber(arr[NUMBER_ONE]) && !isNumber(arr[NUMBER_TWO])) {

            if(arr[MARK_OPERATION].toCharArray().length > 1){
                System.out.println(arr[MARK_OPERATION].toCharArray().length);
                return MESSAGE_ERROR;
            }

            Calculator<String> calculatorRoman = new CalculatorRoman(arr[NUMBER_ONE],
                                                                     arr[NUMBER_TWO],
                                                                     arr[MARK_OPERATION].charAt(0));
            return checkOperation(calculatorRoman);

        } else {

            return MESSAGE_ERROR;
        }
    }


    private String checkOperation(Calculator calculator) {

        switch (calculator.getOperation()) {
            case '/':
                return divResult(calculator);
            case '*':
                return multiplyResult(calculator);
            case '+':
                return sumResult(calculator);
            case '-':
                return subResult(calculator);
        }
        return MESSAGE_ERROR;
    }

    private String divResult(Calculator calculator) {

        if (calculator instanceof CalculatorArab) {
            return calculatorArabService.div((CalculatorArab) calculator);
        } else {
            return calculatorRomanService.div((CalculatorRoman) calculator);
        }
    }

    private String multiplyResult(Calculator calculator) {

        if (calculator instanceof CalculatorArab) {
            return calculatorArabService.multiply((CalculatorArab) calculator);
        } else {
            return calculatorRomanService.multiply((CalculatorRoman) calculator);
        }
    }

    private String sumResult(Calculator calculator) {

        if (calculator instanceof CalculatorArab) {
            return calculatorArabService.sum((CalculatorArab) calculator);
        } else {
            return calculatorRomanService.sum((CalculatorRoman) calculator);
        }
    }

    private String subResult(Calculator calculator) {

        if (calculator instanceof CalculatorArab) {
            return calculatorArabService.sub((CalculatorArab) calculator);
        } else {
            return calculatorRomanService.sub((CalculatorRoman) calculator);
        }
    }

    private boolean isNumber(String stringNumber){
        try {
            Integer.valueOf(stringNumber);
            return true;
        }catch (NumberFormatException e){
            return false;
        }

    }


}
