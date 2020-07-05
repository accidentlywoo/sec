package step2.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionalExample1 {
    private static List<Person> list = Arrays.asList(
            new Person(1,"홍길동", 90),
            new Person(2, "신용권", 30)
    );
    public static void printString(Function<Person, String> function){
        for(Person person : list){
            System.out.println(function.apply(person) + " ");
        }
        System.out.println();
    }

    public static void printInt(ToIntFunction<Person> function){
        for(Person person : list){
            System.out.println(function.applyAsInt(person) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("[사람 이름]");
        printString(Person::getName);
        System.out.println("[사람 아이디]");
        printInt(Person::getId);
        System.out.println("[사람 나이]");
        printInt(Person::getAge);
    }
}
