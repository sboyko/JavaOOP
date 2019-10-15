package ru.spbstu.icst.collection;

public interface Stack<T> extends Iterable<T> {

    void add(T d);

    T pop();

    T peek();

    boolean empty();

    default void addAll(Iterable<? extends T> otherStack) {
        for (T e : otherStack) {
            add(e);
        }
    }

}
