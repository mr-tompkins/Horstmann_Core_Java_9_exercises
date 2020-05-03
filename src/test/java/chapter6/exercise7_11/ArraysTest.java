package chapter6.exercise7_11;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static chapter6.exercise7_11.TestUtils.Base;
import static chapter6.exercise7_11.TestUtils.Derived;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class ArraysTest {

    private final Base MAX;
    private final Base MIN;
    private final Base FIRST;
    private final Base LAST;

    public ArraysTest() {
        MAX = new Derived(9);
        MIN = new Derived(1);
        FIRST = new Derived(3);
        LAST = new Derived(4);
    }

    @Test
    public void whenInputIsNull_thenAllMethodsReturnsEmptyOptional() {
        List<Pair<Base>> input = null;

        assertThat(Arrays.max(input), equalTo(Optional.empty()));
        assertThat(Arrays.firstLast(input), equalTo(Optional.empty()));
        assertThat(Arrays.min(input), equalTo(Optional.empty()));
    }

    @Test
    public void whenInputListIsEmpty_thenAllMethodsReturnsEmptyOptional() {
        List<Pair<Base>> input = Collections.emptyList();

        assertThat(Arrays.max(input), equalTo(Optional.empty()));
        assertThat(Arrays.firstLast(input), equalTo(Optional.empty()));
        assertThat(Arrays.min(input), equalTo(Optional.empty()));
    }

    @Test
    public void whenInputListIsNotEmpty_thenReturnsMaximum() {
        List<Pair<Base>> input = createNotEmptyList();

        assertThat(Arrays.max(input).get(), equalTo(MAX));
    }

    @Test
    public void whenInputIsNotEmpty_thenReturnsMinimum() {
        List<Pair<Base>> input = createNotEmptyList();

        assertThat(Arrays.min(input).get(), equalTo(MIN));
    }

    @Test
    public void whenInputListIsNotEmpty_thenReturnsPairOfFirstAndLastElements() {
        List<Pair<Base>> input = createNotEmptyList();
        Pair<Base> expected = new Pair<>(FIRST, LAST);

        assertThat(Arrays.firstLast(input).get(), equalTo(expected));
    }

    private List<Pair<Base>> createNotEmptyList() {
        List<Pair<Base>> list = new ArrayList<>();
        list.add(new Pair<>(FIRST, new Base(5)));
        list.add(new Pair<>(new Derived(8), MIN));
        list.add(new Pair<>(MAX, LAST));
        return list;
    }
}
