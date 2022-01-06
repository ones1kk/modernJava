package generic;

import java.util.ArrayList;

public class Sample04 {

    public static void main(String[] args) {

        FruitBox<? extends Fruit> fbox = new FruitBox<Fruit>();
        
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
        FruitBox<Apple> appleBox = new FruitBox<Apple>();

    }
}
