package generics;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
    }

     static class Pair <T, S> {

        T p1;
        S p2;

        private Pair (T p1, S p2){
            this.p1 = p1;
            this.p2 = p2;
        }

        public T getFirst() {
            return p1;
        }

        public S getSecond() {
            return p2;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(p1, pair.p1) && Objects.equals(p2, pair.p2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(p1, p2);
        }

        public static <T, S> Pair <T, S> of(T p1, S p2) {
            return new Pair<>(p1, p2);
        }

    }
}
