package ru.spbstu.icst.calculator.operation;

import ru.spbstu.icst.calculator.ExecutionContext;
import ru.spbstu.icst.calculator.Operation;
import ru.spbstu.icst.calculator.exception.ExecutionException;
import ru.spbstu.icst.calculator.exception.SyntaxException;

import java.util.regex.Pattern;

public class DefineOperation implements Operation {

    public static final Pattern NAME_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9_]*");
    public static final Pattern DOUBLE_PATTERN = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?");

    private final String name;
    private final double value;

    public DefineOperation(String... args) throws SyntaxException {
        // validate arguments
        if (args.length < 2) {
            throw new SyntaxException("Not enough arguments for \"define\" operation");
        }

        if (NAME_PATTERN.matcher(args[0]).matches()) {
            name = args[0];
        } else {
            throw new SyntaxException("Incorrect constant name");
        }

        if (DOUBLE_PATTERN.matcher(args[1]).matches()) {
            value = Double.valueOf(args[1]);
        } else {
            throw new SyntaxException("Malformed value");
        }
    }


    @Override
    public void execute(ExecutionContext context) throws ExecutionException {
        if (context.table().containsKey(name)) {
            throw new ExecutionException(String.format("duplicated name '%s'", name));
        }

        context.table().put(name, value);
    }
}
