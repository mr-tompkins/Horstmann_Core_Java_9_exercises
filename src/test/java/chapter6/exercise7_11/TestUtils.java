package chapter6.exercise7_11;

public final class TestUtils {

    static class Base implements Comparable<Base> {

        public int val;

        public Base(int val) {
            this.val = val;
        }

        @Override
        public int compareTo(Base o) {
            return val >= o.val ? 1 : -1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Base base = (Base) o;

            return val == base.val;
        }

        @Override
        public int hashCode() {
            return val;
        }
    }

    static class Derived extends Base {

        public Derived(int val) {
            super(val);
        }
    }
}
