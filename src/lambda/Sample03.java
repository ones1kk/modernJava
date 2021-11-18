package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Sample03 {
    // Runnable == void
    // Supplier<T> == 매개변수는 없고 반환값만 있음
    // Consumer<T> == 매개변수만 있고 반환값이 없음
    // Function<T,R> == 하나의 매개변수를 받아서 결과를 반환
    // Predicate<T> == 조건식을 표현하는데 사용 매개변수 1개 반환 타입 boolean

    // 매개변수가 2개인 함수형 인터페이스
    // BiConsumer<T,U>
    // BiPredicate<T,U>
    // BiFunction<T,U,R>
    // --> Supplier는 매개변수가 없기때문에 없다

    // 매개변수와 반환타입 값이 일치하는 함수형 인터페이스
    // UnaryOperator<T> : 단항 연산지
    // BinaryOperator<T> : 이항 연산자
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;
        Consumer<Integer> c = i -> System.out.print(i + ", ");
        Predicate<Integer> p = i -> i % 2 == 0;
        Function<Integer, Integer> f = i -> i / 10 * 10; // iÀÇ ÀÏÀÇ ÀÚ¸®¸¦ ¾ø¾Ø´Ù.

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);
        System.out.println(list);
        printEvenNum(p, c, list);
        List<Integer> newList = doSomething(f, list);
        System.out.println(newList);
    }

    static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<T>(list.size());

        for (T i : list) {
            newList.add(f.apply(i));
        }

        return newList;
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for (T i : list) {
            if (p.test(i)) {
                c.accept(i);
            }
        }
        System.out.println("]");
    }

    static <T> void makeRandomList(Supplier<T> s, List<T> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());
        }
    }
}
