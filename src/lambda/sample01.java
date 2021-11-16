package lambda;

public class sample01 {

  // since jdk 1.8 힘수형 언어 등장
  // function(method)를 간단 한 식(expression)으로 표현하는 방법
  // 익명 함수 ( anonymous function) : 반환 타입, 이름을 지움

  // 반환값이 있는 경우
  // (int a, int b) -> a > b ? a : b;
  // return, ; 생략 가능
  // 매개변수의 타입이 추론 가능하면 생략가능
  // (a, b) -> a > b ? a : b
  // ==> (a, b) -> Math::max;

  // 주의 사항
  // 1. 매개 변수가 하나인 경우 괄호 생략 가능 ( 타입이 없을 때만)
  // a -> a * a  // ok
  // int a -> a * a  // error

  // 2. 블록 안의 문장이 하나뿐 일 때, {}, ; 생략 가능
  // (int i) -> System.out.println(i)
  // 단 하나뿐인 문장이 return일 떄는 {} 생략 불가능
  // (int a, int b) ->{ return a > b ? a: b }

  /**
   * ============================================================================================================
   * 람다식은 익명 객체 (a, b) -> a > b ? a : b ===== new Object() { int max(int a, int b) { return a > b ?a :b ; } }
   * ============================================================================================================
   */

  public static void main(String[] args) {
    // Object object = (a, b) -> a < b ? a : b; // 람다식. 익명 객체

    Object object = new Object() {
      int max(int a, int b) {
        return a > b ? a : b;
      }
      // int value = obj.max(3,5); // error
    };
  }
}