package chapter6.exercise6;

import org.junit.Test;
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

    public ListAppenderTest() {
        source = createSource();
        dest = createDestination();
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

    private List<String> getObjectsClassesInDest(final List<? extends Base> dest) {
        return dest
                .stream()
                .map(o -> o.getClass().getSimpleName())
                .collect(Collectors.toList());
    }
}
