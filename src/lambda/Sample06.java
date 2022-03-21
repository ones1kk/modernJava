package lambda;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import lambda.Sample05.SampleUser;

public class Sample06 {

    // 메서드 참조(Method reference)
    // 클래스이름::메서드 이름
    public static void main(String[] args) {
        Function<String, Integer> f = Integer::parseInt;

        BiFunction<String, String, SampleUser> f2 = SampleUser::new;

        Supplier<SampleUser> s = SampleUser::new;
        System.out.println(s);
        System.out.println(s.get());

        Function<String, SampleUser> f1 = SampleUser::new;
        System.out.println(f1.apply("kim").getLastName());

        Function<Integer, int[]> f3 = int[]::new;
        int[] arr = f3.apply(6);

        System.out.println(arr.length);


    }

}
