import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import lombok.Getter;

public class GroupingByTest {
    @Getter
    static class Person {

        private final int age;
        private final String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
        }
    }

    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person(10, "나"),
            new Person(20, "너"),
            new Person(10, "얘"),
            new Person(10, "쟤")
        );

        Map<Integer, Integer> map = people.stream()
            .collect(Collectors.groupingBy(Person::getAge,
                Collector.of(() -> new int[1], (arr, i) -> arr[0] += 1, (arr1, arr2) -> {
                    arr1[0] += arr2[0];
                    return arr1;
                }, arr -> arr[0]))
            );

        System.out.println(map);
    }
}
