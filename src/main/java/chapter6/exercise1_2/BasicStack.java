package chapter6.exercise1_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class BasicStack<T> implements Stack<T> {

    private final List<T> stack;

    public BasicStack() {
        stack = new ArrayList<>();
    }

    @Override
    public void push(T value) {
        stack.add(value);
    }

    @Override
    public Optional<T> pop() {
        return isEmpty() ? Optional.empty() : Optional.of(stack.remove(stack.size() - 1));
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
