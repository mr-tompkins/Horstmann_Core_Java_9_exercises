package chapter6.exercise1_2;

import java.util.Optional;

public final class TypeVariableArrayBasedStack<T> implements Stack<T> {

    final private int DEFAULT_SIZE = 20;

    private T[] stack;
    private int top;

    @SuppressWarnings("unchecked")
    public TypeVariableArrayBasedStack() {
        stack = (T[]) new Object[DEFAULT_SIZE];
    }

    @SuppressWarnings("unchecked")
    public TypeVariableArrayBasedStack(int size) {
        stack = (T[]) new Object[size];
    }

    @Override
    public void push(T value) {
        if (top >= stack.length) {
            resize();
        }
        stack[top++] = value;
    }

    @Override
    public Optional<T> pop() {
        if (isEmpty()) {
            return Optional.empty();
        } else {
            top--;
            return Optional.of(stack[top]);
        }
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] tmp = stack;
        stack = (T[]) new Object[stack.length + DEFAULT_SIZE];
        System.arraycopy(tmp, 0, stack, 0, tmp.length);
    }
}
