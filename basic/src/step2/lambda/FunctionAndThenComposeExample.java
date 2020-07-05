package step2.lambda;

import java.util.function.Function;

public class FunctionAndThenComposeExample {
    public static void main(String[] args) {
        Function<Member, Address> functionA;
        Function<Address, String> functionB;
        Function<Member, String> functionAB;
        String city;

        functionA = Member::getAddress;
        functionB = Address::getCity;

        functionAB = functionA.andThen(functionB);
        city = functionAB.apply(
                new Member("홍길동", "hong",new Address("한국","서울"))
        );
        System.out.println("거주 도시 : " + city);

        functionAB = functionB.compose(functionA);
        city = functionAB.apply(
                new Member("홍길순", "hong",new Address("한국","부산"))
        );
        System.out.println("거주 도시 : " + city);
    }
}
