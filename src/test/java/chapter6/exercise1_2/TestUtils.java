package chapter6.exercise1_2;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

final class TestUtils {

    public static final List<String> EXPECTED_VALUES_ON_STACK = List.of("a", "b", "c");
    public static final List<String> EXPECTED_VALUES_RETURNED_FROM_STACK = List.of("c", "b", "a");

    public static BasicStack<String> createEmptyBasicStack() {
        return new BasicStack<>();
    }

    public static BasicStack<String> createNotEmptyBasicStack() throws NoSuchFieldException, IllegalAccessException {
        BasicStack<String> stack = new BasicStack<>();
        fillStack(stack);
        return stack;
    }

    @SuppressWarnings("unchecked")
    private static void fillStack(final BasicStack<String> stack) throws NoSuchFieldException, IllegalAccessException {
        Class<BasicStack<String>> clazz = (Class<BasicStack<String>>) stack.getClass();
        Field stackField = clazz.getDeclaredField("stack");
        stackField.setAccessible(true);
        stackField.set(stack, createValuesOnStack());
    }

    @SuppressWarnings("unchecked")
    public static List<String> getStackValues(final BasicStack<String> stack) throws NoSuchFieldException, IllegalAccessException {
        Class<BasicStack<String>> clazz = (Class<BasicStack<String>>) stack.getClass();
        Field stackField = clazz.getDeclaredField("stack");
        stackField.setAccessible(true);
        return (List<String>) stackField.get(stack);
    }

    private static List<String> createValuesOnStack() {
        final List<String> valuesOnStack = new ArrayList<>();
        valuesOnStack.add("a");
        valuesOnStack.add("b");
        valuesOnStack.add("c");
        return valuesOnStack;
    }
}
