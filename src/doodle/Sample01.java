package doodle;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample01 {

    public static void main(String[] args) {
        Set<String> set = Stream.of("test1", "test2", "test3", "test4", "test5", "test6", "test7",
                "test8")
            .collect(Collectors.toSet());

        Generator<Object> aaa = Generator.builder("aaa", set).build();
        System.out.println("aaa = " + aaa);
        System.out.println(Generator.builder("aaa", set).build().name);
        System.out.println(Generator.builder("aaa", set).build().set);
    }

    public static class Generator<T> {

        private final String name;

        private final Set<T> set;

        private final Map<String, Function<T, String>[]> converterMap;

        public Generator(String name, Set<T> set, Map<String, Function<T, String>[]> converterMap) {
            this.name = name;
            this.set = set;
            this.converterMap = converterMap;
        }


        public static <T> Builder<T> builder(String name, Set<String> set) {
            return new Builder(name, set);
        }


        static class Builder<T> {

            private final String name;

            private final Set<T> set;

            private final Map<String, Function<T, String>[]> converterMap = new HashMap<>();
            ;

            Builder(String name, Set<T> set) {
                this.name = name;
                this.set = set;
            }

            public Builder<T> add(String name, Function<T, String> keyFunc,
                Function<T, String> valFunc) {
                this.converterMap.put(name, new Function[]{keyFunc, valFunc});
                return this;
            }

            public Generator<T> build() {
                return new Generator<>(name, set, converterMap);
            }
        }
    }

}

