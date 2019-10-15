package ru.spbstu.icst.collection;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Array-based LIFO container
 */
public class ArrayStack<T> implements Stack<T> {

    private T[] storage;
    private int top;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException("Stack size must be greater or equal to zero");
        }
        @SuppressWarnings("unchecked") T[] newStorage = (T[]) new Object[initialSize];
        storage = newStorage;
    }

    @Override
    public void add(T d) {
        if (top == storage.length) {
            @SuppressWarnings("unchecked") T[] newStorage = (T[]) new Object[storage.length * 2 + 1];
            System.arraycopy(storage, 0, newStorage, 0, storage.length);
            storage = newStorage;
        }
        storage[top++] = d;
    }

    @Override
    public T pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return storage[--top];
    }

    @Override
    public T peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return storage[top - 1];
    }

    @Override
    public boolean empty() {
        return top == 0;
    }

    @Override
    public String toString() {
        return String.format("Stack with %d element(s)", top);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index < storage.length;
            }

            @Override
            public T next() {
                return storage[index++];
            }
        };
    }

}
