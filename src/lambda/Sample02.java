package lambda;

@FunctionalInterface // 함수형 인터페이스는 단 하나의 추상 메서드만 가져야 함.
interface MyFunction {

    // 인터페이스의 모든 메소드들은 public & abstract
    int max(int a, int b);

}


@FunctionalInterface
interface MyFunction1 {

    void run();
}

public class Sample02 {

    // 함수형 인터페이스
    // 단 하나의 추상 메서드만 선언된 인터페이스
    // 함수형 인터페이스 타입의 참조변수로 람다식을 참조할 수 있음 (단, 매서드와 람다식의 매개변수 개수와 타입이 일치해야함)

    static void execute(MyFunction1 f1) {
        f1.run();
    }

    static MyFunction1 getMyFunction() {
        return () -> System.out.println("f3.run()");
    }

    public static void main(String[] args) {
        // 람다식을 다루기 위한 참조변수의 타입은 함수형 인터페이스로 한다.
        MyFunction f = (a, b) -> a > b ? a : b;

        int value = f.max(3, 5);
        System.out.println("value : " + value);

        // 함수형 인터페이스 타입의 매개변수, 반환타입으로 활용 가능

        MyFunction1 f1 = () -> System.out.println("f1.run()");

        MyFunction1 f2 = new MyFunction1() {
            @Override
            public void run() {
                System.out.println("f2.run()");
            }
        };

        MyFunction1 f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();

        execute(f1);
        execute(() -> System.out.println("run()"));

    }


}
