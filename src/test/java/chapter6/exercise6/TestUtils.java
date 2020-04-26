package chapter6.exercise6;

import java.util.ArrayList;
import java.util.List;

public final class TestUtils {

    public static List<String> EXPECTED_OBJECTS_CLASSES =
            List.of("Base", "Base", "Derived", "Derived");

    public static List<Derived> createSource() {
        return List.of(new Derived(), new Derived());
    }

    public static List<Base> createDestination() {
        List<Base> list = new ArrayList<>();
        list.add(new Base());
        list.add(new Base());
        return list;
    }

    public static class Base {
    }

    public static class Derived extends Base {
    }
}
