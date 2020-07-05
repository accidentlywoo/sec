package step2.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorReferenceExample {
    public static void main(String[] args) {
        Function<String , Member> function1 = Member::new;
        Member member1 = function1.apply("angel");
        System.out.println(member1);

        BiFunction<String, String, Member> function2 = Member :: new;
        Member member2 = function2.apply("¿Íµû¸Å","angel");
        System.out.println(member2);
    }
}
