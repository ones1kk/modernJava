package lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sample05 {

    static class SampleUser {

        private String lastName;

        private String FirstName;

        public SampleUser(String lastName, String firstName) {
            this.lastName = lastName;
            FirstName = firstName;
        }

        public SampleUser() {

        }

        public SampleUser(String lastName) {
            this.lastName = lastName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFirstName() {
            return FirstName;
        }

        public void setFirstName(String firstName) {
            FirstName = firstName;
        }
    }

    public static void main(String[] args) {

        List<SampleUser> users = new ArrayList<>();

        SampleUser user1 = new SampleUser("홍", "길동");
        SampleUser user2 = new SampleUser("김", "유신");
        SampleUser user3 = new SampleUser("", "예");

        users.add(user1);
        users.add(user2);
        users.add(user3);

        users.removeIf(user -> user.getLastName().equals("홍"));
        users.forEach(user -> System.out.println(user.getFirstName() + user.getLastName()));

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // list의 모든 요소를 출력
        list.forEach(i -> System.out.print(i + ","));
        System.out.println();

        // list에서 2 또는 3의 배수를 제거한다.
        list.removeIf(x -> x % 2 == 0 || x % 3 == 0);
        System.out.println(list);

        list.replaceAll(i -> i * 10); // list의 각 요소에 10을 곱한다.
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        // map의 모든 요소를 {k,v}의 형식으로 출력한다.
        map.forEach((k, v) -> System.out.print("{" + k + "," + v + "},"));
        System.out.println();
    }

}
