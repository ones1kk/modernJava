package lambda;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;

public class Sample04 {

    public static void main(String[] args) {

        boolean result = Predicate.isEqual("abc").test("ab");
        System.out.println(result);

        Function<String, Integer> f  = (s) -> Integer.parseInt(s, 16);
        Function<Integer, String>	g  = (i) -> Integer.toBinaryString(i);

        Function<String, String>    h  = f.andThen(g); // f의 출력값이 g의 입력값과 같기때문에 가능  f -> g
        Function<Integer, Integer>  h2 = f.compose(g); // g -> f

        System.out.println(h.apply("FF")); // "FF" → 255 → "11111111"
        System.out.println(h2.apply(2));   // 2 → "10" → 16

        Function<String, String> f2 = x -> x; // 항등 함수(identity function)
        System.out.println(f2.apply("AAA"));  // AAA가 그대로 출력됨

        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i%2 == 0;
        Predicate<Integer> notP = p.negate(); // i >= 100

        Predicate<Integer> all = notP.and(q.or(r));
        System.out.println(all.test(150));       // true

        String str1 = "abc";
        String str2 = "abc";

        // str1과 str2가 같은지 비교한 결과를 반환
        Predicate<String> p2 = Predicate.isEqual(str1);
        boolean result1 = p2.test(str2);
        System.out.println(result1);
    }
}
