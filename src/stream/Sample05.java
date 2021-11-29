package stream;

import java.util.Optional;
import java.util.OptionalInt;

public class Sample05 {
    // T 타입 객체의 래퍼 클래스 : Optional<T>
    // 1. null을 직접 다루는 것은 NullPointException 때문에 위험하니 객체에 넣어 간접적으로 null을 다룬다.
    // 2. null 체크르 위해 if문에 필수이다. 코드가 지저분하기 때문에 간결하게 다루기 위함이다.

    // Optional<String> optVal = Optional.empty(); 초기화 할 때

    public static void main(String[] args) {

//        int [] arr = null;
        int[] arr = new int[0];
        System.out.println("arr.length : " + arr.length);

//        Optional<String> opt = null; // OK.하지만 바람직 X
        Optional<String> opt = Optional.empty();
//        Optional<String> opt = Optional.of("abc");
        System.out.println("opt = " + opt);

        String str = "";
        try {
            str = opt.get();
        } catch (Exception e) {
            str = ""; // 예외가 발생하면 빈문자열("")로 초기화
        }
//        str = opt.orElse("EMPTY"); // Optional 저장된 값이 null이면 "" 반환
        str = opt.orElseGet(String::new);
        System.out.println("str = " + str);
        System.out.println();

//      IF or For 문을 안으로 다 숨겨 놨기 때문에 간결해 보이지만 성능적으로는 떨어진다.
        // 성능적인 문제로 기본형 값을 감싸는 래퍼 클래스 : OptionalInt , OptionalLong, OptionalDouble
        // 값이 있는지 없는지 확인하기 위한 isPresent 메소드가 있다.


        Optional<String>  optStr = Optional.of("abcde");
        Optional<Integer> optInt = optStr.map(String::length);
        System.out.println("optStr="+optStr.get());
        System.out.println("optInt="+optInt.get());

        int result1 = Optional.of("123")
            .filter(x->x.length() >0)
            .map(Integer::parseInt).get();

        int result2 = Optional.of("")
            .filter(x->x.length() >0)
            .map(Integer::parseInt).orElse(-1);

        System.out.println("result1="+result1);
        System.out.println("result2="+result2);

        Optional.of("456").map(Integer::parseInt)
            .ifPresent(x->System.out.printf("result3=%d%n",x));

        OptionalInt optInt1  = OptionalInt.of(0);   // 0À» ÀúÀå
        OptionalInt optInt2  = OptionalInt.empty(); // ºó °´Ã¼¸¦ »ý¼º

        System.out.println(optInt1.isPresent());   // true
        System.out.println(optInt2.isPresent());   // false

        System.out.println(optInt1.getAsInt());  // 0
//		System.out.println(optInt2.getAsInt());  // NoSuchElementException
        System.out.println("optInt1="+optInt1);
        System.out.println("optInt2="+optInt2);
        System.out.println("optInt1.equals(optInt2)?"+optInt1.equals(optInt2));

    }
}
