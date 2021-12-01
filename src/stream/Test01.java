package stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

enum Sex {
    남자("Male", "male"),

    여자("Female", "여자");

    private String code;

    private String codeName;

    Sex(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
}

class Person {

    private String name;

    private Sex sex;

    private int age;

    private String phoneNumber;

    public Person() {
    }

    public Person(String name, Sex sex, int age, String phoneNumber) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", sex=" + sex +
            ", age=" + age +
            ", phoneNumber='" + phoneNumber + '\'' +
            '}';
    }
}

public class Test01 {

    public static void main(String[] args) {
        Integer [] intArr = {1,2,3,4,5};
        List<Integer> intList = Arrays.asList(1,2,3,4,5);
        Stream<Integer> integerStream1 = Stream.of(intArr);
        integerStream1.forEach(System.out::println);

        System.out.println();

        Stream<Integer> integerStream2 = intList.stream().filter((s) -> s>3);
        integerStream2.forEach(System.out::println);


        List<Person> personList = new ArrayList<>();
        personList.add(new Person("짱구", Sex.남자, 23, "010-1234-1234"));
        personList.add(new Person("유리", Sex.여자, 24, "010-2341-2341"));
        personList.add(new Person("철수", Sex.남자, 29, "010-3412-3412"));
        personList.add(new Person("맹구", Sex.남자, 25, null));

//        personList.forEach(System.out::println);

//        Map<String, Person> personMap = personList.stream()
//            .collect(Collectors.toMap(Person::getName, Function.identity()));

        Map<String, Person> personMap = personList.stream()
            .filter(person -> person.getAge() > 24) // 25살 이상만 골라낸다.
            .collect(Collectors.toMap(Person::getName, Function.identity()));


        personMap.forEach((k, v) -> System.out.println(k + "  " + v));

        Person[] array = {
            new Person("짱구", Sex.남자, 23, "010-1234-1234"),
            new Person("유리", Sex.여자, 24, "010-2341-2341"),
            new Person("철수", Sex.남자, 29, "010-3412-3412"),
            new Person("맹구", Sex.남자, 25, null)
        };

        Map<Sex, List<Person>> perBySex = Stream.of(array)
            .collect(groupingBy(Person::getSex));

        for(List<Person> per : perBySex.values()) {
            for(Person s : per) {
                System.out.println(s);
            }
        }

    }
}
