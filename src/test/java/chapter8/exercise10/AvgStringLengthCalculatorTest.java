package chapter8.exercise10;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.stream.Stream;

import static chapter8.exercise10.AvgStringLengthCalculator.calculate;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class AvgStringLengthCalculatorTest {

    private final Stream<String> NOT_EMPTY_STREAM = Stream.of("a", "bb", "ccc", "dddd");
    private final double EXPECTED_NOT_EMPTY_STREAM_AVG_WORD_LEN = 2.5;

    private final Stream<String> EMPTY_STREAM = Stream.empty();
    private final double EXPECTED_EMPTY_STREAM_AVG_WORD_LEN = 0;

    private final double ERROR_TOLERANCE = 0.0005;

    @Test
    public void whenStreamNotEmpty_returnsAverageWorldLength() {
        assertThat(calculate(NOT_EMPTY_STREAM), closeTo(EXPECTED_NOT_EMPTY_STREAM_AVG_WORD_LEN, ERROR_TOLERANCE));
    }

    @Test
    public void whenStreamEmpty_returnsZero() {
        assertThat(calculate(EMPTY_STREAM), closeTo(EXPECTED_EMPTY_STREAM_AVG_WORD_LEN, ERROR_TOLERANCE));
    }
}
