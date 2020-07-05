package step2.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionalExample1 {
    private static List<Person> list = Arrays.asList(
            new Person(1,"ȫ�浿", 90),
            new Person(2, "�ſ��", 30)
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
        System.out.println("[��� �̸�]");
        printString(Person::getName);
        System.out.println("[��� ���̵�]");
        printInt(Person::getId);
        System.out.println("[��� ����]");
        printInt(Person::getAge);
    }
}
