package chapter8.exercise11;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public final class MaxLengthStringsFinder {

    private final static Integer INTEGER_STUB = 0;

    public static List<String> find(Stream<String> strings) {
        return strings
                .collect(Collectors.groupingBy(String::length))
                .entrySet()
                .stream()
                .max(comparing(Map.Entry::getKey))
                .orElse(new SimpleImmutableEntry<Integer, List<String>>(INTEGER_STUB, Collections.EMPTY_LIST))
                .getValue();
    }
}
