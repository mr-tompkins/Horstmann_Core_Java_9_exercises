package chapter6.exercise1_2;

import java.util.Optional;

public final class ObjectArrayBasedStack<T> implements Stack<T> {

    final private int DEFAULT_SIZE = 20;
    int top;
    private Object[] stack;

    public ObjectArrayBasedStack() {
        stack = new Object[DEFAULT_SIZE];
        top = 0;
    }

    public ObjectArrayBasedStack(int size) {
        stack = new Object[size];
        top = 0;
    }

    @Override
    public void push(T value) {
        if (top >= stack.length) {
            resize();
        }
        stack[top++] = value;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<T> pop() {
        if (isEmpty()) {
            return Optional.empty();
        } else {
            top--;
            return Optional.of((T) stack[top]);
        }
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    private void resize() {
        Object[] tmp = stack;
        stack = new Object[stack.length + DEFAULT_SIZE];
        System.arraycopy(tmp, 0, stack, 0, tmp.length);
    }
}
