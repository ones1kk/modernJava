package generic;

import java.util.ArrayList;
import java.util.List;

class Product{}
class Tv extends Product{}
class Audio extends Product{}

public class Sample01 {

    public static void main(String[] args) {
//        ArrayList list = new ArrayList();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
//        list.add("3"); // 컴파일 error // 타입 체크가 강화됨

        Integer i = list.get(2); // 컴파일 ok

        System.out.println(list);

        ArrayList<Tv> tvList = new ArrayList<>();
        tvList.add(new Tv());
//        tvList.add(new Audio()); //  TV 객체만 저장 가능

        Tv tv = tvList.get(0);

        // 참조 변수와 생성자의 대인된 타입은 일치해야 한다.
        // 제네릭 클래스간의 다형성은 성립
        // 매개변수의 다형성도 성립

        List<Product> prdList = new ArrayList<>();

        prdList.add(new Tv());
        prdList.add(new Audio());

//        tvList.add(new Audio()); // error

        for (Product p : prdList){
            System.out.println(p);
        }

    }
}
