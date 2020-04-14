package chapter8.exercise10;

import java.util.stream.Stream;

public final class AvgStringLengthCalculator {

    public static double calculate(Stream<String> strings) {
        return strings
                .mapToInt(String::length)
                .average()
                .orElse(0.0);
    }
}
