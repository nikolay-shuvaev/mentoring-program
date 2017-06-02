import bean.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Nikolai_Shuvaev on 6/2/2017.
 */
public class MainFunctionalInterface {

    public static void main(String[] args) {
        MySimpleInterface<Person> sout = System.out::println;
        MySimpleInterface<Person> updatePersonName = p -> p.setName("New Name");

        sout.doProcess(new Person("Hello", 22));

        Person person = new Person("Hello", 22);
        updatePersonName.doProcess(person);
        System.out.println(person);
        System.out.println(sout.getLengthOfObjectStringRepresentation(person));
        System.out.println(sout.getLengthOfObjectStringRepresentation(Arrays.asList(person, person, person)));

        System.out.println("Is person older than - " + MySimpleInterface.isPersonOlderThan(person, 30));

        System.out.println("----------------------");

        MySimpleInterface<Person> soutInnerClass = new MySimpleInterface<Person>() {
            @Override
            public void doProcess(Person person) {
                System.out.println(person);
            }
        };


        MySimpleInterface<Person> updateInnerClass = new MySimpleInterface<Person>() {
            @Override
            public void doProcess(Person person) {
                person.setName("New Name");
            }
        };

        soutInnerClass.doProcess(new Person("Hello", 22));

        person = new Person("Hello", 22);
        updateInnerClass.doProcess(person);
        System.out.println(person);


    }

    @FunctionalInterface
    public interface MySimpleInterface<T> {
        void doProcess(T t);

        default Integer getLengthOfObjectStringRepresentation(T t) {
            return t.toString().length();
        }

        default Integer getLengthOfObjectStringRepresentation(List<T> t) {
            return t.stream()
                    .mapToInt(e -> e.toString().length())
                    .sum();
        }


        static boolean isPersonOlderThan(Person p, Integer age) {
            return p.getAge() > age;
        }
    }

}
