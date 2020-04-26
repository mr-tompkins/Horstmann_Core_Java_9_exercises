package chapter6.exercise6;

import java.util.List;

public final class ListAppender {

    public static <T> void append1(final List<? extends T> source, final List<T> destination) {
        for (T e : source) {
            destination.add(e);
        }
    }

    public static <T> void append2(final List<T> source, final List<? super T> destination) {
        for (T e : source) {
            destination.add(e);
        }
    }
}
