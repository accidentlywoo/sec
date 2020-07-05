package step2.lambda;

import java.util.function.Predicate;

public class PredicateEqualExample {
    public static void main(String[] args) {
        Predicate<String> predicate;

        predicate = Predicate.isEqual(null);
        System.out.println("null, null �γ��ϳ�~ : " + predicate.test(null));

        predicate = Predicate.isEqual("java8");
        System.out.println("null, null �γ��ϳ�~ : " + predicate.test(null));

        predicate = Predicate.isEqual(null);
        System.out.println("null, null �γ��ϳ�~ : " + predicate.test("Java8"));

        predicate = Predicate.isEqual("java8");
        System.out.println("null, null �γ��ϳ�~ : " + predicate.test("java8"));

        predicate = Predicate.isEqual("java8");
        System.out.println("null, null �γ��ϳ�~ : " + predicate.test("java7"));
    }
}
