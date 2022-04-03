package doodle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sample02{

    private final Set<Model> set;
    private final Map<String, Function<Model, String>[]> map = new HashMap<>();

    public List<String> list;

    public Sample02(Set<Model> set) {
        this.set = set;
    }

    public Sample02 add(String name, Function<Model, String> function, Function<Model, String> function2) {
        map.put(name, new Function[]{function, function2});
        foreach();
        return this;
    }

    private void foreach() {
        map.forEach((k,v) -> {
            Function<Model, String> keyFunc = v[0];
            Function<Model, String> valFunc = v[1];

            List<String> ids = this.set.stream().map(keyFunc).sorted().collect(Collectors.toList());
            List<String> names = this.set.stream().map(valFunc).sorted().collect(Collectors.toList());
            System.out.println("ids = " + ids);
            System.out.println("names = " + names);
            this.list = ids;
        });
    }

    public static void main(String[] args) {

        Set<Model> set = new HashSet<>();

        set.add(new Model("test1", "test", 10, Grade.F));
        set.add(new Model("test2", "test", 10, Grade.F));
        set.add(new Model("test3", "test", 10, Grade.F));
        set.add(new Model("test4", "test", 10, Grade.F));
        set.add(new Model("test5", "test", 10, Grade.F));

        Sample02 sample02 = new Sample02(set);

        sample02.add("first", Model::getId, Model::getName);

        Map<String, Function<Model, String>[]> map = sample02.map;
        List<String> list = sample02.list;
        System.out.println("list = " + list);
        System.out.println("map = " + map);

    }

    static class Model {

        private String id;

        private String name;

        private Integer age;

        private Grade grade;

        public Model(String id, String name, Integer age, Grade grade) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Grade getGrade() {
            return grade;
        }

        public void setGrade(Grade grade) {
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Model{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
        }
    }

    static enum Grade {
        A, B, C, D, F;
    }


}


