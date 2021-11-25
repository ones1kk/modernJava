package stream;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sample01 {
    // 다양한 데이터 소스를 표준화된 방법을 다루기 위한 것.
    // 스트림은 데이터소스로부터 데이터를 읽기만할 뿐 변경하지 않는다.
    // 스트림은 일회용이다. (필요하다면 다시 스트림을 생성해야 함)
    // 스트림은 최종 연산 전까지 중간연산이 수행되지 않는다. - 지연된 연산
    // 스트림은 작업을 내부 반복으로 처리힌다.
    // 스트림의 작업을 병렬로 처리 - 병렬스트림 (멀티 쓰레드) ex) parallel() 병렬 스트림으로 전환(속성만 변경됨)
    // 기본형 스트림 - IntStream, LongStream, DoubleStream : 오토박싱 & 언박싱의 비효율이 제거됨

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        Stream<Integer> intStream = list.stream();
        intStream.forEach(System.out::print);

        intStream = list.stream();
        intStream.forEach(System.out::print);

        System.out.println();

        String[] strArr = {"a", "b", "c", "d"};
//        Stream<String> strStream = Stream.of(strArr);
        Stream<String> strStream = Arrays.stream(strArr);
        strStream.forEach(System.out::printf);

        System.out.println();

        int[] intArr = {1, 2, 3, 4, 5, 6};
        IntStream intStream1 = Arrays.stream(intArr);
        System.out.println("count = " + intStream1.count());
//        System.out.println("sum = "+intStream1.sum());

        System.out.println();

        IntStream intStream2 = new Random().ints(1, 46);
        intStream2.distinct().limit(6).sorted().forEach(System.out::println);

        System.out.println();

        // 스트림 만들기 - 람다식 iterate(), generate()

        // iterate()는 이전 요소를 seed로 해서 다음 요소를 계산한다. (T seed, UnaryOperator f) 단항 연산자
        Stream<Integer> evenStream = Stream.iterate(0, n -> n + 2).limit(10);
        evenStream.forEach(System.out::print);

        System.out.println();

        // generate()는 seed를 사용하지 않는다. (Supplier)
        Stream<Double> randomStream = Stream.generate(Math::random).limit(5);
        randomStream.forEach(System.out::print);

        System.out.println();

        Stream<Integer> oneStream = Stream.generate(()->1).limit(5);
        oneStream.forEach(System.out::print);

        System.out.println();

        // 파일을 소스로 하는 스트림 생성하기
        // Files.lines(Path path) BufferedReader 클래스의 메서드

        // 비어있는 스트림
        // Stream.empty()

    }

}
