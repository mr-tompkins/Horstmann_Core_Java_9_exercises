package chapter6.exercise1_2;

import java.util.Optional;

public interface Stack<T> {
    void push(final T value);

    Optional<T> pop();

    boolean isEmpty();
}
