package chapter8.exercise4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(JUnit4.class)
public class LinearCongruentialStreamGeneratorTest {

    private static final int ELEMENTS_LIMIT = 15;
    private final LinearCongruentialStreamGenerator generator;

    public LinearCongruentialStreamGeneratorTest() {
        generator = new LinearCongruentialStreamGenerator.LinearCongruentialStreamGeneratorBuilder().build();
    }

    @Test
    public void whenSameSeed_thenGeneratesSameStreamEachTime() {
        List<BigInteger> first = generator
                .generate(BigInteger.valueOf(7))
                .limit(ELEMENTS_LIMIT)
                .collect(Collectors.toList());

        List<BigInteger> second = generator
                .generate(BigInteger.valueOf(7))
                .limit(ELEMENTS_LIMIT)
                .collect(Collectors.toList());

        assertEquals(first, second);
    }

    @Test
    public void whenDifferentSeed_thenGeneratesDifferentStreamEachTime() {
        List<BigInteger> first = generator
                .generate(BigInteger.valueOf(7))
                .limit(ELEMENTS_LIMIT)
                .collect(Collectors.toList());

        List<BigInteger> second = generator
                .generate(BigInteger.valueOf(5))
                .limit(ELEMENTS_LIMIT)
                .collect(Collectors.toList());

        assertNotEquals(first, second);
    }
}
