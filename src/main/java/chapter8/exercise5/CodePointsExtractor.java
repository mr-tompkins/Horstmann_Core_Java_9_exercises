package chapter8.exercise5;

import java.util.stream.IntStream;
import java.util.stream.Stream;

//TODO finish

public final class CodePointsExtractor {

    public Stream<String> extract(String s) {
        int seed = 0;
        return IntStream
                .iterate(
                        seed,
                        i -> i < s.length(),
                        (i) -> {
                            int j = s.offsetByCodePoints(i, 1);
                            return j;
                        })
                .mapToObj(i -> s.substring(i,1));
    }
}
