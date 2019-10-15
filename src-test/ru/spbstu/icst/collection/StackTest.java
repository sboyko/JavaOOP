package ru.spbstu.icst.collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class StackTest {

    private Stack<Integer> stack;

    @Before
    public void setUp() {
        stack = new ArrayStack<>(0);
    }

    @After
    public void tearDown() {
    }

    @Test(expected = EmptyStackException.class)
    public void emptyThrows() {
        stack.pop();
    }

    @Test
    public void addSingleElement() {
        stack.add(10);
        assertEquals(10, stack.peek(), 0);
    }

    @Test
    public void addMultipleElements() {
        final int ELEMENTS_COUNT = 1000;

        for (int i = 0; i <= ELEMENTS_COUNT; ++i) {
            stack.add(i);
        }
        assertEquals(ELEMENTS_COUNT, stack.peek(), 0);
    }

}