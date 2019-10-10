package ru.spbstu.icst.calculator;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.spbstu.icst.calculator.ExecutionContext;
import ru.spbstu.icst.calculator.exception.CalculatorException;
import ru.spbstu.icst.calculator.exception.SyntaxException;
import ru.spbstu.icst.calculator.operation.OperationFactoryImpl;
import ru.spbstu.icst.calculator.operation.PlusOperation;
import ru.spbstu.icst.calculator.operation.PushOperation;

public class OperationTest extends TestCase {

    private ExecutionContext context;
    private OperationFactory factory = new OperationFactoryImpl();

    @Before
    public void setUp() throws Exception {
        context = new ExecutionContext(factory);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testPush() throws CalculatorException {
        new PushOperation("5").execute(context);

        assertEquals(5, context.stack().peek(), 0.0);
    }

    @Test
    public void testPlus() throws CalculatorException {
        new PushOperation("5").execute(context);
        new PushOperation("10").execute(context);
        new PlusOperation().execute(context);

        assertEquals(15, context.stack().peek(), 0.0);
    }
}