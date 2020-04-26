package chapter6.exercise6;

import java.util.List;

public final class ListAppender {

    public static <T> void append1(final List<? extends T> source, final List<T> destination) {
        if (source == null || destination == null) {
            throw new IllegalArgumentException();
        }
        for (T e : source) {
            destination.add(e);
        }
    }

    public static <T> void append2(final List<T> source, final List<? super T> destination) {
        if (source == null || destination == null) {
            throw new IllegalArgumentException();
        }
        for (T e : source) {
            destination.add(e);
        }
    }
}
