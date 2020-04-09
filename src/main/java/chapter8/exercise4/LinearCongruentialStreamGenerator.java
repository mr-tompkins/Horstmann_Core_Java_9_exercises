package chapter8.exercise4;

import java.math.BigInteger;
import java.util.stream.Stream;

public final class LinearCongruentialStreamGenerator {

    final private BigInteger c;
    final private BigInteger a;
    final private BigInteger base;
    final private int exp;

    private LinearCongruentialStreamGenerator(BigInteger c, BigInteger a, BigInteger base, int exp) {
        this.c = c;
        this.a = a;
        this.base = base;
        this.exp = exp;
    }

    public Stream<BigInteger> generate(final BigInteger seed) {
        return Stream.iterate(
                seed,
                x -> (a.multiply(x).add(c)).mod(base.pow(exp)));
    }

    public static class LinearCongruentialStreamGeneratorBuilder {
        private BigInteger c;
        private BigInteger a;
        private BigInteger base;
        private int exp;

        public LinearCongruentialStreamGeneratorBuilder() {
            this.c = new BigInteger("11");
            this.a = new BigInteger("25214903917");
            this.base = new BigInteger("2");
            this.exp = 48;
        }

        public LinearCongruentialStreamGenerator build() {
            return new LinearCongruentialStreamGenerator(c, a, base, exp);
        }

        public void setC(BigInteger c) {
            this.c = c;
        }

        public void setA(BigInteger a) {
            this.a = a;
        }

        public void setBase(BigInteger base) {
            this.base = base;
        }

        public void setExp(int exp) {
            this.exp = exp;
        }
    }
}
