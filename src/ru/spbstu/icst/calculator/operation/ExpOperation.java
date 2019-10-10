package ru.spbstu.icst.calculator.operation;

import ru.spbstu.icst.calculator.ExecutionContext;
import ru.spbstu.icst.calculator.Operation;
import ru.spbstu.icst.calculator.exception.ExecutionException;
import ru.spbstu.icst.calculator.exception.SyntaxException;

import java.util.ArrayList;
import java.util.List;

public class ExpOperation implements Operation {

    private final List<String> lexems = new ArrayList<>();

    public ExpOperation(String... args) throws SyntaxException {
        String expression = String.join("", args);

        // convert expression into reverse polish notation
        // ..
    }

    @Override
    public void execute(ExecutionContext context) throws ExecutionException {
        for (String token : lexems) {
            Operation op;

            try {
                if (DefineOperation.NAME_PATTERN.matcher(token).matches()
                        || DefineOperation.DOUBLE_PATTERN.matcher(token).matches()) {
                    op = context.factory().create("push " + token);
                } else {
                    op = context.factory().create(token);
                }
            } catch (SyntaxException e) {
                throw new ExecutionException(String.format("failed to process '%s'", token));
            }

            op.execute(context);
        }
    }
}
