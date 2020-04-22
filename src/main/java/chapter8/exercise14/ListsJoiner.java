package chapter8.exercise14;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public final class ListsJoiner {

    public static <T> List<T> join(Stream<List<T>> lists) {
        return lists
                .reduce((a, b) -> {
                    a.addAll(b);
                    return a;
                })
                .orElse(Collections.EMPTY_LIST);
    }
}
