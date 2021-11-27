package stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Sample04 {

    public static void main(String[] args) {
        Stream<String[]> strArrStrm = Stream.of(
            new String[]{"abc", "def", "jkl"},
            new String[]{"ABC", "GHI", "JKL"}
        );

//		Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream);
        Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);

        strStrm.map(String::toLowerCase)
            .distinct()
            .sorted()
            .forEach(System.out::println);
        System.out.println();

        String[] lineArr = {
            "Believe or not It is true",
            "Do or do not There is no try",
        };

        /*
        TODO: 2021/11/28   flatMap & Map
         */
        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +")))
            .map(String::toLowerCase)
            .distinct()
            .sorted()
            .forEach(System.out::println);
        System.out.println();
    }
}
