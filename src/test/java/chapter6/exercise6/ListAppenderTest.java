package chapter6.exercise6;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.stream.Collectors;

import static chapter6.exercise6.TestUtils.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class ListAppenderTest {

    private final List<Derived> source;
    private final List<Base> dest;
    @Rule
    public ExpectedException expected;

    public ListAppenderTest() {
        source = createSource();
        dest = createDestination();
        expected = ExpectedException.none();
    }

    @Test
    public void shouldAppendValues_whenUsedWildcardWithExtends() {
        ListAppender.append1(source, dest);

        assertThat(getObjectsClassesInDest(dest), equalTo(EXPECTED_OBJECTS_CLASSES));
    }

    @Test
    public void shouldAppendValues_whenUsedWildcardWithSuper() {
        ListAppender.append2(source, dest);

        assertThat(getObjectsClassesInDest(dest), equalTo(EXPECTED_OBJECTS_CLASSES));
    }

    @Test
    public void whenFirstArgumentIsNull_thenThrowsException() {
        expected.expect(IllegalArgumentException.class);
        ListAppender.append1(null, dest);
    }

    @Test
    public void whenSecondArgumentIsNull_thenThrowsException() {
        expected.expect(IllegalArgumentException.class);
        ListAppender.append1(source, null);
    }

    private List<String> getObjectsClassesInDest(final List<? extends Base> dest) {
        return dest
                .stream()
                .map(o -> o.getClass().getSimpleName())
                .collect(Collectors.toList());
    }
}
