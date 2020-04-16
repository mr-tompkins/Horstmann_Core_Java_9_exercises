package chapter8.exercise11;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class MaxLengthStringsFinderTest {

    private final Stream<String> NOT_EMPTY_STREAM = Stream.of("a", "bb", "ccc", "ddd", "eee", "tt");
    private final List<String> EXPECTED_RESULT_WHEN_PROVIDED_NOT_EMPTY_STREAM = List.of("ccc", "ddd", "eee");

    private final Stream<String> EMPTY_STREAM = Stream.empty();
    private final List<String> EXPECTED_RESULT_WHEN_PROVIDED_EMPTY_STREAM = Collections.emptyList();

    @Test
    public void whenProvidedNotEmptyStream_returnsListOfMaxStrings() {
        assertThat(
                EXPECTED_RESULT_WHEN_PROVIDED_NOT_EMPTY_STREAM,
                equalTo(MaxLengthStringsFinder.find(NOT_EMPTY_STREAM)));
    }

    @Test
    public void whenProvidedEmptyStream_returnsEmptyList() {
        assertThat(
                EXPECTED_RESULT_WHEN_PROVIDED_EMPTY_STREAM,
                equalTo(MaxLengthStringsFinder.find(EMPTY_STREAM))
        );
    }
}
