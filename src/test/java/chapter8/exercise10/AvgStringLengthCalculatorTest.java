package chapter8.exercise10;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.stream.Stream;

import static chapter8.exercise10.AvgStringLengthCalculator.calculate;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class AvgStringLengthCalculatorTest {

    final Stream<String> NOT_EMPTY_STREAM = Stream.of("a", "bb", "ccc", "dddd");
    final double NOT_EMPTY_STREAM_AVG_WORD_LEN = 2.5;
    final Stream<String> EMPTY_STREAM = Stream.empty();
    final double EMPTY_STREAM_AVG_WORD_LEN = 0;

    @Test
    public void whenStreamNotEmpty_returnsAverageWorldLength() {
        assertThat(calculate(NOT_EMPTY_STREAM), equalTo(NOT_EMPTY_STREAM_AVG_WORD_LEN));
    }

    @Test
    public void whenStreamEmopty_returnsZero() {
        assertThat(calculate(EMPTY_STREAM), equalTo(EMPTY_STREAM_AVG_WORD_LEN));
    }
}
