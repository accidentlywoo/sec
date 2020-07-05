package step2.lambda;

import java.util.function.Predicate;

public class PredicateEqualExample {
    public static void main(String[] args) {
        Predicate<String> predicate;

        predicate = Predicate.isEqual(null);
        System.out.println("null, null 確確馬革~ : " + predicate.test(null));

        predicate = Predicate.isEqual("java8");
        System.out.println("null, null 確確馬革~ : " + predicate.test(null));

        predicate = Predicate.isEqual(null);
        System.out.println("null, null 確確馬革~ : " + predicate.test("Java8"));

        predicate = Predicate.isEqual("java8");
        System.out.println("null, null 確確馬革~ : " + predicate.test("java8"));

        predicate = Predicate.isEqual("java8");
        System.out.println("null, null 確確馬革~ : " + predicate.test("java7"));
    }
}
