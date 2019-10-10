package ru.spbstu.icst.calculator;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.spbstu.icst.calculator.exception.CalculatorException;
import ru.spbstu.icst.calculator.operation.OperationFactoryImpl;
import ru.spbstu.icst.calculator.operation.PlusOperation;
import ru.spbstu.icst.calculator.operation.PushOperation;

public class CalculatorTest extends TestCase {

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
        context.factory().create("push 5").execute(context);

        assertEquals(5, context.stack().peek(), 0.0);
    }

    @Test
    public void testPlus() throws CalculatorException {
        context.factory().create("push 10").execute(context);
        context.factory().create("push 5").execute(context);
        context.factory().create("+").execute(context);

        assertEquals(15, context.stack().peek(), 0.0);
    }
}