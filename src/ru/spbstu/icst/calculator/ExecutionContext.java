package ru.spbstu.icst.calculator;

import ru.spbstu.icst.collection.ArrayStack;
import ru.spbstu.icst.collection.Stack;

import java.util.HashMap;
import java.util.Map;

public class ExecutionContext {

    private final Stack<Double> stack = new ArrayStack<>();
    private final Map<String, Double> table = new HashMap<>();
    private final OperationFactory factory;

    public ExecutionContext(OperationFactory factory) {
        this.factory = factory;
    }

    public Stack<Double> stack() {
        return stack;
    }

    public Map<String, Double> table() {
        return table;
    }

    public OperationFactory factory() {
        return factory;
    }

}
