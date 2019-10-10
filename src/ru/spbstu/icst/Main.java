package ru.spbstu.icst;

import ru.spbstu.icst.calculator.Calculator;
import ru.spbstu.icst.calculator.OperationFactory;
import ru.spbstu.icst.calculator.exception.CalculatorException;
import ru.spbstu.icst.calculator.operation.OperationFactoryImpl;

public class Main {

    public static void main(String[] args) {
        System.out.println("Stack calculator. Enter commands one per line, type \"exit\" when finished:");

        OperationFactory factory = new OperationFactoryImpl();
        try {
            new Calculator(factory).run(System.in);
        } catch (CalculatorException e) {
            e.printStackTrace();
        }
    }


}
