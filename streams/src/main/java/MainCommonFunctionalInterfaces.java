import bean.Person;

import java.util.function.*;

/**
 * Created by Nikolai_Shuvaev on 6/2/2017.
 */
public class MainCommonFunctionalInterfaces {
    public static void main(String[] args) {

        Consumer<String> stringConsumer = s -> {
            int length = s.length();
            System.out.println("Print length of " + length);
        };

        Function<Person, Integer> getAge = p -> {
            int consts = 600;
            return p.getAge() * consts;
        };

        Predicate<Person> checkPerson = p -> p.getAge() > 50 && p.getName().length() >= 20;

        Supplier<Person> supplier = () -> new Person("real person", 25);


        BiConsumer<Person, String> biConsumer = (p, s) -> {
            if (p != null) {
                p.setName(s);
            }
        };

        BiFunction<String, Integer, Person> personProducer = Person::new;
        BiPredicate<Integer, Person> biPredicate = (i, p) -> p.getAge() > i;



        stringConsumer.accept("  some string  ".trim());

        System.out.println("This is increased age " +
                getAge.apply(new Person("Test", 20)));

        System.out.println("Test predicate 1 = " +
            checkPerson.test(new Person("Short name", 30))
        );

        System.out.println("Test predicate 2 = " +
                checkPerson.test(new Person("This is looooooong name", 60))
        );

        System.out.println("Use supplier - " + supplier.get());

        Person person = new Person("", 20);
        biConsumer.accept(person, "new name");
        System.out.println("Bi supplier - " + person);

        System.out.println("Person producer - " + personProducer.apply("Producer Name", 22));

        System.out.println("Bi Predicate " + biPredicate.test(12, person));

    }
}
