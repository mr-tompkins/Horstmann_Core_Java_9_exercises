package chapter8.exercise14;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class ListsJoinerTest {

    private final List<String> EXPECTED_LIST_WHEN_STREAM_NOT_EMPTY = List.of("a", "b", "c", "d", "e", "f");
    private List<String> a;
    private List<String> b;
    private List<String> c;

    @Before
    public void inti() {
        initializeFields();
    }

    @Test
    public void whenProvidedNotEmptyStream_thenReturnsJoinedLists() {
        assertThat(ListsJoiner.join(Stream.of(a, b, c)), equalTo(EXPECTED_LIST_WHEN_STREAM_NOT_EMPTY));
    }

    @Test
    public void whenProvidedEmptyStream_thenReturnsEmptyList() {
        assertThat(ListsJoiner.join(Stream.empty()), equalTo(Collections.EMPTY_LIST));
    }

    private void initializeFields() {
        a = new ArrayList<>();
        a.add("a");
        a.add("b");
        b = new ArrayList<>();
        b.add("c");
        b.add("d");
        c = new ArrayList<>();
        c.add("e");
        c.add("f");
    }
}
