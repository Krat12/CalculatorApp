package com.mycompany.calculate;

import com.mycompany.calculate.controller.CalculatorController;
import com.mycompany.calculate.controller.CalculatorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp {

    private static final String MESSAGE_ERROR = "This operation is not possible";

    public static void main(String[] args) throws IOException {

        CalculatorHandler calculatorController = new CalculatorController();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = reader.readLine();
            String result = calculatorController.count(line);
            System.out.println(result);
            if (line.trim().isEmpty() || MESSAGE_ERROR.equals(result)) break;
        }
    }

}
