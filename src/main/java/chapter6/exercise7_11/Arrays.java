package chapter6.exercise7_11;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public final class Arrays {

    public static <T extends Comparable<? super T>> Optional<Pair<T>> firstLast(final List<Pair<T>> pairs) {
        if (pairs == null || pairs.size() == 0) {
            return Optional.empty();
        }

        final T first = pairs.get(0).getFirst();
        final T second = pairs.get(pairs.size() - 1).getSecond();

        return Optional.of(new Pair<>(first, second));

    }

    public static <T extends Comparable<? super T>> Optional<T> max(final List<Pair<T>> pairs) {
        if (pairs == null) {
            return Optional.empty();
        }
        return pairs
                .parallelStream()
                .map(p -> Stream.of(p.getFirst(), p.getSecond()))
                .flatMap(Function.identity())
                .max(T::compareTo);
    }
}
