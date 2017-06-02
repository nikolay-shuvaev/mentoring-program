import bean.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by Nikolai_Shuvaev on 6/2/2017.
 */
public class MainForPersons {
    public static void main(String[] args) {
        BiFunction<String, Integer, Person> producer = Person::new;

        Person[] persons = {
                producer.apply("Name 1", 30),
                producer.apply("Name 5", 24),
                producer.apply("Name 4", 36),
                producer.apply("Name 2", 40),
                producer.apply("Name 3", 21),
        };

        Comparator<Person> byName = Comparator.comparing(Person::getName);
        Comparator<Person> byAge = Comparator.comparing(Person::getAge);



        Arrays.stream(persons).sorted(byName).forEach(System.out::println);
        System.out.println("------------------------");
        Arrays.stream(persons).sorted(byAge).forEach(System.out::println);
    }
}
