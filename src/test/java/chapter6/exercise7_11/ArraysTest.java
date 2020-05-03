package chapter6.exercise7_11;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class ArraysTest {

    private final Integer MAX = 9;
    private final Integer MIN = 2;

    @Test
    public void whenInputIsNull_thenAllMethodsReturnsEmptyOptional() {
        List<Pair<Integer>> input = null;

        assertThat(Arrays.max(input), equalTo(Optional.empty()));
        assertThat(Arrays.firstLast(input), equalTo(Optional.empty()));
        assertThat(Arrays.min(input), equalTo(Optional.empty()));
    }

    @Test
    public void whenInputListIsEmpty_thenAllMethodsReturnsEmptyOptional() {
        List<Pair<Integer>> input = Collections.emptyList();

        assertThat(Arrays.max(input), equalTo(Optional.empty()));
        assertThat(Arrays.firstLast(input), equalTo(Optional.empty()));
        assertThat(Arrays.min(input), equalTo(Optional.empty()));
    }

    @Test
    public void whenInputListIsNotEmpty_thenReturnsMaximum() {
        List<Pair<Integer>> input = createNotEmptyList();

        assertThat(Arrays.max(input).get(), equalTo(MAX));
    }

    @Test
    public void whenInputIsNotEmpty_thenReturnsMinimum() {
        List<Pair<Integer>> input = createNotEmptyList();

        assertThat(Arrays.min(input).get(), equalTo(MIN));
    }

    @Test
    public void whenInputListIsNotEmpty_thenReturnsPairOfFirstAndLastElements() {
        List<Pair<Integer>> input = createNotEmptyList();
        Pair<Integer> expected = new Pair<>(3, 4);

        assertThat(Arrays.firstLast(input).get(), equalTo(expected));
    }

    private List<Pair<Integer>> createNotEmptyList() {
        List<Pair<Integer>> list = new ArrayList<>();
        list.add(new Pair<>(3, 5));
        list.add(new Pair<>(8, MIN));
        list.add(new Pair<>(MAX, 4));
        return list;
    }
}
