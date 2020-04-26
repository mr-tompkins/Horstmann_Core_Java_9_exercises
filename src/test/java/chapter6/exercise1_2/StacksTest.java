package chapter6.exercise1_2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static chapter6.exercise1_2.TestUtils.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

//TODO add tests for ObjectArrayBasedStack and TypeParameterArrayBasedStack

@RunWith(JUnit4.class)
public class StacksTest {

    @Test
    public void whenStackEmpty_thenReturnsEmptyOptional() {
        assertThat(createEmptyBasicStack().pop(), equalTo(Optional.empty()));
    }

    @Test
    public void whenStackNotEmpty_thenReturnsElements() throws NoSuchFieldException, IllegalAccessException {
        BasicStack<String> stack = createNotEmptyBasicStack();

        List<String> returnedValues = new ArrayList<>();
        returnedValues.add(stack.pop().get());
        returnedValues.add(stack.pop().get());
        returnedValues.add(stack.pop().get());

        assertThat(returnedValues, equalTo(EXPECTED_VALUES_RETURNED_FROM_STACK));
    }

    @Test
    public void shouldAddValuesToStack() throws NoSuchFieldException, IllegalAccessException {
        BasicStack<String> stack = createNotEmptyBasicStack();
        List<String> stackValues = getStackValues(stack);

        assertThat(stackValues, equalTo(EXPECTED_VALUES_ON_STACK));
    }
}
